package java_20190806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException, MalformedURLException{
		
		URL url = new URL("https://sports.news.naver.com/mlb/news/read.nhn?oid=224&aid=0000004260#content");
		String protocol = url.getProtocol();
		String hostString = url.getHost();
		int port = url.getPort();
		//getDefaultPort() 를 사용하게되면 protocol 의 port를 가져온다.
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.printf("protocol: %s, host: %s, port: %d, Path: %s, query: %s, ref: %s%n", protocol,hostString,port,path,query,ref);
		
		
		
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String readline = null;
		while((readline=br.readLine())!=null) {
			System.out.println(readline);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
