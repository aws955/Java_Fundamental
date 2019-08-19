package java_20190819;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Member {
	private String id;
	private String pwd;
	private String name;

	Member(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class TransactionDemo {
	public boolean insert() {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		boolean isSuccess = false;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			
			con.setAutoCommit(false); //트랜잭션 시작
			
			sql.append("insert into member ");
			sql.append("values ('id1',password('test1'),'test1') ");
			
			pstmt1 = con.prepareStatement(sql.toString());
			pstmt1.executeUpdate();
			
			sql.setLength(0);
			sql.append("insert into member ");
			sql.append("value ('id2',password('test1'),'test1) ");
			
			pstmt2= con.prepareStatement(sql.toString());
			pstmt2.executeUpdate();
			
			isSuccess = true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isSuccess) {
					con.commit();
				}else {
					con.rollback();
				}
				con.setAutoCommit(true); //connection Pool 사용할때는 반드시 해주어야함.
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return isSuccess;
	}

	public static void main(String[] args) {
		new TransactionDemo().insert();
	}
}
