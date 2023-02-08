package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int koreanScore = sc.nextInt();
		System.out.print("영어 : ");
		int englishScore = sc.nextInt();
		System.out.print("수학 : ");
		int mathScore = sc.nextInt();
		
		int sum = koreanScore + englishScore + mathScore;
		double avg = (double)sum / 3;
		String result = koreanScore >= 40 && englishScore >= 40 && mathScore >= 40 && avg >= 60 ? "합격" : "불합격";
		
		System.out.println("\n합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(result);
	
	}
}
