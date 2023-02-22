package edu.kh.objectarray.service;

import java.util.Arrays;
import java.util.Random;

import edu.kh.objectarray.dto.Student;

// 기능 제공용 클래스(비즈니스 로직 처리)
public class StudentService {

	// ctrl + shift + o : import 자동 추가
	
	// Student 객체 참조변수 5개짜리 배열을 생성해서 studentArr 참조
	private Student[] studentArr = new Student[5];
	
	// StudentService 기본 생성자
	public StudentService() {
		
		// studentArr 배열의 각 요소는 Student 참조 변수
		studentArr[0] = new Student(3, 5, 17, "홍길동");
		studentArr[1] = new Student(2, 3, 11, "김철수");
		studentArr[2] = new Student(1, 7, 3, "최미영");
		
	    // 학생 랜덤 점수 추가
	    Random random = new Random();
	    for(Student s : studentArr) {
	         
		    if(s == null) break;
		         
		    // (int)(Math.random() * 101) == random.nextInt(101);
		    s.setKor(random.nextInt(101));
		    s.setEng(random.nextInt(101));
		    s.setMath(random.nextInt(101));
	    }
	      
		
	}
	
	// param(parameter) : 매개변수
	
	/** 1. 학생 추가 서비스 
	 * @param grade : int
	 * @param classRoom : int
	 * @param number : int
	 * @param name : String
	 * 
	 * @return result : boolean (학생 추가 성공 시 true)
	 * */
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		// studentArr에서 비어있는 인덱스를 찾아
		// 해당 인덱스에 매개변수를 이용해서 생성된 Student 객체 주소를 대입
		// → true 반환
		for(int i=0;i<studentArr.length;i++) {
			
			//배열 요소가 참조하는 주소가 없을 경우 = 비어있다고 판단
			if(studentArr[i] == null) {
				// 비어있는 배열 요소에
				// 매개변수를 이용해서 새 학생 객체를 만들어 주소 대입
				studentArr[i] = new Student(grade, classRoom, number, name);
				return true;
			}
		}
		// 만약 비어있는 인덱스가 없을 경우
		// → false 반환
		return false;
	}
	
	/** 2. 학생 전체 조회 서비스
	 * @return StudentArr : Student[]
	 * */
	public Student[] selectAll() {
		// studentArr를 반환
		return studentArr;
	}
	
	/**3. 학생 정보 조회(인덱스) 
	 * @param index : int
	 * 
	 * @return studentArr[index] : Student 참조변수
	 * */
	public Student selectIndex(int index) {
		// index 값이 0~4 사이가 아니면
		// 배열 범위를 초과 했다는 ArrayIndexOutOfBoundsException 발생
		
		// 해결 방법 : 배열 범위가 넘어선 경우에 대한 별도 처리
		
		//if(index<0||index>=studentArr.length)
		if(!(index>=0 && index<=4)) {
			return null;
		}
		return studentArr[index];
	}
	
	/** 4. 학생 정보 조회(이름) 서비스
	 * @param inputName : String
	 * 
	 * @return resultArr : Student[] (조회된 학생이 없을 경우 null)
	 * */
	public Student[] selectName(String inputName) {

		// 이름이 일치하는 학생 모두를 저장할 객체배열 선언 및 초기화
		Student[] resultArr = new Student[studentArr.length];
		
		int index = 0;  // resultArr에 값을 대입할 인덱스를 나타내는 변수
		
		// studentArr에서 이름이 일치하는 학생 찾기
		for(int i=0;i<studentArr.length;i++) {
			
			// studentArr[i]가 null인지 검사
			if(studentArr[i] == null) {
				break;  // NullPointerException 방지를 위해 반복 종료
			}
			
			// i번째 요소의 name과 입력 받은 inputName이 같을 경우
			if(studentArr[i].getName().equals(inputName)) {
				
				// resultArr에 studentArr[i]의 값(주소)를 대입 (얕은 복사)
				resultArr[index++] = studentArr[i];
				// → studentArr[i] 값 대입 후 index 값 증가(후위 연산)
			}
		}
		if(index == 0) {
			return null;  // null 반환
		}
		
		return resultArr;
	}
	
	/** 5. 학생 정보 수정(인덱스) 서비스
	 * @param index : int
	 * @param kor : int
	 * @param eng : int
	 * @param math : int
	 * 
	 * @return 수정 성공 시 true / 실패 시 false
	 * */
	public boolean updateStudent(int index, int kor, int eng, int math) {
		if(index<0||index>4||studentArr[index] == null) return false;
		// 문제가 없을 경우 index번째 학생의 점수를 수정 후 true 반환
		studentArr[index].setKor(kor);
		studentArr[index].setEng(eng);
		studentArr[index].setMath(math);
		return true;
	}
	
	/** 6. 학생 총점 합계, 평균, 최고점, 최저점
	 * @return arr : int[] (인덱스 순서대로 합계, 평균, 최고점, 최저점 
	 * */
	
	public int[] sumAvgMaxMin() {
		int[] arr = new int[4];
		int index = 0;
		while(studentArr[index] != null) {
			index++;
		}
		int[] score = new int[index];
		for(int i=0;i<score.length;i++) {
			if(studentArr[i]==null) {
				break;
			}
			score[i] = studentArr[i].getKor() + studentArr[i].getEng() + studentArr[i].getmath();
			arr[0] += score[i];
		}
		arr[1] = arr[0]/score.length;
		arr[2] = score[0];
		arr[3] = score[0];
		for(int i=0;i<score.length;i++) {
			if(score[i]>arr[2]) {
				arr[2] = score[i];
			}
			if(score[i]<arr[3]) {
				arr[3] = score[i];
			}
		}
		System.out.println(Arrays.toString(score));
		return arr;
	}
}
