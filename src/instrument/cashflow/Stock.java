package instrument.cashflow;

import java.util.Date;

import util.DateUtil;

public class Stock extends CashFlow {
	
	/** 开盘价*/
	private double openPrice;
	/** 最高价*/
	private double maxPrice;
	/** 最低价*/
	private double minPrice;
	/** 交易量*/
	private double volume;

	/**
	 * 基本建构函数
	 * 
	 * @param date       日期
	 * @param closePrice 收盘价 
	 */
	public Stock(final Date date, 
			     final double closePrice) {
		super(date, closePrice);
	}
	
	/**
	 * 完整建构函数
	 * 
	 * @param date       日期
	 * @param openPrice  开盘价
	 * @param closePrice 收盘价
	 * @param maxPrice   最高价
	 * @param minPrice   最低价
	 */
	public Stock(final Date date,
			     final double openPrice,
			     final double closePrice,
			     final double maxPrice,
			     final double minPrice) {
		super(date, closePrice);
		this.openPrice = openPrice;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
	}
	
	/**
	 * 开盘价
	 * 
	 * @return
	 */
	public double openPrice(){
		return openPrice;
	}
	
	/**
	 * 设置开盘价
	 * 
	 * @param openPrice
	 */
	public void setOpenPrice(final double openPrice){
		this.openPrice = openPrice;
	}
	
	/**
	 * 收盘价
	 * 
	 * @return
	 */
	public double closePrice(){
		return amount();
	}

	/**
	 * 设置收盘价
	 * 
	 * @param closePrice
	 */
	public void setClosePrice(final double closePrice){
		setAmount(closePrice);
	}
	
	/**
	 * 最高价
	 * 
	 * @return
	 */
	public double maxPrice(){
		return maxPrice;
	}
	
	/**
	 * 设置最高价
	 * 
	 * @param maxPrice
	 */
	public void setMaxPrice(final double maxPrice){
		this.maxPrice = maxPrice;
	}
	
	/**
	 * 最低价
	 * 
	 * @return
	 */
	public double minPrice(){
		return minPrice;
	}
	
	/**
	 * 设置最低价
	 * 
	 * @param minPrice
	 */
	public void setMinPrice(final double minPrice){
		this.minPrice = minPrice;
	}
	
	/**
	 * 成交量
	 * 
	 * @return
	 */
	public double volume(){
		return volume;
	}
	
	/**
	 * 设置成交量
	 * 
	 * @param volume
	 */
	public void volume(final double volume){
		this.volume = volume;
	}
	
	@Override
	public Stock clone(){
		Stock stock = new Stock(date,
				                openPrice,
				                amount,
				                maxPrice,
				                minPrice);
		stock.setAmount(amount);
		return stock;
	}
	
	@Override
	public boolean equals(final Object stock){
		if(!(stock instanceof Stock)){
			return false;
		}
		Stock s = (Stock) stock;
		try {
			if(openPrice() != s.openPrice() || 
			   maxPrice() != s.maxPrice() ||
			   minPrice() != s.minPrice() ||
			   volume() != s.volume()) {
				return false;
			}
		}
		catch(Throwable tb){
			return false;
		}
		return super.equals(stock);
	}
	
	@Override
    public String toString(){
    	return new StringBuilder(DateUtil.toString(date())).append("\t")
    			                                           .append(openPrice())
    			                                           .append(closePrice())
    			                                           .append(maxPrice())
    			                                           .append(minPrice()).toString();
    }
}
