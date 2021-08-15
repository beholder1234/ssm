package lj.elevator.erp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.OrderdetailMapper;
import lj.elevator.erp.pojo.Orderdetail;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class OrderDetailTest {

	@Autowired
	private OrderdetailMapper orderdetailMapper;

	@Test
	public void getTest() {

		List<Orderdetail> orderdetails = orderdetailMapper.selectOrderdetailByOrderId(2);

		System.out.println(orderdetails.get(0).getGoods().getName());

	}

}
