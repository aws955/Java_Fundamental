package java_20190814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20190813.DeptDao;
import java_20190813.DeptDto;

public class EmpDao {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Load Fail...");
		}
	}

	private static EmpDao single;

	private EmpDao() {

	}

	public static EmpDao getInstance() {
		if (single == null) {
			single = new EmpDao();
		}
		return single;
	}

	private static boolean isCorrect(EmpDto e) {
		boolean isCorrect = false;
		DeptDao d = DeptDao.getInstance();

		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		list = d.select();

		for (DeptDto dt : list) {
			if (dt.getNo() == e.getDeptNo()) {
				isCorrect = true;
				break;
			}
		}

		return isCorrect;
	}

	public boolean insert(EmpDto e) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		if (EmpDao.isCorrect(e)) {
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) ");
				sql.append("VALUES (?,?,?,?,NOW(),?,?,?) ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(index++, e.getEmpNo());
				pstmt.setString(index++, e.geteName());
				pstmt.setString(index++, e.getJob());
				pstmt.setInt(index++, e.getMgr());
				pstmt.setDouble(index++, e.getSal());
				pstmt.setDouble(index++, e.getComm());
				pstmt.setInt(index++, e.getDeptNo());

				pstmt.executeUpdate();
				isSuccess = true;
			} catch (SQLException e1) {
				e1.printStackTrace();
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
		} else {
			System.err.println("올바른 부서번호를 입력하세요");
		}

		return isSuccess;

	}

	public boolean update(EmpDto e) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		if (EmpDao.isCorrect(e)) {
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("UPDATE emp ");
				sql.append("SET ename = ? , job = ? , mgr = ? , hiredate = NOW() , sal = ? , comm = ?, deptno = ? ");
				sql.append("WHERE empno =? ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(index++, e.geteName());
				pstmt.setString(index++, e.getJob());
				pstmt.setInt(index++, e.getMgr());
				pstmt.setDouble(index++, e.getSal());
				pstmt.setDouble(index++, e.getComm());
				pstmt.setInt(index++, e.getDeptNo());
				pstmt.setInt(index++, e.getEmpNo());

				pstmt.executeUpdate();
				isSuccess = true;
			} catch (SQLException e1) {
				e1.printStackTrace();
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

		} else {
			System.err.println("올바른 부서번호를 입력하세요");
		}

		return isSuccess;
	}

	public ArrayList<EmpDto> select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT empno , ename , job, mgr,date_format(hiredate,'%Y-%m-%d') , sal , comm,deptno ");
			sql.append("FROM emp ");
			sql.append("ORDER BY empno desc ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int index = 1;
				int empno = rs.getInt(index++);
				String ename = rs.getString(index++);
				String job = rs.getString(index++);
				int mgr = rs.getInt(index++);
				String date = rs.getString(index++);
				double sal = rs.getDouble(index++);
				double comm = rs.getDouble(index++);
				int deptno = rs.getInt(index++);

				list.add(new EmpDto(empno, ename, job, mgr, date, sal, comm, deptno));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	public boolean delete(int n) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM emp ");
			sql.append("WHERE empno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, n);

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
}
