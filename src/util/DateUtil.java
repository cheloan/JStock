package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	final static DateFormat df = new SimpleDateFormat("yyyyMMdd");

	/**
	 * 比对两日期是否相等
	 * 
	 * @param date1                     日期1
	 * @param date2                     日期2
	 * @param isNullEqual null是否相等
	 * @return
	 */
	public static boolean compare(final Date date1,
			                      final Date date2,
			                      final boolean isNullEqual){
		if(date1 == null && date2 == null){
			return isNullEqual;
		}
		else if(date1 == null || date2 == null){
			return false;
		}
		
		return date1.equals(date2);
	}
	
	/**
	 * 给定日期，输出yyyyMMdd格式字串
	 * 
	 * @param date 日期
	 * @return
	 */
	public static String toString(final Date date){
		try{
			return df.format(date);
		}
		catch(final Throwable tb){
			return "";
		}
	}
}
