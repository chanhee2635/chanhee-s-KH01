package edu.kh.control.loop.practice;

import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i=1;i<=input;i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i=input;i>=1;i--) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;
		for(int i=1;i<input;i++) {
			sum += i;
			System.out.print(i + " + ");
		}
		System.out.print(input + " = " + (sum+input));
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		if(num1<1||num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else if(num1<num2) {
			for(int i=num1;i<=num2;i++) {
				System.out.print(i + " ");
			}
		} else {
			for(int i=num2;i<=num1;i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		System.out.printf("===== %d단 =====\n", dan);
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		if(input<2||input>9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		} else {
			for(int x=input;x<=9;x++) {
				System.out.printf("===== %d단 =====\n", x);
				for(int i=1;i<=9;i++) {
					System.out.printf("%d * %d = %d\n",x,i,x*i);
				}
				System.out.println();
			}
		}
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int x=1;x<=input;x++) {
			for(int i=1;i<=x;i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int x=input;x>=1;x--) {
			for(int i=x;i>=1;i--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1;i<=input;i++) {
			for(int j=input;j>=1;j--) {
				if(j>i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int x=1;x<=input;x++) {
			for(int i=1;i<=x;i++) {
				System.out.print("*");
			}
			System.out.println();
			if(x==input) {
				for(int i=input-1;i>=1;i--) {
					for(int j=i;j>=1;j--) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
	}
	
	public void practice10else() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1;i<=input*2-1;i++){
			if(i<=input){
				for(int j=1;j<=input;j++){
					if(j<=i) System.out.print("*");
				}
				System.out.println();
  			} else {
  				for(int j=input*2-i;j>=1;j--){
  					if(j>=1) System.out.print("*");
  				}
  				System.out.println();
  			}
		}
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		int x = input-1;
		int y = 1;
		for(int i=1;i<=input;i++) {
			for(int j=x;j>=0;j--) {
				System.out.print(" ");
			}
			for(int j=y;j>=1;j--) {
				System.out.print("*");
			}
			for(int j=x;j>=0;j--) {
				System.out.print(" ");
			}
			System.out.println();
			y+=2;
			x--;
		}
	}
	
	public void practice11else() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=0;i<input;i++) {
			for(int j=input*2-1;j>=1;j--) {
				if(Math.abs(j-input)>i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1;i<=input;i++) {
			if(i==1||i==input) {
				for(int j=1;j<=input;j++) {
					System.out.print("*");
				} 
				System.out.println();
			} else {
				System.out.print("*");
				for(int j=1;j<=input-2;j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				System.out.println();
			}
		}
	}
	
	public void practice12else() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1;i<=input;i++) {
			System.out.print("*");
			for(int j=1;j<=input-2;j++) {
				if(i==1||i==input) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("*");
			System.out.println();
			
		}
	}
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int count = 0;
		for(int i=1;i<=input;i++) {
			if(i%2==0||i%3==0) {
				System.out.print(i + " ");
			}
			if(i%2==0&&i%3==0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}
}
