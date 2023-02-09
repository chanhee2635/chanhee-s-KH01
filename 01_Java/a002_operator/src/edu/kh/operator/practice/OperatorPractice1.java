package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int peopleCount = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candyCount = sc.nextInt();
		
		System.out.println("\n1인당 사탕 개수 : " + candyCount / peopleCount);
		System.out.println("남는 사탕 개수 : " + candyCount % peopleCount);
		
	}
}
