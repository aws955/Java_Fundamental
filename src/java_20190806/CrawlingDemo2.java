package java_20190806;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo2 {
	public static void main(String[] args) {
		String url = "https://sports.news.naver.com/kfootball/index.nhn";

		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("성공...");

		Elements elements = doc.select(".home_news");
		
		Elements liElements = elements.select(".home_news_list li"); 
		for (int i = 0; i < liElements.size(); i++) {
			Element liElement = liElements.get(i);
			System.out.println(liElement.text());
		}
	}
}
