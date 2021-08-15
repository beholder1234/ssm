package lj.elevator.erp.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.utils.ConditionUtil;
import lj.elevator.erp.utils.DateUtil;
import lj.elevator.erp.utils.Page;

public class test {

	// @Test
	public void javaTest() {
		List<Object> list = new ArrayList<>();
		list.add("aa");
		list.add(1);

		System.out.println(list.get(1).getClass().getName());
	}

	// @Test
	public void javaTest2() {

		// String[] strings;
		ConditionUtil conditionUtil = new ConditionUtil(null);
		// System.out.println(strings == null);
	}

	// @Test
	public void javaTest3() {

		List<String> list = new ArrayList<>();

		list.add("1");

		System.out.println(list.indexOf("2"));
	}

	// @Test
	public void javaTest4() {

		Page<Emp> page = new Page<>();
		ArrayList<Emp> list = new ArrayList<Emp>();
		list.add(new Emp());

		System.out.println(list.get(0).toString());
		/*
		 * Emp emp = new Emp(); Emp emp1 = new Emp();
		 * System.out.println(emp.getId());
		 */
	}

	// @Test
	public void javaTest5() {

		Date date = new Date("2007/3/8");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, +15);
		// 日期格式
		date = cal.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));

	}

	// @Test
	public void javaTest6() {
		Date date = new Date();

		DateUtil dUtil = new DateUtil(date);

		date = dUtil.changeDate(null, 1, 15);

		String string = dUtil.formatDate(date);

		System.out.println(string);

	}

	// @Test
	public void javaTest7() {

		DateUtil dUtil = new DateUtil();

		dUtil.setDate(dUtil.getYear(new Date()), 1, 1);

		String string = dUtil.getDatetoString();

		System.out.println(string);

	}

	// @Test
	public void javaTest8() {

		List<Integer> list = new ArrayList<>();
		list.add(12);
		System.out.println(list.indexOf(1) == -1);
	}

	// @Test
	public void javaTest9() {

		BigDecimal bigDecimal1 = new BigDecimal(50);
		BigDecimal bigDecimal2 = new BigDecimal(1.5);

		System.out.println(bigDecimal1.multiply(bigDecimal2));

	}

	@Test
	public void javaTest10() {

		Integer integer[] = { 1, 2 };
		List<Integer[]> list = new ArrayList<>();
		list.add(integer);
		System.out.println(list.get(0)[0]);
		System.out.println(list.get(0)[1]);

	}
}
