package lj.elevator.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lj.elevator.erp.pojo.Menu;
import lj.elevator.erp.pojo.RoleMenu;
import lj.elevator.erp.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("perSettingList")
	public String perSettingList(Model model) {

		List<Menu> menuList = roleService.getMenuList();

		model.addAttribute("menuList", menuList);

		return "/jsp/perSetting_list.jsp";

	}

	@RequestMapping("getRoleMenuList")
	public @ResponseBody List<RoleMenu> getRoleMenuList(Integer roleId) {

		List<RoleMenu> data = roleService.getMenuListByRoleId(roleId);

		return data;

	}

	@RequestMapping("getMenuListForSetting")
	public @ResponseBody List<Menu> getMenuListForSetting() {

		List<Menu> data = roleService.getMenuList();
		return data;

	}

	@RequestMapping("setRoleMenu")
	public @ResponseBody void setRoleMenu(Integer[] array, Integer roleId) {

		roleService.setRoleMenu(array, roleId);
		return;
	}

}
