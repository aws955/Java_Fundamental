package threeTier.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Fail...");
		}
	}
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
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(id,pwd,NAME) ");
			sql.append("VALUES (?,PASSWORD(?),?) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, m.getId());
			pstmt.setString(index++, m.getPwd());
			pstmt.setString(index++, m.getName());

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

	public boolean delete(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM member ");
			sql.append("WHERE id = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, id);

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
		int index = 1;
		boolean isSuccess = false;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE member ");
			sql.append("SET pwd = PASSWORD(?) , NAME = ? ");
			sql.append("WHERE id = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, m.getPwd());
			pstmt.setString(index++, m.getName());
			pstmt.setString(index++, m.getId());

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

	public ArrayList<MemberDto> select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id,NAME ");
			sql.append("FROM member ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int index = 1;
				String id = rs.getString(index++);
				String name = rs.getString(index++);
				list.add(new MemberDto(id,name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)	pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	public String select(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT pwd ");
			sql.append("FROM member ");
			sql.append("where id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				pwd = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)	pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return pwd;
	}
}
