package java_20190806;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bonus.Utility;

public class CoinMarketCap {
	public static void main(String[] args) {
		// 나중에 날짜나 코인이름은 변수 처리하여 원하는 것을 가져올 수도 있음
		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end=20190806";

		Document doc = null;
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("새파일");
		HSSFRow row = null;
		HSSFCell cell = null;
		
		

		
		try {
			doc = Jsoup.connect(url).get();

		System.out.println("성공...");
		
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Date");
		
		cell = row.createCell(1);
		cell.setCellValue("Open");
		
		cell = row.createCell(2);
		cell.setCellValue("High");
		
		cell = row.createCell(3);
		cell.setCellValue("Low");
		
		cell = row.createCell(4);
		cell.setCellValue("Close");
		
		cell = row.createCell(5);
		cell.setCellValue("Volume");
		
		cell = row.createCell(6);
		cell.setCellValue("MarketCap");
		
		Elements bodyElements = doc.select(".table-responsive .table tbody tr");
		

		for (int i = 0; i < bodyElements.size(); i++) {
			int index = 0;
			Element trElement = bodyElements.get(i);
			
			//값을 반복문으로 안받는 이유는 나중에 뺄값이 있을 수 있기 때문이다.
			String date = trElement.child(index++).text();
			date = Utility.getKoreanDate(date);
			String open = trElement.child(index++).text();
			String high = trElement.child(index++).text();
			String low = trElement.child(index++).text();
			String close = trElement.child(index++).text();
			String volume = trElement.child(index++).text();
			String marketCap = trElement.child(index++).text();
			
			row = sheet.createRow(i+1);
			cell = row.createCell(0);
			cell.setCellValue(date);
			
			cell = row.createCell(1);
			cell.setCellValue(open);
			
			cell = row.createCell(2);
			cell.setCellValue(high);
			
			cell = row.createCell(3);
			cell.setCellValue(low);
			
			cell = row.createCell(4);
			cell.setCellValue(close);
			
			cell = row.createCell(5);
			cell.setCellValue(volume);
			
			cell = row.createCell(6);
			cell.setCellValue(marketCap);
			
		}
			FileOutputStream fos = new FileOutputStream("c:\\dev\\test\\crawling.xls");

			workbook.write(fos);

			fos.close();
			workbook.close();
			System.out.println("성공...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
