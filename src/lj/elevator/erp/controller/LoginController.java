package lj.elevator.erp.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Dep;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.Role;
import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.service.DepService;
import lj.elevator.erp.service.EmpRoleService;
import lj.elevator.erp.service.LoginService;
import lj.elevator.erp.service.RoleService;
import lj.elevator.erp.utils.MD5Utils;

@Controller
@SessionAttributes(value = { "deps", "roles", "goodstypes", "suppliers", "stores", "ordertypes", "orderStates",
		"orderdetailStates", "businessTypes", "businessWorkTypes", "businessStates", "roleMenus", "oneRole",
		"equipmentStates", "equipmentNames" })
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private EmpRoleService empRoleService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepService depService;

	@RequestMapping("login")
	public String login(String username, String password, Model model) {

		System.out.println(username);
		System.out.println(password);
		String pwd = MD5Utils.encrypt(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
		System.out.println("after new token");

		Subject subject = SecurityUtils.getSubject();

		System.out.println("hold...");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return "login.jsp";
			// 身份验证失败
		}

		System.out.println("进页面...");

		Emp emp = (Emp) SecurityUtils.getSubject().getPrincipal();

		// 之后改为系统启动时运行的方法
		this.loadInitialData(model);
		this.insertBusiness();
		this.getMenuListByRoleId(emp, model);

		return "main.jsp";
	}

	private void getMenuListByRoleId(Emp emp, Model model) {

		// emp.getRoleId(); 暂设为1

		Integer roleId = empRoleService.getRoleIdByEmpId(emp.getId());
		List<RoleMenu> roleMenus = loginService.getMenuList(roleId);
		Role role = roleService.getRoleByEmpId(emp.getId());
		emp.setRole(role);

		Dep dep = depService.geDepByKey(emp.getDepid());
		emp.setDep(dep);
		model.addAttribute("roleMenus", roleMenus);
		model.addAttribute("oneRole", emp);
	}

	private void loadInitialData(Model model) { // 多余了，WebContextListener.java监听器中已经初始化过了

		System.out.println("Im out...");
		Map<String, Object> map = loginService.getLoadInDate();

		model.addAttribute("deps", map.get("deps"));
		model.addAttribute("roles", map.get("roles"));
		model.addAttribute("goodstypes", map.get("goodstypes"));
		model.addAttribute("stores", map.get("stores"));
		model.addAttribute("ordertypes", map.get("ordertypes"));
		model.addAttribute("orderStates", map.get("orderStates"));
		model.addAttribute("orderdetailStates", map.get("orderdetailStates"));
		model.addAttribute("equipmentNames", map.get("equipmentNames"));
		model.addAttribute("equipmentStates", map.get("equipmentStates"));
		model.addAttribute("businessTypes", map.get("businessTypes"));
		model.addAttribute("businessWorkTypes", map.get("businessWorkTypes"));
		model.addAttribute("businessStates", map.get("businessStates"));

	};

	// 对象business的安检，年审业务进行创建(如果未创建目标equipment的话)，之后改为系统启动每天运行一次。
	private void insertBusiness() {
		loginService.insertBusiness();
	}

}
