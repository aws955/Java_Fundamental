package java_20190807.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer1 {
	private int port;

	public EchoServer1(int port) {
		this.port = port;
	}

	public void run() {
		ServerSocket serverSocket=null;

		try {
			serverSocket = new ServerSocket(port);

			while (true) {
				System.out.println("클라이언트를 기다리고 있습니다");
				Socket socket = serverSocket.accept();
				System.out.println(InetAddress.getByName(socket.getInetAddress().getHostAddress()));
				
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String readLine = br.readLine();
				System.out.println(readLine);
				
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				
				bw.write(readLine);
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer1(3000).run();
	}
}
