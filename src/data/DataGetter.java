package data;

import instrument.cashflow.CashFlow;

/**
 * 股票數據的抓取接口
 * 
 * @author Shaw
 *
 */
public interface DataGetter {
	
	/**
	 * 獲取今日數據
	 * 
	 * @param code     資產代碼
	 * @param callback 
	 */
	public void getTodayData(final String code, final DataGetCallback callback);

}
