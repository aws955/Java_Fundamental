package aChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultichatServer {

	// 대화명, 클라이언트 OutputStream 저장용 대화방(HashMap) 정의
	Map<String, DataOutputStream> clients;

	// 생성자
	MultichatServer() {
		clients = Collections.synchronizedMap(new HashMap<String, DataOutputStream>());
	}

	// 비즈니스 로직을 처리하는 메서드
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 포트번호로 서버 소켓 생성
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다");

			while (true) {
				// 클라이언트 접속 대기 accept()
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] 에서 접속하였습니다.");

				// 서버에서 클라이언트로 메세지를 전송할 Thread 생성
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SocketUtil.close(serverSocket);
		}
	}

	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();

		while (it.hasNext()) {
			try {
				String name = it.next();
				DataOutputStream out = clients.get(name);
				out.writeUTF(msg);
			} catch (IOException e) {

			}
		}
	}

	public static void main(String[] args) {
		new MultichatServer().start();
	}

	// Inner Class 정의 (대화방 field에 접근하기 위해)
	// 서버에서 클라이언트로 메세지를 전송할 Thread
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		// 생성자
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 클라이언트 소켓에서 데이터를 수신 받는 InputStream
				in = new DataInputStream(socket.getInputStream());

				// 클라이언트 소켓에서 데이터를 전송 받은 OutputStream
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {

			}
		}

		public void run() {
			String name = null;
			try {
				// 서버에서는 최초에 클라이언트가 보낸 대화명을 받는다.
				name = in.readUTF();

				// 대화명을 받아 서버에 접속한 클라이언트에게 대화방 참여 메세지를 보낸다.
				sendToAll("#" + name + "님이 입장하였습니다");

				// 대화명, 클라이언트로 메세지를 보낼 수 있는 OutputStream 객체를 대화방 Map에 저장한다.
				clients.put(name, out);
				System.out.println("현재 서버 접속자 수는" + clients.size() + "입니다.");

				// 클라이언트가 전송한 메세지를 받아, 전에 클라이언트에게 메세지를 보낸다.
				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {

			} finally {
				// finally 절이 실행된다는 것은 클라이언트가 나간것을 의미
				sendToAll("#" + name + "님이 나가셨습니다.");

				// 대화방에서 객체 삭제
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는" + clients.size() + "입니다.");
			}
		}

	}

}
