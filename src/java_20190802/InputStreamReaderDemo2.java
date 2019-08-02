package java_20190802;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReaderDemo2 {
	public static void main(String[] args) {

		FileOutputStream fos = null;

		System.out.println("입력하세요>");

		InputStream in = System.in;

		byte[] b = new byte[1024 * 8];
		int readByteCount = 0;
		try {
			fos = new FileOutputStream("c:\\dev\\test\\keyboard.txt", true);
			while ((readByteCount = in.read(b)) != -1) {
				String str = new String(b, 0, readByteCount).trim();
				if (str.equals("exit"))
					break;
				fos.write(b, 0, readByteCount);
				System.out.println("입력하세요>");
			}

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
