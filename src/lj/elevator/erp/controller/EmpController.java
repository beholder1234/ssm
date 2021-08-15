package lj.elevator.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Dep;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.Role;
import lj.elevator.erp.service.DepService;
import lj.elevator.erp.service.EmpService;
import lj.elevator.erp.service.RoleService;
import lj.elevator.erp.utils.CookieUtil;
import lj.elevator.erp.utils.Page;

@Controller
// @RequestMapping("emp")
@SessionAttributes(value = { "page" })
public class EmpController {

	@Autowired
	private EmpService empService;

	@Autowired
	private DepService depService;

	@Autowired
	private RoleService roleService;

	// @Value("${a}")
	// String aString;

	@RequestMapping("name")
	public String name(String id) {
		System.out.println(id);
		if (id == null) {
			System.out.println("1111111111");
		}

		System.out.println("name  in...");
		// System.out.println(aString);
		System.out.println("name  out...");
		return "/jsp/emp.jsp";
	}

	@RequestMapping("empList")
	public String empList(Page<Emp> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		if (page.getRows() != null) {
			System.out.println("大小：" + page.getRows().size());
			// System.out.println(page.getRows().get(0).getClass());

		}
		new CookieUtil("empList.action");

		// System.out.println(target == null);

		page = empService.getEmpList(page, target);

		model.addAttribute("page", page);
		return "/jsp/emp_list.jsp";
		// return "main.jsp";
	}

	@RequestMapping("empList2")
	public String empList2(Page<Emp> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		if (page.getRows() != null) {
			System.out.println("大小：" + page.getRows().size());
			// System.out.println(page.getRows().get(0).getClass());
			System.out.println(page.getRows().get(0) == null);
		}
		new CookieUtil("empList.action");

		// System.out.println(target == null);

		page = empService.getEmpList(page, target);

		model.addAttribute("page", page);
		return "/jsp/emp_list2.jsp";
		// return "main.jsp";
	}

	@RequestMapping("empList3")
	public String empList3(Page<Emp> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		if (page.getRows() != null) {
			System.out.println("大小：" + page.getRows().size());
			// System.out.println(page.getRows().get(0).getClass());
			System.out.println(page.getRows().get(0) == null);
		}
		new CookieUtil("empList.action");

		// System.out.println(target == null);

		page = empService.getEmpList(page, target);

		model.addAttribute("page", page);
		return "/jsp/account_list.jsp";
		// return "main.jsp";
	}

	@RequestMapping("getEmpDetail")
	public @ResponseBody Emp getEmpDetail(Page<Emp> page, Integer empId) {

		// System.out.println(page.getTotal());
		List<Emp> emps = page.getRows();
		for (Emp emp : emps) {
			if (emp.getId().equals(empId)) {
				System.out.println(emp.getId());
				return emp;
			}

		}
		return null;

	}

	@RequestMapping("saveEmp")
	public @ResponseBody String saveEmp(Page<Emp> page, Integer empId, String tele, String email, String depName,
			String roleName, Model model) {
		System.out.println("EmpId=" + empId + " " + depName + "  " + roleName);
		Page<Emp> newPage = empService.saveEmp(page, empId, tele, email, depName, roleName);
		model.addAttribute("page", newPage);
		System.out.println("saveEmp Out...");
		return null;
	}

	@RequestMapping("deleteEmpById")
	public @ResponseBody Integer deleteEmpById(Page<Emp> page, Integer empId, Model model) {

		System.out.println("delete");
		Page<Emp> page2 = empService.deleteEmpById(page, empId);
		model.addAttribute("page", page2);

		return empId;
	}

	public void insertEmp(Page<Emp> page, Emp emp, Model model) {

		Page<Emp> page2 = empService.insertEmp(page, emp);

		model.addAttribute("page", page2);

		return;

	}

	@RequestMapping("getEmpName")
	public @ResponseBody List<String> getEmpName() {

		List<String> empName = empService.getEmpName();

		return empName;

	}

	@RequestMapping("empAdd")
	public String empAdd() {

		return "jsp/emp_add.jsp";

	}

	@RequestMapping("getUsername")
	public @ResponseBody List<String> getUsername() {

		List<String> data = empService.getUsername();
		return data;

	}

	@RequestMapping("insertEmp")
	public String insertEmp(Emp emp, String depName, String roleName) {

		System.out.println(empAdd().equals(null));
		System.out.println(depName);
		System.out.println(roleName);
		List<Dep> deps = depService.getDepByName(depName);

		List<Role> roles = roleService.getRoleByName(roleName);
		emp.setDepid(deps.get(0).getId());
		empService.insertEmp(emp, roles.get(0).getId());
		return "jsp/emp_add.jsp";
	}

	@RequestMapping("accountSettingList")
	public String accountSettingList() {

		return "jsp/account_list.jsp";

	}

	@RequestMapping("resetPwd")
	public String resetPwd(Integer id) {

		empService.resetPwd(id);

		return "jsp/account_list.jsp";

	}

	@RequestMapping("pwdChangeList")
	public String pwdChangeList() {

		return "jsp/password_change.jsp";
	}

	@RequestMapping("changePwd")
	public String changePwd(Emp oneRole, String originPwd, String newPwd, String newPwd2, Model model) {
		if (empService.changePwd(oneRole, originPwd, newPwd, newPwd2)) {

			model.addAttribute("PwdChangeResponse", true);
		} else {

			model.addAttribute("PwdChangeResponse", false);

		}
		return "jsp/password_change.jsp";
	}

	@RequestMapping("personalList")
	public String personalList() {

		return "jsp/personal_list.jsp";
		// return "forward:jsp/personal_list.jsp";
	}

}
