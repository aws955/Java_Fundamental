package asingle.broadcast.server;

import java.net.Socket;

public class ServerThread implements Runnable {
	private Socket socket;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
