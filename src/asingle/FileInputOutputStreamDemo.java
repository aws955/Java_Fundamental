package asingle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("c:\\dev\\test\\VSCodeUserSetup.exe");
			File f = new File("c:\\dev\\test\\Solo");
			
			boolean isExisted = f.isDirectory();
			if(!isExisted) {
				f.mkdirs();
			}
			
			fos = new FileOutputStream("c:\\dev\\test\\Solo\\VSCodeUserSetup.exe");
			int readByteCount = 0;
			byte[] b = new byte[1024*10];
			while((readByteCount = fis.read(b)) != -1) {
				fos.write(b,0,readByteCount);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
