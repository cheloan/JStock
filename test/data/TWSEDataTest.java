package data;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TWSEDataTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StringBuilder json = new StringBuilder();  
		try{
//			Date today = new Date();
//			URL twseUrl = new URL("http://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_3474.tw_20140804&_=" + today.getTime());
//			URL twseUrl = new URL("http://www.wantgoo.com/stock/2002?searchType=stocks");
//			URLConnection httpConn = twseUrl.openConnection();
//			InputStreamReader input = new InputStreamReader(twseUrl.openStream(), "utf-8");  
//			BufferedReader bufReader = new BufferedReader(input); 
//			String line = "";  
//		    StringBuilder contentBuf = new StringBuilder();  
//		    while ((line = bufReader.readLine()) != null) {  
//		        contentBuf.append(line);  
//		    }  
//		    String buf = contentBuf.toString();  
//		    int k = 0;
//			String html = "";
//			HttpClient httpClient = HttpClients.createDefault();
//			HttpGet httpget = new HttpGet("http://www.masterlink.com.tw/stock/individual/individualIndex.aspx?stockId=2002");
//			HttpResponse responce = httpClient.execute(httpget);
//			int resStatu = responce.getStatusLine().getStatusCode();//返回码  
//            if (resStatu == HttpStatus.SC_OK) {//200正常  其他就不对  
//                //获得相应实体  
//                HttpEntity entity = responce.getEntity();  
//                if (entity!=null) {  
//                    html = EntityUtils.toString(entity);//获得html源代码  
//                }  
//            }
//            int i = 0;
		    Document doc = Jsoup.connect("http://www.wantgoo.com/stock/2002?searchType=stocks").get();
		    Element content = doc.body();
		    Element in = content.getElementsByClass("astkIdx").first();
		    Elements els = in.children();
		    els= els.get(0).getAllElements();
		    String s = els.get(0).text();
		    int h = 0;
		}
		catch(final Throwable th) {
			th.printStackTrace();
		}
	}

}
