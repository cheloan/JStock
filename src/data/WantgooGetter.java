package data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import instrument.cashflow.CashFlow;
import instrument.cashflow.Stock;
import util.DateUtil;
import util.Formatter;

/**
 * 從玩股網抓取數據
 * 
 * @author Shaw
 *
 */
public class WantgooGetter implements DataGetter{

	@Override
	public void getTodayData(final String code, 
			                 final DataGetCallback callback) {
		StringBuilder sb = new StringBuilder("http://www.wantgoo.com/stock/");
		sb.append(code);
		sb.append("?searchType=stocks");
		try {
			Document doc = Jsoup.connect(sb.toString()).get();
			Element content = doc.body();
		    Element in = content.getElementsByClass("astkIdx").first();
		    Elements els = in.children();
		    Stock stock = new Stock(DateUtil.today(), getPrice(els, PriceType.Close));
		    stock.setOpenPrice(getPrice(els, PriceType.Open));
		    stock.setAmount(getPrice(els, PriceType.Vol));
		    stock.setMaxPrice(getPrice(els, PriceType.High));
		    stock.setMinPrice(getPrice(els, PriceType.Low));
		    callback.onSuccess(stock);
		}
		catch(final Throwable th) {
			callback.onFailure(code);
		}
	}
	
	/**
	 *  解析獲得數字
	 * 
	 * @param ele
	 * @param type
	 * @return
	 */
	private double getPrice(final Elements ele, final PriceType type) {
		double price = 0D;
		switch(type) {
		case Open:
			price = Formatter.getDouble(ele.get(0).text().replace("開盤", ""));
			break;
		case Close:
			price = Formatter.getDouble(ele.get(3).text().replace("昨收", ""));
		    break;
		case High:
			price = Formatter.getDouble(ele.get(1).text().replace("最高", ""));
			break;
		case Low:
			price = Formatter.getDouble(ele.get(2).text().replace("最低", ""));
			break;
		default :
			price = Formatter.getDouble(ele.get(2).text().replace("成交量(張)", ""));
			break;
		}
		return price;
	}
	
	/**
	 * 股票價格的類型
	 * 
	 * @author Shaw
	 *
	 */
	private enum PriceType {
		/** 開盤*/
		Open,
		/** 收盤*/
		Close,
		/** 最高點*/
		High,
		/** 最低點*/
		Low,
		/** 成交量*/
		Vol
	}
}
