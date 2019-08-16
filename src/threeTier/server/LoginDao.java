package threeTier.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static LoginDao single;

	private LoginDao() {
	}

	public static LoginDao getInstance() {
		if (single == null) {
			single = new LoginDao();
		}
		return single;
	}

	public boolean update(String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE login ");
			sql.append("SET pwd = PASSWORD(?) ");
			sql.append("WHERE id = 'aws955' ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, pwd);

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

	public String select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = null;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT pwd ");
			sql.append("FROM login ");
			sql.append("where id = 'aws955' ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				pwd = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pwd;
	}
}
