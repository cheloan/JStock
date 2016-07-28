package util;

import java.text.DecimalFormat;

public class Formatter {

	/**
	 * 獲取Double對象，如果解析失敗返回0
	 */
	public static double getDouble(final String num) {
		double n = 0D;
		try{
			DecimalFormat df = new DecimalFormat();
	        df.setGroupingUsed(true);
	        n = df.parse(num).doubleValue();
		}
		catch(final Throwable th) {
			return n;
		}
		return n;
	}
}
