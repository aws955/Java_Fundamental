package java_20190805;

import bonus.Utility;

public class QrcodeDemo2 {
	public static void main(String[] args) {
		//ShortenURL 가져온것
		String clientId = "DceLeUzZKaI5ErRSr76K";
		String clientSecret = "B63r9RgELp";
		String oriUrl = "https://docs.google.com/spreadsheets/d/1AEbbhYgDMouucbzE4OOxLUXoYLMr2nNyWqE4wq3rTeU/edit#gid=0";
		String url = Utility.getShortenURL(clientId, clientSecret, oriUrl);

		if (Utility.isQrcode(url, 300, 300)) {
			System.out.println("QR 코드 성공");
		} else {
			System.out.println("실패");
		}
	}
}
