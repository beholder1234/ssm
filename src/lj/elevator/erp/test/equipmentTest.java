package lj.elevator.erp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.EquipmentMapper;
import lj.elevator.erp.pojo.Equipment;
import lj.elevator.erp.utils.ConditionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class equipmentTest {
	@Autowired
	EquipmentMapper mapper;

	// @Test
	public void selectByUtil() throws Exception {
		String[] strings = new String[] { "", "", "", "", " " };
		ConditionUtil conditionUtil = new ConditionUtil(strings);
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Equipment> list = mapper.selectByUtil(conditionUtil);
		System.out.println(list.get(0).getName());
	}

	@Test
	public void countByUtilTest() {

		ArrayList<String> list = new ArrayList<String>();
		list.add("W");
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("w");

		int num = mapper.countByUtil(list);

	}
}
