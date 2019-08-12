package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
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
				if ( pstmt != null) pstmt.close();
				if(con!= null) con.close();
			} catch (SQLException e2) {
			}
		}
		
		return isSuccess;
	}
	
	public boolean delete(int primaryKey) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("delete from member ");
			sql.append("where num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, primaryKey);
			
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
			}
		}
		
		return isSuccess;
	}
	
	public boolean delete(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("delete from member ");
			sql.append("where num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, m.getNum());
			
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
			}
		}
		
		return isSuccess;
	}
	
	public boolean update(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("update member ");
			sql.append("set name = ? , addr = ? ");
			sql.append("where num = ?");
			
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
				if ( pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
			}
		}
		
		return isSuccess;
	}
	
	public ResultSet select(String where) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("select num,name,addr ");
			sql.append("from member ");
			sql.append("where "+where);
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		
		
		
		return rs;
	}

}
