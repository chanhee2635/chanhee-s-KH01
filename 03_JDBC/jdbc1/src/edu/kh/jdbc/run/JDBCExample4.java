package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  // 입력하기 위한 Scanner 객체(sc) 생성
		
		System.out.print("직급명 입력 : ");
		String input = sc.nextLine();  // 직급명 String 자료형으로 받기 
		
		// DAO 생성 후 메서드 호출
		SelectJobNameDAO dao = new SelectJobNameDAO();  // 내가 입력한 값으로 데이터베이스에 접근하기 위한 DAO 객체 생성 (따로 구현)
		                                                // -> SelectJobNameDAO 로 가보자~~
		List<Employee2> list = dao.select(input);  // select 함수로 가져온 Employee2 객체가 담긴 List 배열을 list 변수에 대입
		
		if(list.isEmpty()) {  // list 가 빈값이면
			System.out.println("입력된 직급명과 일치하는 사원이 없습니다.");
			return;
		}
		
		for(Employee2 emp : list) {  // 객체 하나씩 꺼내와서 출력
			System.out.printf("%s / %s / %s / %s \n",emp.getDeptTitle(),emp.getJobName(), emp.getEmpName(), emp.getEmail());
		}
	}
}
