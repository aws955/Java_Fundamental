package asingle.broadcast.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	private BufferedReader br;

	public Server(int port) {
		this.port = port;
	}

	public void run() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			//ServerThread st = null;
			while (true) {
				System.out.println("클라이언트 접속 대기중 .....");
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip);
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(br.readLine());
				
				//st = new ServerThread(socket);
				//Thread t = new Thread(st);
				//t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Server(7777).run();
	}
}
