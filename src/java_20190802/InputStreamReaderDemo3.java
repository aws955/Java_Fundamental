package java_20190802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputStreamReaderDemo3 {
	public static void main(String[] args) {

		System.out.println("입력하세요>");
		InputStream in = System.in;
		InputStreamReader isr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);

			fw = new FileWriter("c:\\dev\\test\\keyboard.txt", true); // 이어쓰기
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true); // autoFlush

			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				if(readLine.equals("exit")) break;
				pw.println(readLine);
				System.out.println("입력하세요>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (isr != null)
					isr.close();
				if (br != null)
					br.close();
				if (fw != null)
					fw.close();
				if (bw != null)
					bw.close();
				if (pw != null)
					pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
