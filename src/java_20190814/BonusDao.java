package java_20190814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BonusDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static BonusDao single;

	private BonusDao() {
	}

	public static BonusDao getInstance() {
		if (single == null) {
			single = new BonusDao();
		}
		return single;
	}

	public boolean insert(BonusDto b) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO bonus(ename,job,sal,comm) ");
			sql.append("VALUES (?,?,?,?) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, b.getEname());
			pstmt.setString(index++, b.getJob());
			pstmt.setInt(index++, b.getSal());
			pstmt.setInt(index++, b.getComm());

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

	public boolean delete(BonusDto b) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM bonus ");
			sql.append("WHERE ename = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, b.getEname());

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

	public boolean update(BonusDto b) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE bonus ");
			sql.append("SET job = ? , sal = ? , comm = ? ");
			sql.append("WHERE ename = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, b.getJob());
			pstmt.setInt(index++, b.getSal());
			pstmt.setInt(index++, b.getComm());
			pstmt.setString(index++, b.getEname());

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

	public ArrayList<BonusDto> select() {
		ArrayList<BonusDto> list = new ArrayList<BonusDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int index = 1;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ename,job,sal,comm ");
			sql.append("FROM bonus ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String ename = rs.getString(index++);
				String job = rs.getString(index++);
				int sal = rs.getInt(index++);
				int comm = rs.getInt(index++);
				
				list.add(new BonusDto(ename,job,sal,comm));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
