package lj.elevator.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.service.CustomerService;
import lj.elevator.erp.service.EmpService;
import lj.elevator.erp.service.GoodsService;
import lj.elevator.erp.service.OrderService;
import lj.elevator.erp.service.SupplierService;
import lj.elevator.erp.utils.Page;

@Controller
@SessionAttributes(value = { "page" })
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private EmpService empService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping("orderList")
	public String orderList(Page<Order> page, String ordertypeS, String orderstateS, String supplierS, String customerS,
			String Emp1S, String Emp2S, String Emp3S, String beTimeS, String finalTimeS, Model model) throws Exception {

		String[] targets = new String[] { ordertypeS, orderstateS, supplierS, customerS, Emp1S, Emp2S, Emp3S, beTimeS,
				finalTimeS };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/order_list.jsp";

	}

	@RequestMapping("orderPList")
	public String orderPList(Page<Order> page, String orderstateS, String supplierS, String customerS, String Emp1S,
			String Emp2S, String Emp3S, String beTimeS, String finalTimeS, Model model) throws Exception {

		String[] targets = new String[] { "1", orderstateS, supplierS, customerS, Emp1S, Emp2S, Emp3S, beTimeS,
				finalTimeS };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/order_list.jsp";

	}

	@RequestMapping("orderSList")
	public String orderSList(Page<Order> page, String orderstateS, String supplierS, String customerS, String Emp1S,
			String Emp2S, String Emp3S, String beTimeS, String finalTimeS, Model model) throws Exception {

		String[] targets = new String[] { "2", orderstateS, supplierS, customerS, Emp1S, Emp2S, Emp3S, beTimeS,
				finalTimeS };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/order_list.jsp";

	}

	@RequestMapping("orderPCheckList")
	public String orderPCheckList(Page<Order> page, String supplierS, String Emp1S, Model model) throws Exception {

		String[] targets = new String[] { "1", "1", supplierS, null, Emp1S, null, null, null, null };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/orderP_check.jsp";

	}

	@RequestMapping("orderPPurchaseList")
	public String orderPPurchaseList(Page<Order> page, String supplierS, String Emp1S, String Emp2S, Model model)
			throws Exception {

		String[] targets = new String[] { "1", "2", supplierS, null, Emp1S, Emp2S, null, null, null };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/orderP_purchase.jsp";

	}

	@RequestMapping("orderSCheckList")
	public String orderSCheckList(Page<Order> page, String customerS, String Emp1S, Model model) throws Exception {

		String[] targets = new String[] { "2", "1", null, customerS, Emp1S, null, null, null, null };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/orderS_check.jsp";

	}

	@RequestMapping("orderSGetGoodsList")
	public String orderSGetGoodsList(Page<Order> page, String customerS, String Emp1S, String Emp2S, Model model)
			throws Exception {

		String[] targets = new String[] { "2", "3", null, customerS, Emp1S, Emp2S, null, null, null };

		page = orderService.getOrderList(page, targets);
		System.out.println("Im getting Out Now");
		return "/jsp/orderS_getGoods.jsp";

	}

	@RequestMapping("orderStoreChange")
	public String orderStoreChange(Page<Order> page, String orderstateS, String Emp1S, String Emp2S, String Emp3S,
			Model model) throws Exception {

		if (orderstateS == null) {
			orderstateS = "4";
		}
		if (page == null) {
			page.setSize(2);
		}

		String[] targets = new String[] { null, orderstateS, null, null, Emp1S, Emp2S, Emp3S, null, null };
		page = orderService.getOrderList(page, targets);

		page = orderService.setOrderdetail(page);

		System.out.println("Im getting Out Now");
		return "/jsp/order_storeChange.jsp";

	}

	/*
	 * @RequestMapping("orderList") public String orderList(Page<Order> page,
	 * String which, String ordertypeS, String orderstateS, String supplierS,
	 * String customerS, String Emp1S, String Emp2S, String Emp3S, String
	 * beTimeS, String finalTimeS, Model model) throws Exception {
	 * 
	 * if (which == null) { CookieUtil cUtil = new CookieUtil(); which =
	 * cUtil.getCookieByKey("which"); System.out.println(which == null); }
	 * 
	 * switch (which) { case "orderList": {
	 * 
	 * String[] targets = new String[] { ordertypeS, orderstateS, supplierS,
	 * customerS, Emp1S, Emp2S, Emp3S, beTimeS, finalTimeS };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/order_list.jsp"; } case "orderPList":
	 * {
	 * 
	 * String[] targets = new String[] { "1", orderstateS, supplierS, customerS,
	 * Emp1S, Emp2S, Emp3S, beTimeS, finalTimeS };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/order_list.jsp"; } case "orderSList":
	 * {
	 * 
	 * String[] targets = new String[] { "2", orderstateS, supplierS, customerS,
	 * Emp1S, Emp2S, Emp3S, beTimeS, finalTimeS };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/order_list.jsp"; } case
	 * "orderPCheckList": {
	 * 
	 * String[] targets = new String[] { "1", "1", supplierS, null, Emp1S, null,
	 * null, null, null };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/orderP_check.jsp"; } case
	 * "orderPPurchaseList": {
	 * 
	 * String[] targets = new String[] { "1", "2", supplierS, null, Emp1S,
	 * Emp2S, null, null, null };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/orderP_purchase.jsp"; } case
	 * "orderSCheckList": {
	 * 
	 * String[] targets = new String[] { "2", "1", null, customerS, Emp1S, null,
	 * null, null, null };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/orderS_check.jsp"; } case
	 * "orderSGetGoodsList": {
	 * 
	 * String[] targets = new String[] { "2", "3", null, customerS, Emp1S,
	 * Emp2S, null, null, null };
	 * 
	 * page = orderService.getOrderList(page, targets); System.out.println(
	 * "Im getting Out Now"); return "/jsp/orderS_getGoods.jsp"; } case
	 * "orderStoreChange": { if (orderstateS == null) { orderstateS = "4"; } if
	 * (page == null) { page.setSize(2); }
	 * 
	 * String[] targets = new String[] { null, orderstateS, null, null, Emp1S,
	 * Emp2S, Emp3S, null, null }; page = orderService.getOrderList(page,
	 * targets);
	 * 
	 * page = orderService.setOrderdetail(page);
	 * 
	 * System.out.println("Im getting Out Now"); return
	 * "/jsp/order_storeChange.jsp"; } default:
	 * 
	 * return null; }
	 * 
	 * }
	 */

	@RequestMapping("saleOrderAddList")
	public String saleOrderAddList() {

		return "/jsp/orderS_add.jsp";
	}

	@RequestMapping("purOrderAddList")
	public String purOrderAddList() {

		return "/jsp/orderP_add.jsp";
	}

	@RequestMapping("getorderdetailList")
	public @ResponseBody Order getorderdetailList(Page<Order> page, Integer orderId, Model model) {

		System.out.println(orderId);
		System.out.println("order Not NUll");
		Order order = orderService.setOrderdetail(page, orderId);

		return order;

	}

	@RequestMapping("getSupplierByNameAndContact")
	public @ResponseBody Supplier getSupplierByNameAndContact(String supplierName, String supplierContact) {

		List<Supplier> suppliers = supplierService.selectByNameAndContact(supplierName, supplierContact);
		if (suppliers.size() != 0) {
			return suppliers.get(0);
		}
		return null;

	}

	@RequestMapping("getEmpByName")
	public @ResponseBody Emp getEmpByName(String empName) {

		Emp emp = empService.getEmpByName(empName);

		return emp;

	}

	@RequestMapping("insertSupplierByOrderAdd")
	public @ResponseBody Supplier insertSupplierByOrderAdd(Supplier supplier) {

		supplier = supplierService.insertByOrderAdd(supplier);

		return supplier;

	}

	@RequestMapping("getGoodsNameBySuppIdAndGNameAndGModel")
	public @ResponseBody List<String> getGoodsNameBySuppIdAndGNameAndGModel(Integer supplierId, String goodsName,
			String goodsModel, Model model) {

		List<String> list = goodsService.getGoodsNamebySuIdAndNameAndModel(supplierId, goodsName, goodsModel);

		return list;

	}

	@RequestMapping("getGoodsByNameAndModel")
	public @ResponseBody Goods getGoodsByNameAndModel(String goodsName, String goodsModel, Model model) {

		Goods goods = goodsService.getGoodsByNameAndModel(goodsName, goodsModel);
		System.out.println(goods == null);
		return goods;

	}

	@RequestMapping("purOrderAdd")
	public String purOrderAdd(Supplier supplier, Integer[] goodsId, Integer[] num, Float[] price, Model model) {
		System.out.println("Im IN");

		if (supplier.getId() == null || goodsId == null) {

			Boolean OrderResponse = false;
			model.addAttribute("OrderResponse", OrderResponse);

			return "/jsp/orderP_add.jsp";
		} else {
			Boolean OrderResponse = true;
			model.addAttribute("OrderResponse", OrderResponse);
			orderService.addPOrder(supplier, goodsId, num, price);
			return "/jsp/orderP_add.jsp";

		}

	}

	@RequestMapping("verifyPOrder")
	public @ResponseBody void verifyPOrder(Integer orderId, Integer checkerId) {

		orderService.verifyPOrder(orderId, checkerId);

		return;
	}

	@RequestMapping("finishPur")
	public @ResponseBody void finishPur(Integer orderId, Integer starterId) {

		orderService.finishPur(orderId, starterId);

		return;
	}

	@RequestMapping("putGoodsInStore")
	public @ResponseBody void putGoodsInStore(Integer orderId, Integer orderdetailId, Integer storekeeperId) {

		System.out.println("orderId:" + orderId + "orderdetailId：" + orderdetailId + "storekeeperId:" + storekeeperId);
		orderService.putGoodsInStore(orderId, orderdetailId, storekeeperId);

	}

	@RequestMapping("insertCustomerByOrderAdd")
	public @ResponseBody Customer insertCustomerByOrderAdd(Customer customer) {

		customer = customerService.insertByOrderAdd(customer);

		return customer;

	}

	@RequestMapping("getCustomerByNameAndContact")
	public @ResponseBody Customer getCustomerByNameAndContact(String customerName, String customerContact) {

		List<Customer> customers = customerService.selectByNameAndContact(customerName, customerContact);
		if (customers.size() != 0) {
			return customers.get(0);
		}
		return null;

	}

	@RequestMapping("saleOrderAdd")
	public String saleOrderAdd(Customer customer, Integer[] goodsId, Integer[] num, Float[] price, Model model) {
		System.out.println("Im IN");

		if (customer.getId() == null || goodsId == null) {

			Boolean OrderResponse = false;
			model.addAttribute("OrderResponse", OrderResponse);

			return "/jsp/orderS_add.jsp";
		} else {
			Boolean OrderResponse = true;
			model.addAttribute("OrderResponse", OrderResponse);
			orderService.addSOrder(customer, goodsId, num, price);
			return "/jsp/orderS_add.jsp";

		}

	}

	@RequestMapping("verifySOrder")
	public @ResponseBody boolean verifySOrder(Integer orderId, Integer checkerId) {

		boolean bool = orderService.verifySOrder(orderId, checkerId);

		return bool;
	}

	@RequestMapping("startGetGoods")
	public @ResponseBody void startGetGoods(Integer orderId, Integer starterId) {

		orderService.startGetGoods(orderId, starterId);

		return;
	}

	@RequestMapping("putGoodsOutStore")
	public @ResponseBody boolean putGoodsOutStore(Integer orderId, Integer orderdetailId, Integer storekeeperId) {

		System.out.println("orderId:" + orderId + "orderdetailId：" + orderdetailId + "storekeeperId:" + storekeeperId);
		boolean bool = orderService.putGoodsOutStore(orderId, orderdetailId, storekeeperId);
		return bool;
	}

	@RequestMapping("getPOrderNumArByM")
	public @ResponseBody List<Integer> getPOrderNumArByM() {

		// getOrNumArByM(0) 1:采购单。2：销售单
		List<Integer> list = orderService.getOrNumArByM("1");

		return list;
	}

	@RequestMapping("getSOrderNumArByM")
	public @ResponseBody List<Integer> getSOrderNumArByM() {

		// getOrNumArByM(0) 1:采购单。2：销售单
		List<Integer> list = orderService.getOrNumArByM("2");

		return list;
	}
}
