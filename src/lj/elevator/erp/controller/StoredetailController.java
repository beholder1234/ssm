package lj.elevator.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.service.StoredetailService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page" })
public class StoredetailController {

	@Autowired
	private StoredetailService storedetailService;

	@RequestMapping("storedetailList")
	public String storedetailList(Page<Storedetail> page, String storeS, String gtypeS, String supplierS, String goodsS,
			String modelS, Model model) throws Exception {

		String[] targets = new String[] { storeS, gtypeS, supplierS, goodsS, modelS };

		page = storedetailService.getStoredetailList(page, targets);

		return "/jsp/storedetail_list.jsp";

	}

}
