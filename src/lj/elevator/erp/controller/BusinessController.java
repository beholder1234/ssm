package lj.elevator.erp.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.service.BusinessService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page" })
public class BusinessController {

	@Autowired
	private BusinessService businessService;

	@RequestMapping("businessList")
	public String businessList(Page<Business> page, String businesstypeS, String businessstateS, String customerS,
			String numS, String codeS, String beTimeS, String endTimeS, Model model) throws Exception {

		String[] targets = new String[] { businesstypeS, businessstateS, customerS, numS, codeS, beTimeS, endTimeS };
		page = businessService.getBusinessList(page, targets);
		model.addAttribute("page", page);
		return "/jsp/business_list.jsp";

	}

	@RequestMapping("businessAssignList")
	public String businessAssignList(Page<Business> page, String businesstypeS, String customerS, String numS,
			String codeS, Model model) throws Exception {

		String[] targets = new String[] { businesstypeS, "1", customerS, numS, codeS, null, null };

		page = businessService.getBusinessList(page, targets);
		model.addAttribute("page", page);
		return "/jsp/business_assign.jsp";

	}

	@RequestMapping("businessDealWith")
	public String businessDealWith(Page<Business> page, String businesstypeS, String businessstateS, String customerS,
			String numS, String codeS, Model model) throws Exception {

		System.out.println("IN");
		String[] targets = new String[] { businesstypeS, businessstateS, customerS, numS, codeS, null, null };
		System.out.println("In SE");
		page = businessService.getBusinessList(page, targets);
		model.addAttribute("page", page);
		return "/jsp/business_dealWith.jsp";

	}

	/*
	 * @RequestMapping("businessAssign") public String
	 * businessAssign(Page<Business> page, String which, String businesstypeS,
	 * String businessstateS, String customerS, String numS, String codeS,
	 * String beTimeS, String endTimeS, Model model) throws Exception {
	 * 
	 * if (which == null) { CookieUtil cUtil = new CookieUtil(); which =
	 * cUtil.getCookieByKey("which"); }
	 * 
	 * switch (which) { case "businessList": { String[] targets = new String[] {
	 * businesstypeS, businessstateS, customerS, numS, codeS, beTimeS, endTimeS
	 * };
	 * 
	 * page = businessService.getBusinessList(page, targets);
	 * model.addAttribute("page", page); return "/jsp/business_list.jsp"; } case
	 * "businessAssign": { String[] targets = new String[] { businesstypeS, "1",
	 * customerS, numS, codeS, null, null };
	 * 
	 * page = businessService.getBusinessList(page, targets);
	 * model.addAttribute("page", page); return "/jsp/business_assign.jsp";
	 * 
	 * } case "businessDealWith": { System.out.println("IN"); String[] targets =
	 * new String[] { businesstypeS, businessstateS, customerS, numS, codeS,
	 * null, null }; System.out.println("In SE"); page =
	 * businessService.getBusinessList(page, targets);
	 * model.addAttribute("page", page); return "/jsp/business_dealWith.jsp"; }
	 * 
	 * default: break; } model.addAttribute("page", page); return
	 * "/jsp/business_list.jsp";
	 * 
	 * }
	 */

	@RequestMapping("getBusinessdetailList")
	public @ResponseBody Business getBusinessdetailList(Integer businessId) {
		Business business = businessService.getBusinessdetailList(businessId);
		// System.out.println(business.getBusinessemprecords().get(0).getEmp().getName());
		return business;

	}

	@RequestMapping("businessAssign")
	public String businessAssign(Emp oneEmp, Integer businessId, Integer[] empIds) {
		// Emp oneEmp为当前登录该系统的用户的session级的对象,此处使用它,目的让其作为分派工作的类型,set business表的
		// wortype=2
		// 之后用shiro获取该对象的方式会变

		System.out.println("Im In ");
		// 分配工作的emp的id此处暂定为 1 ，
		Emp emp = (Emp) SecurityUtils.getSubject().getPrincipal();
		businessService.insertBusinessAssign(emp.getId(), businessId, empIds);

		return "/jsp/business_list.jsp";

	}

	@RequestMapping("updateBusinessToOn")
	public @ResponseBody boolean updateBusinessToOn(Integer businessId, Model model) {

		// updateBusinessToOn
		// updateBusinessToFinish
		boolean bool = businessService.updateBusinessToOn(businessId);
		return bool;

	}

	@RequestMapping("updateBusinessToFinish")
	public @ResponseBody boolean updateBusinessToFinish(Integer businessId, Model model) {

		boolean bool = businessService.updateBusinessToFinish(businessId);
		return bool;

		// model.addAttribute("page", page);
	}

}
