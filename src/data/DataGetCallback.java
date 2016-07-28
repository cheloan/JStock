package data;

import instrument.cashflow.CashFlow;

/**
 * 處理數據抓取時成功及失敗的處理方式
 * 
 * @author Shaw
 *
 */
public interface DataGetCallback {

	/**
	 * 成功
	 * 
	 * @param cf
	 */
	public void onSuccess(final CashFlow cf);
	
	/**
	 * 失敗
	 * 
	 * @param code
	 */
	public void onFailure(final String code);
	
}
