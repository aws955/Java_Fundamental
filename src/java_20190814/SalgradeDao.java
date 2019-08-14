package java_20190814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalgradeDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static SalgradeDao single;
	private SalgradeDao() {}
	public  static SalgradeDao getInstance() {
		if(single == null) {
			single = new SalgradeDao();
		}
		return single;
	}
	
	public boolean insert(SalgradeDto s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO salgrade(grade,losal,hisal) ");
			sql.append("VALUES (?,?,?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, s.getGrade());
			pstmt.setInt(index++, s.getLosal());
			pstmt.setInt(index++, s.getHisal());
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean delete(int i) {
		Connection con = null;
		PreparedStatement pstmt =null;
		boolean isSuccess = false;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM salgrade ");
			sql.append("WHERE grade = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, i);
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	public boolean update(SalgradeDto s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE salgrade ");
			sql.append("SET losal = ? , hisal = ? ");
			sql.append("WHERE grade =? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, s.getLosal());
			pstmt.setInt(index++, s.getHisal());
			pstmt.setInt(index++, s.getGrade());
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)	con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		return isSuccess;
	}
	public ArrayList<SalgradeDto> select(){
		ArrayList<SalgradeDto> list = new ArrayList<SalgradeDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT grade, losal,hisal ");
			sql.append("FROM salgrade ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int index = 1;
				int grade = rs.getInt(index++);
				int losal = rs.getInt(index++);
				int hisal = rs.getInt(index++);
				
				list.add(new SalgradeDto(grade, losal, hisal));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
