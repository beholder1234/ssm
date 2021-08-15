package lj.elevator.erp.utils;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import lj.elevator.erp.mapper.EmpMapper;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.EmpExample;
import lj.elevator.erp.pojo.EmpExample.Criteria;
import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.service.EmpRoleService;
import lj.elevator.erp.service.RoleMenuService;

public class EmpRealm extends AuthorizingRealm {

	@Autowired
	private EmpMapper empMapper;

	@Autowired
	private EmpRoleService empRoleService;

	@Autowired
	private RoleMenuService roleMenuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权...");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Emp emp = (Emp) principals.getPrimaryPrincipal();
		// List<RoleMenu> roleMenus = loginService.getMenuList(emp.getDepid());
		Integer roleId = empRoleService.getRoleIdByEmpId(emp.getId());
		List<RoleMenu> roleMenus = roleMenuService.getMenuList(roleId);

		for (RoleMenu roleMenu : roleMenus) {
			info.addStringPermission(roleMenu.getMenu().getMenuname());
		}

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证...");

		/*
		 * UsernamePasswordToken upt = (UsernamePasswordToken) token; return new
		 * SimpleAuthenticationInfo(new Emp(), upt.getPassword(),
		 * upt.getUsername());
		 */

		UsernamePasswordToken upt = (UsernamePasswordToken) token;

		/* String pwd = MD5Utils.encrypt(new String(upt.getPassword())); */
		String pwd = new String(upt.getPassword());
		String username = upt.getUsername();
		System.out.println("密码：" + pwd);
		/*
		 * pwd = pwd.replace(" ", ""); username = username.replace(" ", "");
		 */

		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andPwdEqualTo(pwd);
		criteria.andUsernameEqualTo(username);

		List<Emp> emps = empMapper.selectByExample(example);
		if (emps.size() != 0) {
			System.out.println("获取了");

			return new SimpleAuthenticationInfo(emps.get(0), pwd, username);

		} else
			return null;

	}

}
