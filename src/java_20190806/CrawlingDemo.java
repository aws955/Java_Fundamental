package java_20190806;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {
	public static void main(String[] args) {
		String url = "http://www.imbc.com";
		// HTML 문서 전체를 관리하기 위한 객체
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("성공...");
		
		//자식이 있으면 Elements , 자식이 없으면 Element
		Elements elements = doc.select(".con-wrap.notice-wrap");
		
		Elements noticeElements = elements.select(".tit-wrap .cont-tit");
		String noticeTitle = noticeElements.text();
		System.out.println(noticeTitle);
		
		Elements liElements = elements.select(".notice-list li"); //li 가 5개 있으므로 하나하나는 Element 전체는 Elements
		for(int i =0;i<liElements.size(); i++) {
			Element liElement = liElements.get(i);
			System.out.println(liElement.text());
		}
		
		
	}
}
