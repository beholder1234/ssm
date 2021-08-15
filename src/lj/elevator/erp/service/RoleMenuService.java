package lj.elevator.erp.service;

import java.util.List;

import lj.elevator.erp.pojo.RoleMenu;

public interface RoleMenuService {

	List<RoleMenu> getMenuList(Integer roleId);

	void deleteByRoleId(Integer roleId);

	void setRoleMenu(Integer[] array, Integer roleId);

}
