package instrument.cashflow;

import java.io.Serializable;
import java.util.Date;

import util.HashCodeBuilder;

import util.DateUtil;

public class CashFlow implements Comparable<CashFlow>, Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date date;
	private double amount;
	
	public CashFlow(final Date date,
			        final double amount){
		this.date= date;
		this.amount = amount;
	}
	
	/**
	 * 日期
	 * 
	 * @return
	 */
	public Date date(){
		return date;
	}
	
	/**
	 * 设置日期
	 * 
	 * @param date
	 */
	public void setDate(final Date date){
		this.date = date;
	}
	
	/**
	 * 金额
	 * 
	 * @return
	 */
	public double amount(){
		return amount;
	}
	
	/**
	 * 设置金额
	 * 
	 * @param amount
	 */
	public void setAmount(final double amount){
		this.amount = amount;
	}
	
	@Override
	public int compareTo(final CashFlow cf) {
		try{
    		if (date().before(cf.date())) {
                return -1;
            }
            if (DateUtil.compare(date(), cf.date(), true)) {
                return 0;
            }
            return 1;
    	}
    	catch(Exception e){
    		//如果有其中一个Date是Null，回传 1
    		return 1;
    	}
	}

	@Override
	public CashFlow clone(){
		return new CashFlow(date, amount);
	}
	
	@Override
	public boolean equals(final Object cashflow){
		if(cashflow instanceof CashFlow){
			return false;
		}
		try{
			CashFlow cf = (CashFlow) cashflow;
			if(!(DateUtil.compare(date(), cf.date(), true) && amount() != cf.amount())){
				return false;
			}
		}
		catch(final Throwable tb){
			return false;
		}
		return true;
	}
	
	@Override
    public String toString(){
    	return new StringBuilder(DateUtil.toString(date)).append("\t").append(amount).toString();
    }
    
    @Override
    public int hashCode(){
    	return new HashCodeBuilder().append(toString()).hashCode();
    }
}
