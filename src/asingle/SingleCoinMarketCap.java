package asingle;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SingleCoinMarketCap {
	public static void main(String[] args) {
		// 나중에 날짜나 코인이름은 변수 처리하여 원하는 것을 가져올 수도 있음
		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end=20190806";

		Document doc = null;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("새파일1");

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("성공...");

		System.out.println("Date\tOpen\tHigh\tLow\tClose\tVolume\tMarket Cap");

		Elements bodyElements = doc.select(".table-responsive .table tbody tr");

		for (int i = 0; i < bodyElements.size(); i++) {
			Element trElement = bodyElements.get(i);
			String date = trElement.child(0).text();
			String open = trElement.child(1).text();
			String high = trElement.child(2).text();
			String low = trElement.child(3).text();
			String close = trElement.child(4).text();
			String volume = trElement.child(5).text();
			String marketCap = trElement.child(6).text();
			String str = date + "#" + open + "#" + high + "#" + low + "#" + close + "#" + volume + "#" + marketCap + "#";
			
			String[] str1 =str.split("#");
		}
	}
}
