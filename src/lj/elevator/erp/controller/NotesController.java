package lj.elevator.erp.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.service.NotesService;

@Controller
public class NotesController {

	@Autowired
	private NotesService notesService;

	@RequestMapping("notesList")
	public String notesList(Model model) {

		// Emp id set 为 1
		Emp emp = (Emp) SecurityUtils.getSubject().getPrincipal();
		List<Business> businesses = notesService.getBusinessList(emp.getId());
		List<Storedetail> storedetails = notesService.getStoreAlertList();
		System.out.println("业务数量：" + businesses.size());
		model.addAttribute("businesses", businesses);
		model.addAttribute("storedetails", storedetails);

		System.out.println(storedetails.size());
		return "jsp/notes_list.jsp";
	}

	@RequestMapping("index")
	public String index(Model model) {

		return "index.jsp";

	}
}
