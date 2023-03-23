package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/** 재직 중인 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> currentEmp(Connection conn) throws SQLException{
		// 결과 저장용 객체
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'없음') DEPT_TITLE, JOB_NAME, SALARY, NVL(PHONE,'없음') PHONE, EMAIL FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) WHERE ENT_YN = 'N' ORDER BY JOB_CODE";
			
			// Statement 객체 이용
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				Emp emp = new Emp();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(deptTitle);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				
				empList.add(emp);
			}
		
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}
	/**
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> retireEmp(Connection conn) throws SQLException{
		List<Emp> empList = new ArrayList<>();
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(PHONE,'없음') PHONE, EMAIL, TO_CHAR(ENT_DATE, 'YYYY\"년\"MM\"월\"DD\"일\"') ENT_DATE "
					+ "FROM EMPLOYEE "
					+ "WHERE ENT_YN = 'Y' "
					+ "ORDER BY ENT_DATE";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				
				Emp emp = new Emp();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setEntDate(entDate);
				
				empList.add(emp);
				
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}
	public Emp selectEmpId(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, SALARY, NVL(PHONE, '없음') PHONE, EMAIL, HIRE_DATE, ENT_YN FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) WHERE EMP_ID = "+ input;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()) {
				emp = new Emp();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setDepartmentTitle(rs.getString(3));
				emp.setJobName(rs.getString(4));
				emp.setSalary(rs.getInt(5));
				emp.setPhone(rs.getString(6));
				emp.setEmail(rs.getString(7));
				emp.setHireDate(rs.getDate(8));
				emp.setEntYN(rs.getString(9));
				
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return emp;
	}
	public int insertEmp(Connection conn, Emp emp) throws SQLException{
		int result = 0;
		try {
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int updateEmp(Connection conn, Emp emp) throws SQLException{
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		try {
			// 2. SQL 구문 작성
			// PreparedStatement / Statement 생성
			String sql = "UPDATE EMPLOYEE SET EMAIL = ?, PHONE = ?, SALARY = ?, BONUS = ? WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			// 3. 수행 후 결과 반환 받아 결과 저장용 변수에 저장
			// SELECT문   : executeQuery([SQL])
			// DML문      : executeUpdate([SQL])
			// [SQL] 작성하는 경우 : Statement 객체 사용 할 때
			
			result = pstmt.executeUpdate();
		} finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		// 5. 결과 반환
		return result;
	}
	public int deleteEmp(Connection conn, int input) throws SQLException{
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			// 2. SQL 구문 작성
			// PreparedStatement / Statement 생성
			String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			// 3. 수행 후 결과 반환 받아 결과 저장용 변수에 저장
			// SELECT문   : executeQuery([SQL])
			// DML문      : executeUpdate([SQL])
			// [SQL] 작성하는 경우 : Statement 객체 사용 할 때
			
			result = pstmt.executeUpdate();
			
		} finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		// 5. 결과 반환
		return result;
	}
	public void retireEmpId(Connection conn, int input) throws SQLException {
		try {
			String sql = "UPDATE EMPLOYEE SET ENT_DATE = SYSDATE, ENT_YN = 'Y' WHERE EMP_ID = ? AND ENT_YN = 'N'";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);	
			pstmt.executeQuery();
		} finally {
			close(pstmt);
		}
	}
	public List<Emp> lateEmp(Connection conn) throws SQLException{
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM(SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '부서없음) DEPT_TITLE, HIRE_DATE FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) ORDER BY HIRE_DATE DESC) WHERE ROWNUM <= 5";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				Date hireDate = rs.getDate(4);
				
				Emp emp = new Emp();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(deptTitle);
				emp.setHireDate(hireDate);
				
				empList.add(emp);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return empList;
	}
	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException{
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		try {
			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균 FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) GROUP BY DEPT_CODE, DEPT_TITLE ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				mapList.add(map);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return mapList;
	}
	/** 존재하는 사원인지, 퇴직한 사원인지 조회하는 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException{
		int check = 0;
		
		try {
			String sql = "SELECT\r\n"
					+ "	CASE\r\n"
					+ "		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ? ) = 0 THEN 0\r\n"
					+ "		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1 THEN 1\r\n"
					+ "		ELSE 2\r\n"
					+ "	END \"CHECK\"\r\n"
					+ "FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}
}









































