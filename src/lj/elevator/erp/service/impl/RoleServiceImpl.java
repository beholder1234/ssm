package lj.elevator.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.RoleMapper;
import lj.elevator.erp.pojo.Menu;
import lj.elevator.erp.pojo.Role;
import lj.elevator.erp.pojo.RoleExample;
import lj.elevator.erp.pojo.RoleExample.Criteria;
import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.service.EmpRoleService;
import lj.elevator.erp.service.MenuService;
import lj.elevator.erp.service.RoleMenuService;
import lj.elevator.erp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private EmpRoleService empRoleService;

	@Autowired
	private RoleMenuService rMService;

	@Autowired
	private MenuService menuService;

	@Override
	public List<Role> getRoleByName(String roleName) {
		RoleExample roleExample = new RoleExample();
		Criteria criteria = roleExample.createCriteria();
		criteria.andNameEqualTo(roleName);
		System.out.println(roleName);
		List<Role> roles = roleMapper.selectByExample(roleExample);

		return roles;
	}

	@Override
	public List<Role> getRole() {

		List<Role> roles = roleMapper.select();
		return roles;
	}

	@Override
	public Role getRoleByEmpId(Integer empid) {
		Integer id = empRoleService.getRoleIdByEmpId(empid);
		Role role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

	@Override
	public List<Menu> getMenuList() {

		List<Menu> menus = menuService.select();
		return menus;
	}

	@Override
	public List<RoleMenu> getMenuListByRoleId(Integer roleId) {
		List<RoleMenu> roleMenus = rMService.getMenuList(roleId);
		return roleMenus;
	}

	@Override
	public void setRoleMenu(Integer[] array, Integer roleId) {

		rMService.setRoleMenu(array, roleId);

	}

}
