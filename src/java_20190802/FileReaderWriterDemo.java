package java_20190802;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("c:\\dev\\test\\kic.txt");
			fw = new FileWriter("c:\\dev\\test\\kic-copy.txt");
			
			/* 
			int readChar = 0;
			while((readChar = fr.read())!= -1) {
				fw.write(readChar);
				System.out.print((char)readChar);
			}
			*/
			int readCharCount = 0;
			char[] readChars = new char[1024];
			while((readCharCount = fr.read(readChars)) != -1) {
				System.out.print(new String(readChars,0,readCharCount));
				fw.write(readChars,0,readCharCount);
				//fw.write(new String(readChars,0,readCharCount)); String 도 매개변수로 받을 수 있기 때문에 가능하다
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) fr.close();
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
