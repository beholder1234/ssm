package lj.elevator.erp.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.OrderMapper;
import lj.elevator.erp.pojo.Order;
import lj.elevator.erp.service.OrderService;
import lj.elevator.erp.utils.ConditionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class OrderTest {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderService service;

	// @Test
	public void selectByUtil() throws Exception {
		String[] strings = new String[] { "", "", "", "", " ", " ", " ", " ", "" };
		ConditionUtil conditionUtil = new ConditionUtil(strings);
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Order> list = orderMapper.selectByUtil(conditionUtil);
		System.out.println(list.get(0).getChecktime());
	}

	// @Test
	public void countByUtilTest() {

		ArrayList<String> list = new ArrayList<String>();
		list.add("W");
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("13");
		list.add("12");

		int num = orderMapper.countByUtil(list);

	}

	// @Test
	public void insertTest() {

		Order order = new Order();
		order.setCreater("7");
		order.setSupplierid(1);
		order.setCreatetime(new Date());
		order.setType("0");

		double totalprice = 1.2;

		BigDecimal bigDecimal1 = new BigDecimal(totalprice);
		order.setTotalprice(bigDecimal1);
		System.out.println("BigDe:" + bigDecimal1);

		int key = orderMapper.insertSelective(order);
		System.out.println("hI");
		System.out.println(order.getId());
	}

	// @Test
	public void selectByKey() {
		orderMapper.selectByPrimaryKey(1);
	}

	// @Test
	public void getOrNumAByMServce() {

		List<Integer> list = service.getOrNumArByM("2");
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	@Test
	public void selectSameGoodsNumTest() {

		List<Integer> integers = orderMapper.selectSameGoodsNum();
		for (Integer integers2 : integers) {

			System.out.println(integers2);
		}

	}
}
