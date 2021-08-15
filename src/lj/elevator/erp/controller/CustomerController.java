package lj.elevator.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.service.CustomerService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page", "oralUrl" })
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("customerList")
	public String customerList(Page<Customer> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		page = customerService.getCustomerList(page, target);

		model.addAttribute("page", page);
		model.addAttribute("oralUrl", "customer_list.jsp");

		// System.out.println("controller Customer:" +
		// page.getRows().get(0).getName());
		return "/jsp/customer_list.jsp";

		// return "/main.jsp";

	}

	@RequestMapping("customerList2")
	public String customerList2(Page<Customer> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		page = customerService.getCustomerList(page, target);

		model.addAttribute("page", page);

		// System.out.println("controller Customer:" +
		// page.getRows().get(0).getName());
		return "/jsp/customer_list.jsp";

	}

	@RequestMapping("getCustomer")
	public @ResponseBody Customer getCustomer(Page<Customer> page, Integer customerId) {

		List<Customer> customers = page.getRows();
		for (Customer customer : customers) {
			if (customer.getId().equals(customerId)) {
				return customer;
			}
		}

		return null;

	}

	@RequestMapping("saveCustomer")
	public @ResponseBody void saveCustomer(Customer customer, Model model) {

		// System.out.println("aa");
		// System.out.println("saveCustomer" + customer.getAddress());

		Page<Customer> page = customerService.saveCustomer(customer);

		model.addAttribute("page", page);

		return;

	}

	@RequestMapping("deleteCustomerById")
	public @ResponseBody void deleteCustomerById(Integer customerId, Model model) {

		Page<Customer> page = customerService.deleteCustomerById(customerId);

		model.addAttribute("page", page);

		return;
	}

	@RequestMapping("insertCustomer")
	public String insertCustomer(Customer customer, Model model) {
		System.out.println("Im in");
		System.out.println(customer.getId() + " " + customer.getName());
		Page<Customer> page = customerService.insert(customer);

		return "/jsp/customer_list.jsp";
	}

	@RequestMapping("getSupplierName")
	public @ResponseBody List<String> getSupplierName() {

		List<String> list = customerService.getSupplierName();
		System.out.println("list" + list.size());
		return list;
	}

	@RequestMapping("getCustomerName")
	public @ResponseBody List<String> getCustomerName() {

		List<String> list = customerService.getCustomerName();
		return list;

	}
}
