package java_20190807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
	

		// URLConnection 클래스는 혼자 사용할 수 없다. 항상 URL을 이용하여 연결해야한다.
		// URL => HTML 정보만 가져올 수 있다.
		// URLConnection => HTML 정보뿐만 아니라 Header정보를 알수 있다.
		URL url = new URL("https://sports.news.naver.com/wbaseball/index.nhn");
		URLConnection urlCon = url.openConnection();

		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
		System.out.println("cacheControl: " + cacheControl);
		System.out.println("content-type: " + contentType);
		System.out.println("date: " + date);
		
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String readline = null;
		while((readline=br.readLine())!=null) {
			System.out.println(readline);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
