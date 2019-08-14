package java_20190814;

import java.util.ArrayList;

public class BonusDemo {
	public static void main(String[] args) {
		BonusDto b = new BonusDto("test","test",0,0);
		BonusDao d = BonusDao.getInstance();
		boolean isSuccess = false;
		
		isSuccess = d.insert(b);
		System.out.println(isSuccess);
		
		isSuccess = d.update(b);
		System.out.println(isSuccess);
		
		ArrayList<BonusDto> list = d.select();
		for(BonusDto t : list) {
			System.out.printf("%s\t%s\t%d\t%d%n",t.getEname(),t.getJob(),t.getSal(),t.getComm());
		}
		
		isSuccess =d.delete(b);
		System.out.println(isSuccess);
		
		
	}
}
