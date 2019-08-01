package java_20190801;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		// try catch 와 finally 에서 try catch 반복
		// 아래와 같은 코딩의 반복
		try {
			// 해당 파일과 자바에 stream 을 만든것이다. (입력과 출력 둘다)
			// 연결했다면 반드시 끊어줘야한다
			// FileOutputStream 은 경로만 맞다면 파일이 없을시 생성해버린다.
			// FileOutputStream(String path) 생성자에서 FileNotFoundException 에러의 의미는
			// 경로가 없기 때문에 발생하는 것임
			// 따라서 FileOutputStream 객체를 생성할 때는 경로가 있는지 체크한 후에 객체를 생성해야 한다.
			// 아래와 같은 read / write 는 1바이트를 읽어와 쓰기때문에 시간이 굉장히 오래걸린다.
			fis = new FileInputStream("c:\\dev\\test\\son.jpg");
			File f1 = new File("c:\\dev\\test\\2019\\08\\01");
			boolean isExisted = f1.isDirectory();
			if (!isExisted) {
				f1.mkdirs();
			}
			fos = new FileOutputStream("c:\\dev\\test\\2019\\08\\01\\son1.jpg");

			int readByte = 0;
			// -1 의 의미는 읽을 것이 없다.
			// fis.read() 메서드는 한 바이트 읽어 반환한다.
			// 만약 더 이상 읽을 바이트가 없으면 -1 을 반환한다.
			while ((readByte = fis.read()) != -1) {
				//fos.write(readByte) 는  한바이트 쓰기
				fos.write(readByte);
			}
			System.out.println("성공");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
				// 무조건 실행이 되기 때문에 위에서 예외가 발생해서 null 인 상태로 실행될 가능성도 있다.
				// 만약 그렇게 되면 예외가 또 발생하므로 null 인지 아닌지 확인해야한다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
