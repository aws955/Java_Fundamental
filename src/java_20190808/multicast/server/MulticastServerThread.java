package java_20190808.multicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


public class MulticastServerThread implements Runnable {
	private Socket socket = null;
	private ArrayList<MulticastServerThread> list;
	private BufferedWriter bw;
	
	public MulticastServerThread(Socket socket,ArrayList<MulticastServerThread> list) {
		this.socket = socket;
		this.list = list;
	}

	public void run() {
		BufferedReader br=null;
		
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
					broadCast(readLine + "\n");
				}
			
			}
			list.remove(this);
		} catch (IOException e) {
			System.out.println("비정상적으로 종료하셨습니다.");
			list.remove(this);
		} finally {
			try {
				if(br !=null) br.close();
				if(bw!=null) bw.close();
			} catch(IOException e) {
				
			}
		}
	}
	
	public void broadCast(String msg) throws IOException {
		for(MulticastServerThread mst : list) {
			mst.sendMessage(msg);
		}
	}
	
	private void sendMessage(String msg) throws IOException {
		bw.write(msg);
		bw.flush();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
