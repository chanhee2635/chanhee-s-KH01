package edu.kh.control.branch.ex;

import java.util.Scanner;

public class BranchEx {
	
	// 분기문 
	// break	: 가장 가까운 반복문을 멈춤(빠져나감)
	// continue	: 가장 가까운 반복문 시작 부분으로 이동(다음 반복으로 이동)
	
	// break 예시 1
	public void ex1() {
		for(int i=1;i<=10000;i++) {
			System.out.println(i);
			if(i==20) {  // i가 20인 경우
				break;  // 반복문 멈춤
			}
		}
	}
	// break 예시 2
	public void ex2() {
		// 0 입력 시 까지 입력된 정수 합 구하기
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;  // 합계 저장용 변수
		int input = 0;  // 입력 값 저장용 변수
		
		while(true) {  // 무조건 조건식 true == 무한 루프
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input;
			if(input==0) {  // 입력 받은 값이 0인 경우
				break; // while문 종료
			}
		}
		System.out.println("합계 : "+sum);
		// Unreachable code : 도달할 수 없는 코드
	}
	
	// break 예시 3
	public void ex3() {
		for(int row=1;row<=5;row++) {
			for(int col=1;col<=5;col++) {
				if(col==3) {
					break;  // 안쪽 for문 멈춤
					// -> 2열 까지만 출력
				}
				System.out.printf("(%d, %d) ",row,col);
			}
			System.out.println();
			if(row==4) {
				break;  // 바깥쪽 for문 멈춤
				// -> 4행 까지만 출력
			}
		}
	}
	
	// continue 예시 1
	public void ex4() {
		// 1 2 3 4 5 6 7 8 9 10
		for(int i=1;i<=10;i++) {
			if(i%2==0) {  // 짝수 일 경우
				continue;
			}
			
			System.out.print(i + " ");
		}
	}
	
	public void ex5() {
		// 1~ 100까지 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수는 출력을 건너뛰고
		// 증가하는 값이 40이 되었을 때 반복을 멈춰라
		for(int i=1;i<=100;i++) {
//			if(i==40){
//				break;
//			}
			if(i%5==0) { // 5의 배수
				if(i==40) {
					break;
				}else {
					continue;
				}
			}
			System.out.print(i+" ");
		}
	}
	
	// 분기문 응용 1
	public void upDownGame() {
		
		// 1~50 사이의 난수를 하나 지정하여
		// 사용자가 몇 회 만에 맞추는지 카운트하는 게임
		// 난수 : Math.random
		// count, while, break
		
		// ex) 난수가 30인 경우
		
		// 1번 입력 : 10
		// UP
		
		// 2번 입력 : 40 
		// DOWN
		
		// 3번 입력 : 30
		// 정답 입니다!(총 입력 횟수 : 3회)
		Scanner sc = new Scanner(System.in);
		
		int x = (int)(Math.random()*50+1);
		int count = 1;  // 반복 횟수 저장용 변수
		while(true) {  // 무한 반복
			System.out.printf("%d번 입력 : ", count);
			int input = sc.nextInt(); 
			if(x>input) {  // 입력값이 작은 경우
				System.out.println("UP");
			}else if(x<input) {  // 입력값이 큰 경우
				System.out.println("DOWN");
			}else {  // 입력 값 == 난수 (정답)
				System.out.printf("정답 입니다!(총 입력 횟수 : %d회)", count);
				break;
			}
			count++;  // 카운트 증가
		}
	}
	
	// 분기문 응용 2
	public void ex6() {
		// 시작 번호 부터 끝 번호까지 1씩 증가하며 출력하는 반복문
		// 특정 수의 배수를 입력 받아 출력모양 변경 
		
		// 시작 : 5
		// 종료 : 13
		// 제외할 배수 : 6
		
		// 5 [6] 7 8 9 10 11 [12] 13 14
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 : ");
		int st = sc.nextInt();
		System.out.print("종료 : ");
		int ed = sc.nextInt();
		System.out.print("변경할 배수 : ");
		int input = sc.nextInt();
//		while(true) {
//			if(st==ed) {
//				System.out.print(st + " ");
//				break;
//			} else if(st%input==0) {
//				System.out.printf("[%d] ", st);
//			} else {
//				System.out.print(st + " ");
//			}
//			st++;
//		}
		for(int i=st;i<=ed;i++) {
			if(i%input==0) {
				System.out.printf("[%d] ", i);
			} else {
				System.out.print(i + " ");
			}
		}
	}
}
