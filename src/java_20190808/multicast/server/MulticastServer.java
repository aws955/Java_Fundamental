package java_20190808.multicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServer {
	private int port;
	private ArrayList<MulticastServerThread> list;
	
	public MulticastServer(int port) {
		this.port = port;
		list = new ArrayList<MulticastServerThread> ();
	}

	public void run() {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(port);

			MulticastServerThread mst = null;
			while (true) {
				System.out.println("클라이언트 접속 대기중 .....");
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 ip : " + ip);
				mst = new MulticastServerThread(socket,list);
				
				list.add(mst);
				
				Thread t = new Thread(mst);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MulticastServer(6000).run();
	}
}
