package lj.elevator.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.service.SupplierService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page" })
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@RequestMapping("supplierList")
	public String supplierList(Page<Supplier> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		page = supplierService.getSupplierList(page, target);

		model.addAttribute("page", page);

		// System.out.println("controller Supplier:" +
		// page.getRows().get(0).getName());
		// return "/jsp/supplier_list.jsp";
		return "/jsp/supplier_list.jsp";

	}

	@RequestMapping("supplierList2")
	public String supplierList2(Page<Supplier> page, String target, Model model) throws Exception {

		System.out.println("controller.....");
		page = supplierService.getSupplierList(page, target);

		model.addAttribute("page", page);

		// System.out.println("controller Supplier:" +
		// page.getRows().get(0).getName());
		return "/jsp/supplier_list.jsp";

	}

	@RequestMapping("getSupplier")
	public @ResponseBody Supplier getSupplier(Page<Supplier> page, Integer supplierId) {

		List<Supplier> suppliers = page.getRows();
		for (Supplier supplier : suppliers) {
			if (supplier.getId().equals(supplierId)) {
				return supplier;
			}
		}

		return null;

	}

	@RequestMapping("saveSupplier")
	public @ResponseBody void saveSupplier(Supplier supplier, Model model) {

		// System.out.println("aa");
		// System.out.println("saveSupplier" + supplier.getAddress());

		Page<Supplier> page = supplierService.saveSupplier(supplier);

		model.addAttribute("page", page);

		return;

	}

	@RequestMapping("deleteSupplierById")
	public @ResponseBody void deleteSupplierById(Integer supplierId, Model model) {

		Page<Supplier> page = supplierService.deleteSupplierById(supplierId);

		model.addAttribute("page", page);

		return;
	}

	@RequestMapping("insertSupplier")
	public String insertSupplier(Supplier supplier, Model model) {
		System.out.println("Im in");
		System.out.println(supplier.getId() + " " + supplier.getName());
		Page<Supplier> page = supplierService.insert(supplier);

		return "/jsp/supplier_list.jsp";
	}

	@RequestMapping("getAllSupplier")
	public @ResponseBody List<Supplier> getAllSupplier() {

		List<Supplier> suppliers = supplierService.getSupplier();

		return suppliers;

	}

}
