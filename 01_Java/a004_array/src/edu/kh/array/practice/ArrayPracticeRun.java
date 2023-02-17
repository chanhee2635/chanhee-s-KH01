package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPracticeRun {
	public static void main(String[] args) {
		ArrayPractice ap = new ArrayPractice();
		Scanner sc = new Scanner(System.in);
		System.out.print("실행 예제 : ");
		int input = sc.nextInt();
		switch(input) {
		case 1:	ap.practice1(); break;
		case 2:	ap.practice2(); break;
		case 3:	ap.practice3(); break;
		case 4:	ap.practice4(); break;
		case 5:	ap.practice5(); break;
		case 6:	ap.practice6(); break;
		case 7:	ap.practice7(); break;
		case 8:	ap.practice8(); break;
		case 9:	ap.practice9(); break;
		case 10:ap.practice10(); break;
		case 11:ap.practice11(); break;
		case 12:ap.practice12(); break;
		case 13:ap.practice13(); break;
		case 14:ap.practice14(); break;
		case 15:ap.practice15(); break;
		case 16:ap.practice16(); break;
		case 17:ap.practice17(); break;
		case 18:ap.practice18(); break;
		case 19:ap.practice19(); break;
		case 20:ap.practice20(); break;
		case 21:ap.practice21(); break;
		case 22:ap.practice22(); break;
		case 23:ap.practice23(); break;
		case 24:ap.practice24(); break;
		case 0:ap.BingoGame();; break;
		default: System.out.println("잘못 입력");
		
		}
	}
}
