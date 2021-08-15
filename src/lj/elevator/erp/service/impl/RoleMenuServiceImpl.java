package lj.elevator.erp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.RoleMenuMapper;
import lj.elevator.erp.pojo.Menu;
import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.pojo.RoleMenuExample;
import lj.elevator.erp.pojo.RoleMenuExample.Criteria;
import lj.elevator.erp.service.MenuService;
import lj.elevator.erp.service.RoleMenuService;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Autowired
	private RoleMenuMapper mapper;
	@Autowired
	private MenuService menuService;

	@Override
	public List<RoleMenu> getMenuList(Integer roleId) {

		List<RoleMenu> roleMenus = mapper.getMenuList(roleId);

		return roleMenus;
	}

	@Override
	public void deleteByRoleId(Integer roleId) {

		RoleMenuExample example = new RoleMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		mapper.deleteByExample(example);
	}

	@Override
	public void setRoleMenu(Integer[] array, Integer roleId) {

		this.deleteByRoleId(roleId);

		List<Integer> list = new ArrayList<Integer>();
		// -1：表为一级菜单。其余值：二级菜单。对应数据库的Menu表的PID
		for (Integer integer : array) {
			if (integer != -1) {
				list.add(integer);
				Menu menu = menuService.selectByKey(integer);
				if (!menu.getPid().equals(-1)) {
					if (list.indexOf(menu.getPid()) == -1) {
						list.add(menu.getPid());
					}

				}

			}
		}
		Collections.sort(list);

		for (Integer menuId : list) {

			RoleMenu rMenu = new RoleMenu();
			rMenu.setMenuid(menuId);
			rMenu.setRoleid(roleId);
			mapper.insert(rMenu);
		}

		// System.out.println(list.toString());
	}
}
