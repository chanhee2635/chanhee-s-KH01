package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/** 재직중인 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> currentEmp() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.currentEmp(conn);
		
		close(conn);
		
		return empList;
	}

	/** 퇴사한 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> retireEmp() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.retireEmp(conn);
		
		close(conn);
		
		return empList;
	}

	/** 사번이 일치하는 사원 정보 반환 서비스
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectEmpId(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		Emp emp = dao.selectEmpId(conn, input);
		
		close(conn);
		
		return emp;
	}

	public int insertEmp(Emp emp) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.insertEmp(conn, emp);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 사번으로 사원 정보 수정 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Emp emp) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.updateEmp(conn, emp);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteEmp(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmp(conn, input);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	/** 퇴직 처리 서비스
	 * @param input
	 * @throws SQLException
	 */
	public void retireEmpId(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		dao.retireEmpId(conn, input);  // 성공 또는 예외
		
		//트랜잭션 처리
		// DB 예외 발생 시 SQL 수행이 정상적으로 진행되지 않음
		commit(conn);
		
		close(conn);
	}

	public List<Emp> lateEmp() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.lateEmp(conn);
		
		return empList;
	}

	/** 부서별 통계 조회 서비스
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		
		close(conn);
		
		return mapList;
	}

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check(0: 없는 사원, 1: 퇴직한 사원, 2: 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn, input);
		
		close(conn);
		
		return check;
	}


}
