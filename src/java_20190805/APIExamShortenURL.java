package java_20190805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//결과에 나오는 {} 안의 내용이 json 이다.
//json-simple-1.1.1.jar 를 이용 =>자바스크립트 객체를 자바로 표현하기 위한 파일
//json => javascript object notation => 자바스크립트 객체 표기
//자바스크립트 객체 형식 => {"키" : "value" , "키" : "value" ..... }

//계층적인 구조로 되어있다.
//예시 : {"message":"ok",
//		"result":{"hash":"IgBT0cOL",
//				  "url":"http://me2.do/IgBT0cOL",
//				  "orgUrl":"https://developers.naver.com/notice"},
//		"code":"200"}
//구조
//전체 Json Object 
//message , result , code 의 키를 가진 3개의 Json Object (message 와 code 안에는 값이 들어있고 result 안에는 Json Object 가 들어있다.)
//result 안에는 hash , url , orgUrl 의 키를 가진 3개의 Json Object 를 가지고 있다.

public class APIExamShortenURL {
	public static void main(String[] args) {
        String clientId = "DceLeUzZKaI5ErRSr76K";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "B63r9RgELp";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = "https://developers.naver.com/notice";
            String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
