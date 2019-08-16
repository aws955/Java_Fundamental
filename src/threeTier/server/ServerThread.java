package threeTier.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable{
	private Socket socket = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		MemberDao d = MemberDao.getInstance();
		LoginDao ld = LoginDao.getInstance();
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			String[] m = msg.split("#");
			
			if(m[0].equals("insert")) {
				String id = m[1];
				String pwd= m[2];
				String name = m[3];
				
				boolean isSuccess = d.insert(new MemberDto(id,pwd,name));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				if(isSuccess) {
					bw.write("200");
					bw.newLine();
					bw.flush();
				}else {
					bw.write("100");
					bw.newLine();
					bw.flush();
				}
				
			}else if(m[0].equals("signin")) {
				String id = m[1];
				String pwd = m[2];
				
				ld.update(pwd);
				String npwd = ld.select();
				String opwd = d.select(id);
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				if(npwd.equals(opwd)) {
					bw.write("200");
					bw.newLine();
					bw.flush();
				} else {
					bw.write("100");
					bw.newLine();
					bw.flush();
				}
				
			}else if(m[0].equals("update")) {
				String id = m[1];
				String pwd= m[2];
				String name = m[3];
				
				boolean isSuccess = d.update(new MemberDto(id,pwd,name));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				if(isSuccess) {
					bw.write("200");
					bw.newLine();
					bw.flush();
				}else {
					bw.write("100");
					bw.newLine();
					bw.flush();
				}
			}else if(m[0].equals("delete")) {
				String id = m[1];
				
				boolean isSuccess = d.delete(id);
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				if(isSuccess) {
					bw.write("200");
					bw.newLine();
					bw.flush();
				}else {
					bw.write("100");
					bw.newLine();
					bw.flush();
				}
			}else if(m[0].equals("select")) {
				ArrayList<MemberDto> list =d.select();
				StringBuffer lists = new StringBuffer();
				
				for(MemberDto memberDto : list) {
					lists.append(memberDto.getId()+"#");
					lists.append(memberDto.getName()+"&");
				}
				
				String send = lists.toString();
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(send);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
