package java_20190801;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("c:\\dev\\test\\VSCodeUserSetup.exe");
			fos = new FileOutputStream("c:\\dev\\test\\2019\\08\\01\\VSCodeUserSetup.exe");
			int readByteCount = 0;
			byte[] b = new byte[1024*20];
			//fis.read(b) => FileInputStream 에 1024 바이트를 읽어서
			//b에 저장하고 읽은 바이트 수를 반환한다.
			while ((readByteCount = fis.read(b)) != -1) {
				fos.write(b,0,readByteCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
