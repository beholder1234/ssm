package lj.elevator.erp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器 S:source 要转换的源类型 T:目标，要转换成的数据类型
 * 
 * @author Steven
 *
 */
public class DateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		Date result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			result = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

}
