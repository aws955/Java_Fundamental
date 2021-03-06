package asingle.broadcast.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private static final int PORT = 7777;
	private static final String SERVERIP = "192.168.0.77";
	private String id = null;
	private PrintWriter pw = null;
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	private Socket socket = null;
	
	private static void run() {
		System.out.println("아이디를 입력하시오.");
		String id = new Scanner(System.in).nextLine();
		new Client(id);
	}
	
	private Client(String id) {
		this.id = id;
		new GUI(id);
		try {
			socket = new Socket(SERVERIP, PORT);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			pw = new PrintWriter(bw,true);
			pw.write("안녕하세요");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		run();
	}
}
