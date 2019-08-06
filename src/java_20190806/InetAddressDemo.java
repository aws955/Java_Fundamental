package java_20190806;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		
		//ip 와 호스트 이름을 가져오는법
		InetAddress i = InetAddress.getLocalHost();
		System.out.printf("호스트이름: %s%n",i.getHostName());
		System.out.printf("호스트 IP : %s%n", i.getHostAddress());
		
		//naver 같은경우에는 server가 여러개라 아이피가 바뀔수 있다.
		InetAddress i1 = InetAddress.getByName("naver.com");
		System.out.printf("호스트이름: %s%n",i1.getHostName());
		System.out.printf("호스트 IP : %s%n", i1.getHostAddress());
	}
}
