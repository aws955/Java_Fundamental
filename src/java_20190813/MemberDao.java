package java_20190813;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Dao (Data Access Object)
//Dto (Data Transfer Object)
public class MemberDao {

	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 1. singleton 코딩
	private static MemberDao single;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		if (single == null) {
			single = new MemberDao();
		}
		return single;
	}

	public boolean insert(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member(num,name,addr) ");
			sql.append("values (?,?,?)");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setInt(index++, m.getNum());
			pstmt.setString(index++, m.getName());
			pstmt.setString(index++, m.getAddr());

			pstmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return isSuccess;
	}

	public boolean update(MemberDto m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			//바인딩 변수(?)는 반드시 컬럼 값에만 설정할 수 있다.
			StringBuffer sql = new StringBuffer();
			sql.append("update member ");
			sql.append("set name = ? , addr = ? ");
			sql.append("where num = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, m.getName());
			pstmt.setString(index++, m.getAddr());
			pstmt.setInt(index++, m.getNum());
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return isSuccess;
	}
	
	public boolean delete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM member ");
			sql.append("WHERE num= ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, num);
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public ArrayList<MemberDto> select(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		ResultSet rs = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num,NAME,addr ");
			sql.append("FROM member ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				index =1;
				int num = rs.getInt(index++);
				String name = rs.getString(index++);
				String addr = rs.getString(index++);
				
				list.add(new MemberDto(num,name,addr));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		return list;	
	}

}
