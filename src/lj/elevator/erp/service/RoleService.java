package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.Menu;
import lj.elevator.erp.pojo.Role;
import lj.elevator.erp.pojo.RoleMenu;

public interface RoleService {

	List<Role> getRoleByName(String roleName);

	List<Role> getRole();

	Role getRoleByEmpId(Integer empid);

	List<Menu> getMenuList();

	List<RoleMenu> getMenuListByRoleId(Integer roleId);

	void setRoleMenu(Integer[] array, Integer roleId);

}
