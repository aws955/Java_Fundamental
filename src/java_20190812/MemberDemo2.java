package java_20190812;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDemo2 {
	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		
		ResultSet rs = null;
		
		rs = dao.select("num >10 and num<20");
		try {
			while(rs.next()) {
				int index = 1;
				int num = rs.getInt(index++);
				String name = rs.getString(index++);
				String addr = rs.getString(index++);
				System.out.printf("번호 : %d , 이름 : %s , 주소 : %s%n",num,name,addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
