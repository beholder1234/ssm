package lj.elevator.erp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lj.elevator.erp.mapper.OrderMapper;
import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.pojo.OrderExample;
import lj.elevator.erp.pojo.OrderExample.Criteria;
import lj.elevator.erp.pojo.Orderdetail;
import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.pojo.Supplier;
import lj.elevator.erp.service.BusinessService;
import lj.elevator.erp.service.EmpService;
import lj.elevator.erp.service.EquipmentService;
import lj.elevator.erp.service.GoodsService;
import lj.elevator.erp.service.GoodspriceService;
import lj.elevator.erp.service.OrderDetailService;
import lj.elevator.erp.service.OrderService;
import lj.elevator.erp.service.StoredetailService;
import lj.elevator.erp.utils.ComServiceUtil;
import lj.elevator.erp.utils.CookieUtil;
import lj.elevator.erp.utils.DateUtil;
import lj.elevator.erp.utils.Page;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderDetailService ordertailService;

	@Autowired
	private EmpService empService;

	@Autowired
	private StoredetailService storedeService;

	@Autowired
	private GoodspriceService goodspriceService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private EquipmentService equipmentService;

	@Autowired
	private BusinessService businessService;

	@Override
	public Page<Order> getOrderList(Page<Order> page, String[] targets) throws Exception {

		ComServiceUtil<OrderMapper, Order> comServiceUtil = new ComServiceUtil<OrderMapper, Order>(orderMapper, page,
				targets);

		page = comServiceUtil.getPage();

		return page;
	}

	@Override
	public Order setOrderdetail(Page<Order> page, Integer orderId) {

		for (Order order : page.getRows()) {
			if (order.getId().equals(orderId)) {
				System.out.println("GET oral order");
				List<Orderdetail> orderdetails = ordertailService.getOrderdetailByOrderId(orderId);

				order.setOrderdetails(orderdetails);

				return order;
			}
		}
		System.out.println("Return Null");
		return null;

	}

	@Override
	public void addPOrder(Supplier supplier, Integer[] goodsId, Integer[] num, Float[] price) {
		System.out.println("add P 1");
		if (supplier != null && goodsId != null && num != null && price != null) {
			Emp emp = (Emp) SecurityUtils.getSubject().getPrincipal();
			Order order = new Order();
			order.setCreater(emp.getName());
			order.setSupplierid(supplier.getId());
			order.setCreatetime(new Date());
			order.setType("1");
			order.setState("1");
			float totalprice = 0;
			for (int i = 0; i < price.length; i++) {

				totalprice = price[i] * num[i] + totalprice;
			}
			BigDecimal bigDecimal1 = new BigDecimal(totalprice);
			order.setTotalprice(bigDecimal1);
			orderMapper.insertSelective(order);

			int key = order.getId();
			System.out.println("OrderId:" + key);
			for (int i = 0; i < goodsId.length; i++) {
				Orderdetail odetail = new Orderdetail();
				odetail.setGoodsid(goodsId[i]);
				odetail.setNum(num[i]);
				BigDecimal bigDecimal = new BigDecimal(price[i]);
				odetail.setPrice(bigDecimal);
				odetail.setOrderid(key);
				odetail.setState("1");

				ordertailService.insertSelective(odetail);
			}

		}
	}

	@Override
	public void verifyPOrder(Integer orderId, Integer checkerId) {

		Order order = orderMapper.selectByPrimaryKey(orderId);

		Emp emp = empService.selectEmpById(checkerId);

		order.setChecktime(new Date());
		order.setChecker(emp.getName());
		order.setState("2");

		orderMapper.updateByPrimaryKeySelective(order);

	}

	@Override
	public void finishPur(Integer orderId, Integer starterId) {
		Order order = orderMapper.selectByPrimaryKey(orderId);

		Emp emp = empService.selectEmpById(starterId);

		order.setStarttime(new Date());
		order.setStarter(emp.getName());
		if (order.getType().equals("1")) {
			order.setState("4");

		} else if (order.getType().equals("2")) {
			order.setState("5");

		}

		orderMapper.updateByPrimaryKeySelective(order);

		ordertailService.updateState(orderId, "1");
	}

	@Override
	public Page<Order> setOrderdetail(Page<Order> page) {

		for (int i = 0; i < page.getRows().size(); i++) {
			Order order = page.getRows().get(i);
			List<Orderdetail> orderdetails = ordertailService.getOrderdetailByOrderId(order.getId());
			order.setOrderdetails(orderdetails);
			page.getRows().get(i).setOrderdetails(orderdetails);

		}

		return page;
	}

	@Override
	public void putGoodsInStore(Integer orderId, Integer orderdetailId, Integer storekeeperId) {
		System.out.println("putGoodsInStore start..... orderdetailid=" + orderdetailId);
		Order order = orderMapper.selectByPrimaryKey(orderId);
		List<Orderdetail> orderdetails = ordertailService.getOrderdetailByOrderId(orderId);
		List<Emp> emps = empService.getEmpById(storekeeperId);
		Emp emp = emps.get(0);
		boolean allFinish = true;
		for (Orderdetail orderdetail : orderdetails) {

			if (orderdetail.getId().equals(orderdetailId)) {
				orderdetail.setState("3");
				orderdetail.setEndtime(new Date());
				orderdetail.setStorekeeper(emp.getName());

				orderdetail.setStoreid(orderdetail.getGoods().getGoodstype().getStoreid());

				System.err.println("orderservice update ....");
				ordertailService.updateOrderdetail(orderdetail);
				System.out.println("storedeService 插入中 .....");
				storedeService.insertStore(order, orderdetail);
				System.out.println("goodspriceService .....");
				goodspriceService.insertPrice(orderdetail);

			}

			if (orderdetail.getState() != "3") {
				allFinish = false;
			}

		}

		if (allFinish) {

			order.setState("6");
			order.setEndtime(new Date());
			orderMapper.updateByPrimaryKeySelective(order);

		}

	}

	@Override
	public void addSOrder(Customer customer, Integer[] goodsId, Integer[] num, Float[] price) {
		System.out.println("add P 1");
		if (customer != null && goodsId != null && num != null && price != null) {
			Emp emp = (Emp) SecurityUtils.getSubject().getPrincipal();
			Order order = new Order();
			order.setCreater(emp.getName());
			order.setCustomerid(customer.getId());
			order.setCreatetime(new Date());
			order.setType("2");
			order.setState("1");
			float totalprice = 0;
			for (int i = 0; i < price.length; i++) {

				totalprice = price[i] * num[i] + totalprice;
			}
			BigDecimal bigDecimal1 = new BigDecimal(totalprice);
			order.setTotalprice(bigDecimal1);
			orderMapper.insertSelective(order);

			int key = order.getId();
			System.out.println("OrderId:" + key);
			for (int i = 0; i < goodsId.length; i++) {
				Orderdetail odetail = new Orderdetail();
				odetail.setGoodsid(goodsId[i]);
				odetail.setNum(num[i]);
				BigDecimal bigDecimal = new BigDecimal(price[i]);
				odetail.setPrice(bigDecimal);
				odetail.setOrderid(key);
				odetail.setState("1");

				Goods goods = goodsService.getGoodsByKey(goodsId[i]);

				goods.setAlertnum(num[i] + goods.getAlertnum());

				odetail.setStoreid(goods.getGoodstypeid());

				ordertailService.insertSelective(odetail);
				goodsService.updateByPrimaryKey(goods);

				if (goods.getGoodstypeid().equals(6)) {

					CookieUtil cookieUtil = new CookieUtil();
					String eqNum = cookieUtil.getCookieByKey("num" + i);
					String eqCode = cookieUtil.getCookieByKey("code" + i);
					String eqLayer = cookieUtil.getCookieByKey("layer" + i);
					String eqStation = cookieUtil.getCookieByKey("station" + i);
					String eqAddress = cookieUtil.getCookieByKey("address" + i);
					Equipment equipment = new Equipment();
					equipment.setNum(eqNum);
					equipment.setCode(Integer.valueOf(eqCode));
					equipment.setLayerandstation(eqLayer + "/" + eqStation);
					equipment.setAddress(eqAddress);
					equipment.setState("1");
					equipment.setName(goods.getName());
					equipment.setModel(goods.getModel());
					equipment.setCustomerid(customer.getId());
					System.out.println("set A lot Already。。。");
					String specs = goods.getSpecs();
					String[] strings = specs.split(";");
					equipment.setLoad(strings[0]);
					equipment.setSpeed(new BigDecimal(strings[1]));
					System.out.println("split and set finish ");
					equipmentService.insertEquipment(equipment);

				}
			}

		} // TODO Auto-generated method stub

	}

	@Override
	public boolean verifySOrder(Integer orderId, Integer checkerId) {

		List<Orderdetail> orderdetails = ordertailService.getOrderdetailByOrderId(orderId);
		List<Orderdetail> orderdetails2 = new ArrayList<Orderdetail>();
		for (Orderdetail orderdetail : orderdetails) {
			Storedetail storedetail = storedeService.getStoredetailByGoodsId(orderdetail.getGoodsid());
			if (orderdetail.getNum() > storedetail.getTotalnum()) {
				return false;

			}
			// 安装整机
			if (orderdetail.getStoreid() == 6) {
				orderdetails2.add(orderdetail);
			}
		}

		Order order = orderMapper.selectByPrimaryKey(orderId);

		Emp emp = empService.selectEmpById(checkerId);

		order.setChecktime(new Date());
		order.setChecker(emp.getName());
		order.setState("3");

		orderMapper.updateByPrimaryKeySelective(order);

		// 新建安装业务
		for (Orderdetail orderdetail : orderdetails2) {
			Business business = new Business();
			business.setType("1");
			business.setEquipmentid(orderdetail.getGoodsid());
			business.setCreatetime(new Date());
			business.setOrderid(orderId);
			businessService.insertByBusiness(business);
		}

		return true;
	}

	@Override
	public boolean putGoodsOutStore(Integer orderId, Integer orderdetailId, Integer storekeeperId) {

		/* 检验库存商品存量是否足够，不足return false */
		Orderdetail orderdetail2 = ordertailService.getOrderdetailByKey(orderdetailId);
		Storedetail storedetail2 = storedeService.getStoredetailByGoodsId(orderdetail2.getGoodsid());
		if (orderdetail2.getNum() > storedetail2.getTotalnum()) {
			// 库存不足,出库失败...
			return false;

		}

		/* 库存足够且取货员相同执行以下方法 ，对数据进行修改 */
		Order order = orderMapper.selectByPrimaryKey(orderId);
		List<Orderdetail> orderdetails = ordertailService.getOrderdetailByOrderId(orderId);
		List<Emp> emps = empService.getEmpById(storekeeperId);

		Emp emp = emps.get(0);
		boolean allFinish = true;
		for (Orderdetail orderdetail : orderdetails) {

			if (orderdetail.getId().equals(orderdetailId)) {
				orderdetail.setState("3");
				orderdetail.setEndtime(new Date());
				orderdetail.setStorekeeper(emp.getName());

				orderdetail.setStoreid(orderdetail.getGoods().getGoodstype().getStoreid());

				System.err.println("orderservice update ....");
				ordertailService.updateOrderdetail(orderdetail);
				System.out.println("storedeService 插入中 .....");
				storedeService.outputStore(order, orderdetail);
				System.out.println("goodspriceService .....");
				goodspriceService.outputPrice(orderdetail);

				Goods goods = goodsService.getGoodsByKey(orderdetail.getGoodsid());
				goods.setAlertnum(goods.getAlertnum() - orderdetail.getNum());
				goodsService.updateByPrimaryKey(goods);
			}

			if (orderdetail.getState() != "3") {
				allFinish = false;
			}

		}

		if (allFinish) {

			order.setState("5");
			order.setEndtime(new Date());
			orderMapper.updateByPrimaryKeySelective(order);

		}

		return false;
	}

	@Override
	public void startGetGoods(Integer orderId, Integer starterId) {
		Order order = orderMapper.selectByPrimaryKey(orderId);

		Emp emp = empService.selectEmpById(starterId);

		// order.setStarttime(new Date());
		order.setStarter(emp.getName());
		order.setState("5");

		orderMapper.updateByPrimaryKeySelective(order);

		ordertailService.updateState(orderId, "1");

	}

	@Override
	public Order getOrderByKey(Integer orderid) {
		Order order = orderMapper.selectByPrimaryKey(orderid);
		return order;
	}

	@Override
	// 获取本月及之前的对应订单数量
	public List<Integer> getOrNumArByM(String type) {

		List<Integer> list = new ArrayList<Integer>();

		DateUtil dUtil = new DateUtil();
		dUtil.setDate(dUtil.getYear(new Date()), 1, 1); // set为本年的一月一号

		for (int i = 0; i < 12; i++) {

			OrderExample orderExample = new OrderExample();

			Criteria criteria = orderExample.createCriteria();

			criteria.andTypeEqualTo(type);

			// changeDate 获取本月的最后一天，不改变dUtil实例化设置的date的值。
			criteria.andCreatetimeBetween(dUtil.getDate(), dUtil.changeDate(null, 1, -1));

			// 获取下一个月的第一天。
			dUtil.changeInstancedDate(null, 1, null);

			List<Order> orders = orderMapper.selectByExample(orderExample);

			list.add(orders.size());

			// 本月份与将要计算的月份进行比较，
			// 大于等于说明还没计算玩本月及以前的订单
			// 小于说明已计算到本月，则退出循环
			if (dUtil.getMonth(new Date()) < dUtil.getMonth()) {
				break;
			}

		}

		return list;
	}

	@Override
	public List<Integer> selectSameGoodsNumForNotes() {

		return orderMapper.selectSameGoodsNum();

	}

	@Override
	public List<Integer> selectSameGoodsIdForNotes() {
		// TODO Auto-generated method stub
		return orderMapper.selectSameGoodsId();
	}

}
