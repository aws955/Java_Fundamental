package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			/*
			//1. FileInputStream 과 FileOutputStream을 이용하여 1바이트 읽어서 1바이트 출력한 예제 (걸린 시간 15초)
			fis = new FileInputStream("c:\\dev\\test\\java-pdf.zip");
			fos = new FileOutputStream("c:\\dev\\test\\java-pdf-copy.zip");
			
			long start = System.currentTimeMillis();
			
			int readByte = 0;
			while((readByte=fis.read())!=-1) {
				fos.write(readByte);
			}
			
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d%n", end-start);
			*/
			
			/*
			// 2. BufferedInputStream 과 BufferedOutputStream을 이용하여 1바이트 읽어서 1바이트 출력한 예제 (걸린시간 .265초)
			// BufferedInputStream 의 read() 메서드는 1바이트 읽어서 BufferedInputStream의 버퍼(byte[]) 공간에 저장한다
			// BufferedOutputStream 의 write() 메서드는 1바이트 출력하는 것이 아니라 BufferedOutputStream의 버퍼(byte[]) 공간이
			// 가득 차 있으면 출력한다. 만일 다 채워지지않으면 출력하지 않는다. 이런 경우 flush() 메서드를 이용하여 출력해야함.
			fis = new FileInputStream("c:\\dev\\test\\VSCodeUserSetup.exe");
			fos = new FileOutputStream("c:\\dev\\test\\VSCodeUserSetupCOPY.exe");
			
			//stream chaining
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			long start = System.currentTimeMillis();
			
			int readByte = 0;
			while((readByte=bis.read())!=-1) {
				bos.write(readByte);
			}
			// 꼭 해야한다. 마지막 순간에 버퍼가 다 쌓이지 않으면 출력을 안해주기때문에 비워주는 메서드이다.
			// BufferedOutputStream의 버퍼(byte[]) 는 다 채워지면 자동으로 전송하지만
			// 다 채워지지 않으면 전송하지 않는다. 따라서 flush() 를 이용하여 마지막 버퍼를 비워줘야한다.
			bos.flush();
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d%n", end-start);
			*/
			
			fis = new FileInputStream("c:\\dev\\test\\testfile");
			fos = new FileOutputStream("c:\\dev\\test\\testfileCOPY");
			
			long start = System.currentTimeMillis();
			
			int readByteCount = 0;
			byte[] readBytes = new byte[1024*8];
			//이 while 문에서 bis 와 bos 를 쓰는것은 의미가 없어진다.
			//BufferedInputStream 과 BufferedOutputStream 에는 해당 매개변수를 오버라이딩 하지 않았다.
			while((readByteCount=fis.read(readBytes))!=-1) {
				fos.write(readBytes,0,readByteCount);
			}
			
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d%n", end-start);
			
			
			/*
			//FileInputSteam 과 FileOutputStream 에 배열을 선언하여 하는 것보다 더 느리다.
			fis = new FileInputStream("c:\\dev\\test\\testfile");
			fos = new FileOutputStream("c:\\dev\\test\\testfileCOPY");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			long start = System.currentTimeMillis();
			
			int readByteCount = 0;
			byte[] readBytes = new byte[1024*8];
			while((readByteCount=bis.read(readBytes))!=-1) {
				bos.write(readBytes,0,readByteCount);
			}
			bos.flush();
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d%n", end-start);
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
				if(bis != null) bis.close();
				if(bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
