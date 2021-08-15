package lj.elevator.erp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.BusinessMapper;
import lj.elevator.erp.pojo.Business;
import lj.elevator.erp.utils.ConditionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class BusinessTest {

	@Autowired
	private BusinessMapper mapper;

	@Test
	public void selectByUtil() throws Exception {
		String[] strings = new String[] { "", "", "", "", " ", " ", " " };
		ConditionUtil conditionUtil = new ConditionUtil(strings);
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Business> list = mapper.selectByUtil(conditionUtil);
		System.out.println(list.get(0).getId());
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

		int num = mapper.countByUtil(list);

		// mapper.selectByPrimaryKey(1);

	}

}
