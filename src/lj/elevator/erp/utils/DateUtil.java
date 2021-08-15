package lj.elevator.erp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	private Date date;

	public DateUtil(Date date) {
		this.date = date;
	}

	public DateUtil() {
		this.date = new Date();
	}

	// 注意：不改变实例化时，date的值
	public Date changeDate(Integer year, Integer month, Integer day) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		if (year != null) {
			cal.add(Calendar.YEAR, year);

		}
		if (month != null) {
			cal.add(Calendar.MONTH, month);
		}
		if (day != null) {
			cal.add(Calendar.DAY_OF_MONTH, day);

		}

		return cal.getTime();

	}

	// 注意：改变实例化的date的值
	public Date changeInstancedDate(Integer year, Integer month, Integer day) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		if (year != null) {
			cal.add(Calendar.YEAR, year);

		}
		if (month != null) {
			cal.add(Calendar.MONTH, month);

		}
		if (day != null) {
			cal.add(Calendar.DAY_OF_MONTH, day);

		}

		date = cal.getTime();
		return date;
	}

	public boolean beforeTo(Date date2) {

		return date.before(date2);

	}

	public void setDate(String year, String month, String day) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR, Integer.valueOf(year));// 设置年
		gc.set(Calendar.MONTH, Integer.valueOf(month) - 1);// 这里0是1月..以此向后推
		gc.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));// 设置天
		date = gc.getTime();

	}

	public void setDate(Integer year, Integer month, Integer day) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR, year);// 设置年
		gc.set(Calendar.MONTH, month - 1);// 这里0是1月..以此向后推
		gc.set(Calendar.DAY_OF_MONTH, day);// 设置天
		date = gc.getTime();

	}

	public boolean afterTo(Date date2) {

		return date.after(date2);

	}

	public String getDatetoString() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		return df.format(date);

	}

	public String formatDate(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		return df.format(date);

	}

	public Integer getYear(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");

		return Integer.valueOf(df.format(date));

	}

	public Integer getMonth(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("MM");

		return Integer.valueOf(df.format(date));

	}

	public Integer getDay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("dd");

		return Integer.valueOf(df.format(date));

	}

	public Integer getYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");

		return Integer.valueOf(df.format(date));

	}

	public Integer getMonth() {
		SimpleDateFormat df = new SimpleDateFormat("MM");

		return Integer.valueOf(df.format(date));

	}

	public Integer getDay() {
		SimpleDateFormat df = new SimpleDateFormat("dd");

		return Integer.valueOf(df.format(date));

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
