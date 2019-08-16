package threeTier.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private String ip;
	private int port;

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void sign() {
		try {
			Socket socket = new Socket(ip, port);
			BufferedWriter bw = null;
			BufferedReader br = null;

			System.out.println("1.SignIn 2.SignUp 3. Exit");
			System.out.println("원하는 작업을 선택하시오 ");

			String sign = new Scanner(System.in).next();

			if (sign.equals("1")) {
				System.out.println("id를 입력하시오 >");
				String id = new Scanner(System.in).next();
				System.out.println("pw를 입력하시오>");
				String pwd = new Scanner(System.in).next();

				String msg = "signin#" + id + "#" + pwd;
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(msg);
				bw.newLine();
				bw.flush();

				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String isSuccess = br.readLine();

				if (isSuccess.equals("200")) {
					System.out.println("로그인 성공");
					aftersign(id);
				} else {
					System.out.println("로그인 실패");
					sign();
				}

			} else if (sign.equals("2")) {
				System.out.println("id를 입력하시오 >");
				String id = new Scanner(System.in).next();
				System.out.println("pw를 입력하시오>");
				String pwd = new Scanner(System.in).next();
				System.out.println("이름을 입력하시오>");
				String name = new Scanner(System.in).next();

				String msg = "insert#" + id + "#" + pwd + "#" + name;

				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(msg);
				bw.newLine();
				bw.flush();

				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String isSuccess = br.readLine();

				if (isSuccess.equals("200")) {
					System.out.println("가입성공");
				} else {
					System.out.println("가입실패. id 중복을 확인하세요.");
				}
				sign();

			} else if (sign.equals("3")) {
				System.out.println("종료합니다. 안녕히가십시오.");
			} else {
				System.out.println("올바른 번호를 선택하세요");
				sign();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void aftersign(String id) {
		try {
			Socket socket = new Socket(ip, port);
			BufferedWriter bw = null;
			BufferedReader br = null;
			
			System.out.println("1.Update 2.Delete 3.Select 4.Logout 5.exit");
			System.out.println("원하는 작업을 선택하시오 ");

			String sign = new Scanner(System.in).next();
			
			if(sign.equals("1")) {
				System.out.println("변경할 pw를 입력하시오>");
				String pwd = new Scanner(System.in).next();
				System.out.println("변경할 이름을 입력하시오>");
				String name = new Scanner(System.in).next();
				
				String msg = "update#" + id + "#" + pwd + "#" + name;
				
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String isSuccess = br.readLine();

				if (isSuccess.equals("200")) {
					System.out.println("업데이트 성공");
				} else {
					System.out.println("업데이트 실패");
				}
				aftersign(id);

			}else if(sign.equals("2")) {
				System.out.println("회원탈퇴를 원하시면 confirm 을 입력하세요>");
				String confirm = new Scanner(System.in).next();
				
				if(confirm.equals("confirm")) {
					String msg = "delete#" + id ;
					
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					bw.write(msg);
					bw.newLine();
					bw.flush();
					
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String isSuccess = br.readLine();

					if (isSuccess.equals("200")) {
						System.out.println("삭제 성공");
						sign();
					} else {
						System.out.println("삭제 실패");
						aftersign(id);
					}
				}else {
					System.out.println("돌아갑니다.");
					aftersign(id);
				}
				
			}else if(sign.equals("3")) {
				String msg = "select#" + id ;
				
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String list = br.readLine();
				
				String[] memberDtoList = list.split("&");
				
				System.out.println("아이디\t이름");
				for(int i = 0; i<memberDtoList.length;i++) {
					String[] memberDtoInfo = memberDtoList[i].split("#");
					System.out.println(memberDtoInfo[0] + "\t" + memberDtoInfo[1]);
				}
				
				aftersign(id);
				
			}else if(sign.equals("4")) {
				System.out.println("로그아웃합니다. 안녕히 가십시오");
				sign();
			}else if(sign.equals("5")) {
				System.out.println("종료합니다. 안녕히가십시오.");
			}else {
				System.out.println("올바른 번호를 선택하세요");
				aftersign(id);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client("127.0.0.1", 3000).sign();
	}
}
