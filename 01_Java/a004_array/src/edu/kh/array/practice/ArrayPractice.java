package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if(i%2==0) {
				sum += i+1;
			}
		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2() {
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = arr.length-i;
			System.out.print(arr[i]+" ");
			if(i%2!=0) {
				sum += arr[i];
			}
		}
		System.out.print("\n홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i=0;i<input;i++) {
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			arr[i] = input;
		}
		System.out.print("검색할 값 : ");
		int find = sc.nextInt();
		int index = 0;
		boolean flag = true;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==find) {
				index = i;
				flag = false;
			}
		}
		if(flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}else {
			System.out.println("인덱스 : " + index);
		}
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		char[] arr = new char[input.length()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = input.charAt(i);
		}
		System.out.print("문자 : ");
		String ch = sc.next();
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(ch==arr[i]) {
				
			}
		}
	}
	
	public void practice6() {
		
	}
	
	public void practice7() {
		
	}
	
	public void practice8() {
		
	}
	
	public void practice9() {
		
	}
	
	public void practice10() {
		
	}
	
	public void practice11() {
		
	}
	
	public void practice12() {
		
	}
	
	public void practice13() {
		
	}
	
	public void practice14() {
		
	}
	
	public void practice15() {
		
	}
	
	public void practice16() {
		
	}
	
	public void practice17() {
		
	}
	
	public void practice18() {
		
	}
	
	public void practice19() {
		
	}
	
	public void practice20() {
		
	}
	
	public void practice21() {
		
	}
	
	public void practice22() {
		
	}
	
	public void practice23() {
		
	}
	
	public void practice24() {
		
	}
	
	public void BingoGame() {
		
	}
	
	
}
