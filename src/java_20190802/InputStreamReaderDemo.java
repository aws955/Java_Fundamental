package java_20190802;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReaderDemo {
	public static void main(String[] args) {

		FileOutputStream fos = null;

		System.out.println("입력하세요>");

		// 자바에서는 하드웨어와 묶여 있는게 딱 두개 있다.
		// System.in = > 키보드 (입력을 하면 InputStream 으로 반환해준다)
		// System.out = > 모니터
		// InputStream 에는 바이너리(1바이트) 가 와야하는데 사용자 입력을 받으면 텍스트가 오기 때문에
		// InputSteam 으로 처리하기에는 무리가 있다.
		// 그래서 다른 것을 이용한다.
		InputStream in = System.in;

		byte[] b = new byte[1024 * 8];
		int readByteCount = 0;
		try {
			readByteCount = in.read(b);
			// System.in 을 한 상태로 이 메서드를 실행하면 커서를 둔채로 입력을 기다린다. (Enter를 칠때까지)
			fos = new FileOutputStream("c:\\dev\\test\\keyboard.txt", true); // 여기서 true 를 주면 이어서 쓸수 있다.
			fos.write(b, 0, readByteCount);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
