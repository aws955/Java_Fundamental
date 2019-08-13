package java_20190813;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance();
		/*
		MemberDto m1 = new MemberDto(19, "트럼프", "미국");
		
		boolean isSuccess = mdao.insert(m1);
		if(isSuccess) {
			System.out.println("insert success");
		}else {
			System.out.println("insert fail");
		}
		
		m1 = new MemberDto(16,"트럼프2","미국2");
		isSuccess = mdao.update(m1);
		if(isSuccess) {
			System.out.println("update success");
		}else {
			System.out.println("update fail");
		}
		
		
		isSuccess = mdao.delete(20);
		if(isSuccess) {
			System.out.println("delete success");
		}else {
			System.out.println("delete fail");
		}
		*/
		
		ArrayList<MemberDto> list = mdao.select();
		for(MemberDto m : list) {
			System.out.printf("%d\t%s\t%s%n",m.getNum(),m.getName(),m.getAddr());
		}
	}
}
