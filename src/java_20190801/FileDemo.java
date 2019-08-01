package java_20190801;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	//유용한 메서드들은 static 으로 많이 선언한다.
	//자주사용하는 것은 자기만의 메서드로 만들어서 관리하는게 좋다.
	public void mkdirs(String path) {
		File f = new File(path);
		// 해당 경로의 파일이 존재하는지 여부
		boolean isExisted = f.isDirectory();
		if(!isExisted) {
			//mkdir() 는 디렉토리를 하나만 만들어주기에 잘 쓰지 않는다.
			//mkdirs() 는 디렉토리 안에 여러 디렉토리까지 만들어줄 수 있다.
			f.mkdirs();
		}
	}
	
	public String getComma(long name) {
		return String.format("%,d", name);
	}
	public String getComma(double name,int precision) {
		return String.format("%,."+precision+"f", name);
	}
	
	public void changeFile(String path) {
		//path => c:\\dev\test\\VS.exe   의 파일이름을 밀리세컨즈로 바꿔준다
		File f1 = new File(path);
		//f1.getPath() : 전체경로 + 파일이름
		//f1.getName() : 파일이름만
		String fileName = f1.getName(); 
		String name = fileName.substring(0,fileName.lastIndexOf("."));
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		name = String.valueOf(System.currentTimeMillis());
		fileName = name +"."+ extension;
		
		//파일 이름의 상위 폴더의 경로를 반환
		String parent = f1.getParent();
		File f2 = new File(parent,fileName);
		f1.renameTo(f2);
	}
	
	public static void main(String[] args) {
		
		/*
		// '\' 는 인식이 안되기 대문에 '\\' 로 해줘야한다.
		FileDemo f1 = new FileDemo();
		f1.mkdirs("c:\\dev\\test\\2019\\01\\02");
		
		//(파일경로,파일 이름)
		//length() 를 통해 파일 사이즈를 알수있다.
		File f2 = new File("C:\\dev\\test","VSCodeUserSetup-x64-1.36.1.exe");
		long fileSize = f2.length()/1024;
		System.out.println(f1.getComma(fileSize)+"KB");
		//false 일시에는 디렉토리 / true 일때는 파일
		boolean isFile = f2.isFile();
		if(isFile) {
			//f2의 전체 경로를 반환한다.
			String path = f2.getPath();
			if(path.endsWith("pdf")) {
				System.out.println("PDF 파일");
			}else if(path.endsWith("exe")) {
				System.out.println("응용프로그램");
			}else if(path.endsWith("txt")) {
				System.out.println("텍스트문서");
			}
		}else {
			System.out.println("파일폴더");
		}
		
		
		File f3 = new File("C:\\dev\\test","VS.exe");
		//f2 파일을 f3 파일이으로 변경
		f2.renameTo(f3);
		
		f1.changeFile("C:\\dev\\test\\1564624516203.txt");
		*/
		
		File f4 = new File("c:\\dev\\test\\VSCodeUserSetup.exe");
		String fileName = f4.getName();
		String path = f4.getPath();
		String parent = f4.getParent();
		System.out.println(fileName);
		System.out.println(path);
		System.out.println(parent);
		
		/*
		//currentTimeMillis 와 같은 기능 
		//생성된 날짜를 밀리세컨즈로 반환
		System.out.println(f4.lastModified());
		*/
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(f4.lastModified());
		
		/*
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
		
		System.out.println(year + " , "+ month + " , " + day);
		*/
		
		//SimpleDateFormat 클래스는 간단하게 날짜를 format 할 수 있도록 도와준다. 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E요일");
		String date = sdf.format(c.getTime());
		System.out.println(date);
		
		
		
		File f5 = new File("c:\\dev\\test");
		String[] lists = f5.list();
		
		for (String list : lists) {
			File f6 = new File(f5,list); //pdf 의 3번째 방법 사용
			String name = f6.getName();
			if(f6.isDirectory()) {
				System.out.println(name+"-디렉토리");
			}else {
				long fileSize = f6.length()/1024;
				c.setTimeInMillis(f6.lastModified());
				String lastModified = sdf.format(c.getTime());
				
				System.out.println(name+"\t"+fileSize+"k"+"\t"+lastModified);
			}
		}
	}
}






























