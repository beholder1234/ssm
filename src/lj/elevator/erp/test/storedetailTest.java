package lj.elevator.erp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.StoredetailMapper;
import lj.elevator.erp.pojo.Storedetail;
import lj.elevator.erp.utils.ConditionUtil;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class storedetailTest {

	@Autowired
	private StoredetailMapper storedetailMapper;

	// @Test
	public void selectByUtilTest() {

		String[] strings = new String[] { "", "", "", "", "" };
		ConditionUtil conditionUtil = new ConditionUtil(strings);
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Storedetail> storedetails = storedetailMapper.selectByUtil(conditionUtil);

		System.out.println(storedetails.get(0).getGoods().getGoodstype().getName());
	}

	// @Test
	public void countByUtilTest() {

		String[] strings = new String[] { null, null, null, null, null };

		ArrayList<String> list = new ArrayList<String>();
		list.add("W");
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("w");

		int num = storedetailMapper.countByUtil(list);

	}

	@Test
	public void getSTest() {

		List<Storedetail> storedetails = storedetailMapper.getStoreAlertList();
		System.out.println(storedetails.size());
		// xml有问题
	}

}
