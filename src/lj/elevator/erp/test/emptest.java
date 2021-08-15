package lj.elevator.erp.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lj.elevator.erp.mapper.EmpMapper;
import lj.elevator.erp.pojo.Emp;
import lj.elevator.erp.utils.ConditionUtil;
import lj.elevator.erp.utils.Page;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:spring/applicationContext-dao.xml")
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class emptest {

	@Resource(name = "empMapper")
	private EmpMapper empMapper;

	// @Test
	public void delTest() {
		empMapper.deleteById(1);
	}

	@Test
	public void testUtils() {

		String[] strings = new String[] {};
		String string = null;
		ConditionUtil conditionUtil = new ConditionUtil("公关部");
		conditionUtil.setStart(0);
		conditionUtil.setSize(10);

		List<Emp> list = empMapper.selectByUtil(conditionUtil);
		System.out.println(list.size());

	}

	// @Test
	public void test1() {

		// System.out.println(empMapper.selectByPrimaryKey(5).getName());

		// List<String> condition = new ArrayList<String>();
		// condition.add("技术部");
		// List<Emp> list = empMapper.select(new ConditionUtil(0, 5, null));

		// EmpServiceImpl empServiceImpl = new EmpServiceImpl();
		// empServiceImpl.getEmpList(new Page<Emp>(), "公关部");
		// List<String> strings = new ArrayList<String>();
		// System.out.println(empMapper.countByUtil(strings));
		// System.out.println(emps.get(0).getDep().getName());
		// empService.getEmpList(new Page<Emp>(), "技术部");

	}

	// @Test
	public void test2() throws Exception {

		// System.out.println(emp.getClass().toString().equals("class
		// lj.elevator.erp.pojo.Emp"));
		// this.getAttr(new String().getClass());
		// System.out.println(new String().getClass().toString());
		// List<String> list = new AttForJSP().getAttr(emp.getClass());
		// System.out.println(list.get(0));
		Page<Emp> page = new Page<Emp>();

		// System.out.println(EmpMapper.class.getName());
		// EmpMapper mapper;

		// new AttForJSP().getAttr(mapper.getClass().getName());
		// page.setAttr(this.getAttr());
	}

	public List<String> getAttr(Class clazz) throws NoSuchMethodException, SecurityException {

		Method method = clazz.getMethod("equals", Object.class);

		// System.out.println(method.invoke(new, "11"));

		System.out.println(clazz.getName());

		// System.out.println(clazz.getName());
		// this.judgeClass(clazz.getClass().toString());

		return null;
	}

	public <T> List<String> getAttr1(Class<T> clazz) throws NoSuchMethodException, SecurityException {
		/*
		 * Method method = clazz.getMethod("equals", Object.class);
		 * 
		 * System.out.println(method.equals("11"));
		 * 
		 * System.out.println(clazz.getName());
		 */

		System.out.println(clazz.getName());
		// this.judgeClass(clazz.getClass().toString());

		return null;
	}

	public <E> void getAttr2(E mapper, String string) throws Exception {

		Class re = mapper.getClass();
		List<String> list = new ArrayList<String>();
		Method method = re.getDeclaredMethod(string, list.getClass());
		method.invoke(mapper, list);
	}

}
