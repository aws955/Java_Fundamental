package asingle.broadcast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	private JFrame jframe;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jbtn;
	private String id;
	BufferedWriter bw = null;
	BufferedReader br = null;
	
	public GUI(String id) {
		
		this.id = id;
		// 전체 화면 선언
		jframe = new JFrame("GGULGAM CHAT");

		// *********중앙 시작****************
		// jta = > JTextArea 로 만들어 주고 변경하지 못하게 선언 / 스크롤 바가 필요할때 보이게 /
		jta = new JTextArea("", 30, 50);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// *********중앙 끝****************

		// *********하단 시작****************
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		jbtn.setBackground(Color.yellow);
		JPanel j1 = new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf, BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		// *********하단 끝****************

		// *********상단 시작****************
		JPanel j2 = new JPanel();
		JLabel jl1 = new JLabel("User ID : [" + id + "]");
		j2.setBackground(Color.cyan);
		JLabel jl2 = new JLabel("환영합니다");
		j2.setLayout(new BorderLayout());
		j2.add(jl1, BorderLayout.CENTER);
		j2.add(jl2, BorderLayout.EAST);
		// *********상단 끝*****************

		jframe.add(jsp, BorderLayout.CENTER);
		jframe.add(j1, BorderLayout.SOUTH);
		jframe.add(j2, BorderLayout.NORTH);

		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);

		
		// 닫으면 종료(원래는 무한 루프를 돌고있음)
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
				try {
					bw.write("shutdown\n");
					bw.flush();
					String readLine = br.readLine();
					if(readLine.equals("shutdown")) {
						close();
						System.exit(0);
					}
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});

		// 이벤트 등록
		jbtn.addActionListener(this);
		jtf.addActionListener(this);
		JFrame.setDefaultLookAndFeelDecorated(true);
	}

	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj == jtf) {
			
			// 텍스트 필드 가져오기
			String message = jtf.getText();
			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "입력하시오");
			} else {
				try {
					bw.write(id+" : " +message + "\n");
					bw.flush();
					String readLine = br.readLine();
					jta.append(readLine + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			jtf.setText("");
			
		} else if (obj == jbtn) {
			String message = jtf.getText();
			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "입력하시오");
			} else {
				// 텍스트 에어리어에 추가하기
				jta.append(id + " : " + message + "\n");
				// 텍스트 필드에 입력된 값 없애기
				jtf.requestFocus();
			}
			jtf.setText("");

		}
	}
	private void close() {
		try {
			if(bw != null)bw.close();
			if(br!=null) br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
