package threeTier.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private int port;
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(port);
			ServerThread st = null;
			
			while(true) {
				System.out.println("클라이언트 접속 대기중 .....");
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 ip : " + ip);
				
				st = new ServerThread(socket);
				Thread t = new Thread(st);
				t.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server(3000).run();
	}
}
