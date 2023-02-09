package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeRun {

	public static void main(String[] args) {
		ConditionPractice cp = new ConditionPractice();
		Scanner sc = new Scanner(System.in);
		System.out.print("실행할 문제의 번호 입력 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1: cp.practice1();
		case 2: cp.practice2();
		case 3: cp.practice3();
		case 4: cp.practice4();
		case 5: cp.practice5();
		}
		
	}
}
