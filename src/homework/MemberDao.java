package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Load Fail...");
		}
	}
	
	private static MemberDao single;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(single == null) {
			single = new MemberDao();
		}
		return single;
	}
	
	public boolean insert(MemberDto m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index =1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic1234");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(m_seq,m_id,m_password)	");
			sql.append("VALUES (?,?,PASSWORD(?))					");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, m.getSeq());
			pstmt.setString(index++, m.getId());
			pstmt.setString(index++,m.getPwd());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
}
