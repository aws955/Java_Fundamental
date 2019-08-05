package java_20190805;

import bonus.Utility;

public class APIExamShortenURL2 {
	public static void main(String[] args) {
        String clientId = "DceLeUzZKaI5ErRSr76K";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "B63r9RgELp";//애플리케이션 클라이언트 시크릿값";
        String oriUrl = "https://docs.google.com/spreadsheets/d/1AEbbhYgDMouucbzE4OOxLUXoYLMr2nNyWqE4wq3rTeU/edit#gid=0";
        String url = Utility.getShortenURL(clientId, clientSecret, oriUrl);
        System.out.println(url);
    }
}
