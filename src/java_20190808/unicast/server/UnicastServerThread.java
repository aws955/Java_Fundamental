package java_20190808.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	private Socket socket = null;

	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}

	BufferedReader br;
	BufferedWriter bw;
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			boolean isStop = false;
			while (!isStop) {
				String readLine = br.readLine();
				System.out.println(readLine);
				if(readLine.equals("shutdown")) {
					bw.write("shutdown\n");
					bw.flush();
					isStop =true;
				}else {
					bw.write(readLine + "\n");
					bw.flush();
				}
			
			}
		} catch (IOException e) {
			System.out.println("비정상적으로 종료하셨습니다.");
		} finally {
			try {
				if(br !=null) br.close();
				if(bw!=null) bw.close();
			} catch(IOException e) {
				
			}
		}
	}

}
