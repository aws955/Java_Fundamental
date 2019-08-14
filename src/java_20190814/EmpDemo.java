package java_20190814;

import java.util.ArrayList;

public class EmpDemo {
	public static void main(String[] args) {
		EmpDto e = new EmpDto(3, "test", "test", 0, "now()", 0.0, 0.0, 10);
		EmpDao d = EmpDao.getInstance();
		boolean isSuccess = false;

		isSuccess = d.insert(e);
		if (isSuccess) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}

		e = new EmpDto(2, "test1", "test1", 0, "now()", 1.1, 1.1, 10);
		isSuccess = d.update(e);
		if (isSuccess) {
			System.out.println("update 성공");
		} else {
			System.out.println("update 실패");
		}

		ArrayList<EmpDto> list = d.select();
		for (EmpDto t : list) {
			System.out.printf("%d\t%s\t%s\t%d\t%s\t%f\t%f\t%d%n", t.getEmpNo(), t.geteName(), t.getJob(), t.getMgr(),
					t.getHireDate(), t.getSal(), t.getComm(), t.getDeptNo());
		}
		
		isSuccess = d.delete(1);
		if(isSuccess) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
	}
}
