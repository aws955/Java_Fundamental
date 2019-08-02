package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try {
			ps = System.out; //모니터와 연결 (목적지가 모니터)
			ps.println("Hello World");
			//PrintStream 은 다양한 텍스트를 출력하기 위해서 사용한다.
			
			/*
			System.out.println()
			자바를 해봤으면 위의 메서드는 모두 사용해 봤을 것이다. 
			System이라는 클래스에 out이라는 객체 안에 println이라는 메서드를 호출하는 형태로 구성되어 있다.
			그렇다면 System.out.println()에 대한 API 문서를 확인해 보자.

			java.lang이라는 패키지 안에 System이라는 클래스가 정의되어 있다.
			out은 객체이기 때문에 field summary 부분에서 확인이 가능하다.
			out이라는 변수의 데이터 타입은 PrintStream이고 PrintStream이라는 클래스를 담고 있다라는 뜻이다.
			 PrintStream을 클릭하면 PrintStream 클래스에 관한 페이지로 넘어가며 아래로 내려가면 Method Summary에서 println()에 대한 정보를 찾을 수 있다.


			출처: https://debugdaldal.tistory.com/155 [달달한 디버깅]
			*/
			
			fis = new FileInputStream("c:\\dev\\test\\VSCodeUserSetup.exe");
			bis = new BufferedInputStream(fis);

			fos = new FileOutputStream("c:\\dev\\test\\VSCodeUserSetupClone.exe");
			bos = new BufferedOutputStream(fos);
			
			ps = new PrintStream(bos,true); //auto-flush 기능이 있다.
			
			int readByte = 0;
			while ((readByte = bis.read()) != -1) {
				ps.write(readByte);
			}
			//bos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
				if (ps != null)
					ps.close();
			} catch (IOException e) {

			}
		}
	}
}
