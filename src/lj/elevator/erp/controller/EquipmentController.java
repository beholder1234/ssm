package lj.elevator.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.service.EquipmentService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page" })
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@RequestMapping("equipmentList")
	public String equipmentList(Page<Equipment> page, String num, String code, String name, String customerName,
			String state, Model model) throws Exception {

		String[] targets = new String[] { num, code, name, customerName, state };

		page = equipmentService.getEquipmentList(page, targets);

		model.addAttribute("page", page);
		return "/jsp/equipment_list.jsp";
	}

	@RequestMapping("getEquipmentDetail")
	public @ResponseBody Equipment getEquipmentDetail(Integer eqId) {

		Equipment equipment = equipmentService.getEquipmentByKey(eqId);
		return equipment;

	}
}
