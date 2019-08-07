package aChat;

import java.io.Closeable;
import java.io.IOException;

public class StreamUtil {
	
	//Closeable 은 각종 IO Class 들이 상속받은 Interface 이다.
	public static void close(Closeable out) {
		if(out!=null) {
			try {
				out.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
