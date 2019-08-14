package java_20190814;

import java.util.ArrayList;

public class SalgradeDemo {
	public static void main(String[] args) {
		SalgradeDto s = new SalgradeDto(7,1,1);
		SalgradeDao d = SalgradeDao.getInstance();
		boolean isSuccess = false;
		
		isSuccess = d.insert(s);
		System.out.println(isSuccess);
		
		s = new SalgradeDto(7, 2, 2);
		isSuccess = d.update(s);
		System.out.println(isSuccess);
		
		ArrayList<SalgradeDto> list = d.select();
		for(SalgradeDto t : list) {
			int grade = t.getGrade();
			int losal = t.getLosal();
			int hisal = t.getHisal();
			
			System.out.printf("%d\t%d\t%d%n", grade,losal,hisal);
		}
		
		isSuccess = d.delete(7);
		System.out.println(isSuccess);
		
	}
}
