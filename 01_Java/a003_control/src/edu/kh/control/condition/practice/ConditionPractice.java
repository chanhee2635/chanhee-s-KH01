package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		String result;
		if(num<=0) {
			result = "양수만 입력해주세요.";
		}else if(num%2==0) {
			result = "짝수입니다.";
		} else{
			result = "홀수입니다.";
		}
		System.out.println(result);
	}
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int koreanScore = sc.nextInt();
		System.out.print("수학점수 : ");
		int mathScore = sc.nextInt();
		System.out.print("영어점수 : ");
		int englishScore = sc.nextInt();
		
		int sum = koreanScore+mathScore+englishScore;
		double avg = (double)sum/3;
		if(koreanScore>=40 && mathScore>=40 && englishScore>=40 && avg>=60) {
			System.out.println("국어 : " + koreanScore);
			System.out.println("수학 : " + mathScore);
			System.out.println("영어 : " + englishScore);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
		
		
	}
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 2: case 4: case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		default: System.out.println(month + "월은 잘못 입력된 달입니다.");
		}
	}
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		String result;
		if(bmi<18.5) result = "저체중";
		else if(bmi<23) result = "정상체중";
		else if(bmi<25) result = "과체중";
		else if(bmi<30) result = "비만";
		else result = "고도 비만";
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
	}
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int mi = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int fi = sc.nextInt();
		System.out.print("과제 점수 : ");
		int su = sc.nextInt();
		System.out.print("출석 횟수 : ");
		int ch = sc.nextInt();
		
		double total = mi * 0.2 + fi * 0.3 + su * 0.3 + ch;
		if(total>=70 && ch>6) {
			System.out.println("================= 결과 =================");
			System.out.println("중간 고사 점수(20) : " + mi*0.2);
			System.out.println("기말 고사 점수(30) : " + fi*0.3);
			System.out.println("과제 점수       (20) : " + su*0.3);
			System.out.println("출석 점수       (20) : " + (double)ch);
			System.out.println("총점 : " + total);
			System.out.println("PASS");
		} else if(total>=70 && ch<=6) {
			System.out.println("================= 결과 =================");
			System.out.println("중간 고사 점수(20) : " + mi*0.2);
			System.out.println("기말 고사 점수(30) : " + fi*0.3);
			System.out.println("과제 점수(20) : " + su*0.3);
			System.out.println("출석 점수(20) : " + (double)ch);
			System.out.println("총점 : " + total);
			System.out.println("Fail [점수 미달]");
		} else {
			System.out.println("Fail [출석 횟수 부족 (ch/20)]");
		}
	}
}
