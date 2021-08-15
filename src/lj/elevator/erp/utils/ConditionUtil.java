package lj.elevator.erp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Beholder1234 查询放条件的工具类
 * @param <T>
 */
public class ConditionUtil {

	// sql中 Limit start,size
	private Integer start;
	private Integer size;
	private ArrayList<String> conditionS = new ArrayList<>();
	private ArrayList<Integer> conditionI = new ArrayList<>();

	public ConditionUtil(String... condition) {
		this.conditionS = remove(condition);

	}

	private ArrayList<Integer> remove(Integer... integers) {
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer integer : integers) {
			if (integer != null) {
				list.add(integer);
			}

		}

		return list;
	}

	private ArrayList<String> remove(String... strings) {
		ArrayList<String> list = new ArrayList<>();

		if (strings == null) {
			return list;
		}
		if (strings.length == 1) {
			System.out.println("lenght==1");
			for (String string : strings) {
				if (string != null) {
					string = string.replace(" ", "");
					if (!string.equals("")) {
						list.add(string);
					}

				}
			}
		} else if (strings.length >= 2) {
			System.out.println(">=2");
			for (String string : strings) {
				if (string != null) {
					string = string.replace(" ", "");
					if (!string.equals("")) {
						list.add(string);
					} else
						list.add(null);

				} else if (string == null) {
					list.add(null);
				}

				System.out.println(string);
			}
		}

		return list;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getSize() {
		return size;
	}

	public ArrayList<String> getConditionS() {
		return conditionS;
	}

	public List<Integer> getConditionI() {
		return conditionI;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setConditionS(ArrayList<String> conditionS) {
		this.conditionS = conditionS;
	}

	public void setConditionI(ArrayList<Integer> conditionI) {
		this.conditionI = conditionI;
	}

}
