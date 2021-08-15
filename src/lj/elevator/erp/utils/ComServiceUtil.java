package lj.elevator.erp.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Beholder1234 查询放条件的工具类
 * @param <T>
 */
/**
 * @author Beholder1234
 *
 * @param <E>
 * @param <T>
 */

public class ComServiceUtil<E, T> {

	private ConditionUtil conditionUtil;
	private Page<T> page;
	private E mapper;

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	// mapper:反射时，要获取mapper对象属于哪个mapper类，从而调用其方法计算selec的总条数和获取attr属性名给前端jsp显示
	public ComServiceUtil(E mapper, Page<T> page, String... condition) throws Exception {
		this.conditionUtil = new ConditionUtil(condition);
		this.page = isNull(page);
		this.mapper = mapper;
		this.PagerUtils();

	}

	private Page<T> isNull(Page<T> page) {
		if (page == null) {
			System.out.println("Page NULL.....");
			page = new Page<T>();
		}
		return page;
	}

	private ArrayList<T> selectList() throws Exception {

		// System.out.println("getTotal In....");
		Class re = mapper.getClass();
		// System.out.println("getTotal getClass...");
		Method method = re.getDeclaredMethod("selectByUtil", conditionUtil.getClass());
		// System.out.println("getRows getDeclaredMethod.....");
		ArrayList<T> rows = (ArrayList<T>) method.invoke(mapper, conditionUtil);
		// System.out.println("getTotal UseMethod");

		if (rows.size() == 0) {
			rows = new ArrayList<T>();
		}
		return rows;
	}

	private Integer getTotal() throws Exception {

		// System.out.println("getTotal In....");
		Class re = mapper.getClass();
		// System.out.println("getTotal getClass...");
		Method method = re.getDeclaredMethod("countByUtil", conditionUtil.getConditionS().getClass());
		// System.out.println("getTotal getDeclaredMethod.....");
		Integer total = (Integer) method.invoke(mapper, conditionUtil.getConditionS());
		// System.out.println("getTotal UseMethod");
		return total;
	}

	private void PagerUtils() throws Exception {

		System.out.println("PagerUtils  In......");

		// 获得每页显示的条数
		Integer size = page.getSize();
		System.out.println("get Size Already。。。");
		conditionUtil.setSize(size);

		this.setStart();
		System.out.println("从这里开始：" + conditionUtil.getStart());

		// 计算总条数
		this.page.setTotal(this.getTotal());
		// 查询每页的数据表
		this.page.setRows(this.selectList());
		System.out.println("PagerUtils  Out......");

	}

	// 判断查询操作还是翻页操作
	// 查询操作：post，传page 的rows的数据进后台（若page ！= null（即不为第一次查询））
	// 翻页操作：get，传page 的rows.size（） 等于 1，而rows.get(0).getClass 为
	// java.util.String类型
	// 其值 （ rows.get(0) ）为 原对象的个数，而不是原对象（以此判断是否为翻页）
	private void setStart() {
		// 判断是否为第一次查询操作
		System.out.println(page.getRows() == null);
		if (page.getRows() != null) {
			if (page.getRows().size() == 0) {
				System.out.println("search current的size为0");
				conditionUtil.setStart(0);
				page.setPage(1);
				return;
			}
			// (判断是否为翻页操作)
			if (page.getRows().get(0).getClass() == new String().getClass()) {

				// 为翻页
				System.out.println("翻页");
				Integer start = (page.getPage() - 1) * page.getSize();
				conditionUtil.setStart(start);

				/*
				 * try { page.getRows().get(0).getClass(); // 正常执行则说明未查询
				 * setStart为 0 // 不正常执行则翻页 执行catch方法
				 * System.out.println(page.getRows().get(0));
				 * conditionUtil.setStart(0); } catch (Exception e) { // TODO:
				 * handle exception Integer start = (page.getPage() - 1) *
				 * page.getSize(); conditionUtil.setStart(start);
				 * System.out.println("set：" + start);
				 * 
				 * }
				 */

			} else {
				System.out.println("search");
				conditionUtil.setStart(0);
				page.setPage(1);

			}

		} else {
			System.out.println("没有page，set 0");
			conditionUtil.setStart(0);
			page.setPage(1);
			return;

		}

	}

	/*
	 * private void setStart() throws Exception {
	 * System.out.println(page.getRows() == null);
	 * System.out.println(page.getPage()); if (page.getRows() != null &&
	 * page.getPage() >= 2) {
	 * 
	 * // 获取上次start的位置 Integer lastTimeStart = (page.getPage() - 2) *
	 * page.getSize(); conditionUtil.setStart(lastTimeStart); List<T> list =
	 * this.selectList(); System.out.println("current:" + list.size());
	 * System.out.println("last:" + page.getRows().size()); if (list.size() !=
	 * page.getRows().size()) { System.out.println("size 不同，条件不同，set 0");
	 * conditionUtil.setStart(0); return; } for (int i = 0; i < list.size();
	 * i++) { System.out.println("size 相同，条件不同 set 0"); if
	 * (!page.getRows().get(i).equals(list.get(i))) { conditionUtil.setStart(0);
	 * return; } } // 计算分页查询从那条记录开始 sql中limit从0开始,n条数 System.out.println(
	 * "条件相同 next start"); Integer start = (page.getPage() - 1) *
	 * page.getSize(); conditionUtil.setStart(start);
	 * 
	 * } else { System.out.println("没有page，set 0"); conditionUtil.setStart(0);
	 * return;
	 * 
	 * }
	 * 
	 * }
	 */

}
