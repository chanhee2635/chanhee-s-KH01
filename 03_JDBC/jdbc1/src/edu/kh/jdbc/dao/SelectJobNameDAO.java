package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {

	
	public List<Employee2> select(String input) {  // SQL 검색 내용을 List에 한 객체(Employee2)씩 담아 반환하겠다는 select메서드 
	
		List<Employee2> empList = new ArrayList<>();  // 한줄(한객체)씩 넣을 컬렉션 배열 생성
		
		Connection conn = null;  // 통로
		Statement stmt = null;  // 통로를 통해 값을 보내고 가져올 애
		ResultSet rs = null;  // 가져온 값을 담아둘 애
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // 이 클래스를 사용해서 가져오겠다
			
			String type   = "jdbc:oracle:thin:@";
			String ip     = "localhost";
			String port   = ":1521";
			String dbName = ":XE";
			String user   = "kh_kch";
			String pw     = "oracle_kch123A"; 
			
			conn = DriverManager.getConnection(type+ip+port+dbName,user,pw);  // 위 정보로 통로를 만들겠다
			
			String sql = "SELECT NVL(DEPT_TITLE, '부서없음'), JOB_NAME, EMP_NAME, EMAIL FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) JOIN JOB USING(JOB_CODE) WHERE JOB_NAME = '" + input + "' ORDER BY EMP_NAME";
			
			stmt = conn.createStatement();  // 통로에 Statement를 만들어서 sql 을 보내고 가져올 stmt 생성
			
			rs = stmt.executeQuery(sql);  // sql을 stmt에 넣어서 나온 결과를 rs 에 담기 (테이블같은 구조로 되어있음)
			
			while(rs.next()) { // rs(테이블)에 한줄씩 봐서 있으면 true 없으면 false
				
				String deptTitle = rs.getString(1);  // 한줄에 첫번째 있는 정보를 변수에 담는다.
				String jobName = rs.getString(2);  // 한줄에 두번째 있는 정보를 담는다.
				String empName = rs.getString(3);  // 한줄에 세번째 있는 정보를 담는다.
				String email = rs.getString(4);  // 한줄에 네번째 있는 객체를 담는다.
				
				Employee2 emp = new Employee2(deptTitle, jobName, empName, email);	// 위 변수들로 Employee2 객체 생성 
				
				empList.add(emp); // 객체를 컬렉션 배열에 담기
			}
			
		} catch (ClassNotFoundException e) {  // 예외처리
			e.printStackTrace();
		} catch (SQLException e) {  // 예외처리
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();  // 메모리 닫기
				if(stmt!=null) stmt.close();  // 메모리 닫기
				if(conn!=null) conn.close();  // 메모리 닫기
			} catch (SQLException e) { // 예외처리
				e.printStackTrace();
			}
		}
		return empList;  // 컬렉션 List 반환
						 // -> 다시 JDBCExample4 로 가보자~~
		
	}
}
