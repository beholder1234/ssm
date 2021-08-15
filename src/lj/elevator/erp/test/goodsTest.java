package lj.elevator.erp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.GoodsMapper;
import lj.elevator.erp.pojo.Goods;
import lj.elevator.erp.utils.ConditionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class goodsTest {

	@Autowired
	private GoodsMapper goodsMapper;

	// @Test
	public void countByUtilTest() {

		ArrayList<String> list = new ArrayList<String>();
		list.add("W");
		list.add("w");
		list.add("w");

		ArrayList list2 = new ArrayList(list);
		int num = goodsMapper.countByUtil(list2);
		// System.out.println(num);

	}

	// @Test
	public void selectByUtil() throws Exception {

		String[] strings = new String[] { "w", "", "" };
		String string;
		ConditionUtil conditionUtil = new ConditionUtil(strings);
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Goods> list = goodsMapper.selectByUtil(conditionUtil);
		// System.out.println(list.get(0).getName());
	}

	// @Test
	public void selectNameTest() {

		List<String> list = goodsMapper.selectName();
		System.out.println(list.get(0));
	}

	@Test
	public void selectModelBySupplierId() {
		Integer integer = 1;
		System.out.println("1" == null);

		goodsMapper.selectModelNameBySupplierId(integer);

	}
}
