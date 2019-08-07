package java_20190807.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient1 {
	private String ip;
	private int port;
	public EchoClient1(String ip , int port) {
		this.ip = ip;
		this.port = port;
	}
	public void run() {
		try {
			
			while(true) {
			Socket socket = new Socket(ip,port);
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String str = new Scanner(System.in).nextLine();
			bw.write(str);
			bw.newLine();
			bw.flush();
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println(br.readLine());
			}
		} catch (UnknownHostException e) {
			System.out.println("아이피가 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("서버가 잘못되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		new EchoClient1("192.168.0.77",3000).run();
	}

}
