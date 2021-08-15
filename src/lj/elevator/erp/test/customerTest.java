package lj.elevator.erp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.CustomerMapper;
import lj.elevator.erp.pojo.Customer;
import lj.elevator.erp.utils.ConditionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class customerTest {

	@Autowired
	private CustomerMapper customerMapper;

	// @Test
	public void countByUtilTest() {

		ArrayList<String> list = new ArrayList<String>();
		int num = customerMapper.countByUtil(list);
		System.out.println(num);

	}

	// @Test
	public void selectByUtil() throws Exception {
		ConditionUtil conditionUtil = new ConditionUtil(" ");
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Customer> list = customerMapper.selectByUtil(conditionUtil);
		System.out.println(list.get(0).getName());
	}

	@Test
	public void InsertTest() {

		Customer customer = new Customer();
		customer.setName("Lily");
		customerMapper.insertSelective(customer);

	}

}
