package java_20190814;

import java.util.ArrayList;

public class NoticeTest {
	public static void main(String[] args) {
		NoticeDto n = new NoticeDto(17,"성영한13","제목13","내용13","now()");
		NoticeDao d = NoticeDao.getInstance();
		boolean isSuccess = false;
		
		isSuccess = d.insert(n);
		if(isSuccess) {
			System.out.println(isSuccess);
		}else {
			System.out.println(isSuccess);
		}
		
		n = new NoticeDto(13,"성영한13","제목13","내용13","now()");
		isSuccess = d.update(n);
		if(isSuccess) {
			System.out.println(isSuccess);
		}else {
			System.out.println(isSuccess);
		}
		
		ArrayList<NoticeDto> list = d.select();
		for(NoticeDto t : list) {
			System.out.printf("%d\t%s\t%s\t%s\t%s%n",t.getNum(),t.getWriter(),t.getTitle(),t.getContent(),t.getDatetime());
		}
		
		isSuccess = d.delete(1);
		if(isSuccess) {
			System.out.println(isSuccess);
		}else {
			System.out.println(isSuccess);
		}
	}
}
