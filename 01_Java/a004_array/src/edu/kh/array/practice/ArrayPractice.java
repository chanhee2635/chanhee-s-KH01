package edu.kh.array.practice;

import java.util.Arrays;
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
		System.out.print("문자 : ");
		String ch = sc.next();
		char[] arr = new char[input.length()];
		int sum = 0;
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) : ", input, ch);
		for(int i=0;i<arr.length;i++) {
			arr[i] = input.charAt(i);
			if(arr[i]==ch.charAt(0)) {
				System.out.print(i + " ");
				sum += 1;
			}
		}
		System.out.printf("\n%s 개수 : %d", ch, sum);
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int index = sc.nextInt();
		int[] arr = new int[index];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n총 합 : " + sum);
		
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		char[] arr = new char[input.length()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = input.charAt(i);
			if(i>7) {
				System.out.print("*");
			}else {
				System.out.print(arr[i]);
			}
		}
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		while(input<3||input%2==0) {
			System.out.println("다시 입력하세요.");
			System.out.print("정수 : ");
			input = sc.nextInt();
		}
		int[] arr = new int[input];
		for(int i=0;i<arr.length;i++) {
			if(i<=input/2) {
				arr[i] = i+1;
			}else {
				arr[i] = input-i;
			}
			if(i==arr.length-1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i]+", ");
			}
		}
	}
	
	public void practice9() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10);
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice10() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10);
			System.out.print(arr[i]+" ");
		}
		int max = arr[0];
		int min = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("\n최대값 : "+max);
		System.out.println("최소값 : "+min);
	}
	
	public void practice11() {
		int[] arr = new int[10];  // int 자료형 10개칸짜리 arr 배열 생성
		for(int i=0;i<arr.length;i++) {  // 0~9(arr배열의 크기)까지 i가 1씩 증가하는 반복문
			arr[i] = (int)(Math.random()*10+1);  // arr배열에 1~10의 랜덤값 넣기
			for(int j=0;j<i;j++) {  // 0~i-1까지 j가 1씩 증가하는 반복문
				if(arr[i]==arr[j]) {  // arr[i]==arr[j] 가 같으면
					i--;  // i를 1 감소시켜 반복문을 다시 실행하도록 함
				}
			}
		}
		for(int i=0;i<arr.length;i++) {  // 0~9까지 i가 1씩 증가하는 반복문
			System.out.print(arr[i] + " ");  // arr배열을 하나씩 출력
		}
	}
	
	public void practice12() {
		int[] lotto = new int[6];  // 6칸 짜리 lotto 배열 생성
		for(int i=0;i<lotto.length;i++) { // 난수 넣는 반복문
			lotto[i] = (int)(Math.random()*45+1);  // lotto 배열에 1~45의 난수 값 하나씩 대입
			for(int j=0;j<i;j++) {  // j가 0부터 i보다 크지 않을 때까지 j가 1씩 증가하는 반복문
				if(lotto[i]==lotto[j]) { // lotto 배열에 입력된 난수가 다음 생성된 난수와 같으면
					i--;  // i를 다시 감소하여 다시 반복
				}
			}
		}
		for(int i=0;i<lotto.length-1;i++) { // 비교 반복문 (마지막 값은 비교할 대상x -1)
			int x = 0;  // 값을 담을 변수 생성
			for(int j=1;j<lotto.length-i;j++) {  // 비교 반복문 (제일 뒤로 쌓이는 값은 더이상 비교x -i)
				if(lotto[j-1]>lotto[j]) {
					x = lotto[j-1];
					lotto[j-1] = lotto[j];
					lotto[j] = x;
				}
			}  // 다시 처음부터 반복 -> 한번 반복할 때마다 큰 값이 뒤로 쌓임
		}
		for(int i=0;i<lotto.length;i++) {  // 출력 반복문
			System.out.print(lotto[i] + " ");
		}
		
	}
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		char[] arr = new char[input.length()];
		for(int i=0;i<input.length();i++) {
			arr[i] = input.charAt(i);
		}
		int count = 0;
		System.out.print("문자열에 있는 문자 : ");
		for(int i=0;i<arr.length;i++) {
			boolean flag = true;
			for(int j=0;j<i;j++)
				if(arr[i]==arr[j]) {
					flag = false;
			}
			if(flag && i<arr.length-1) {
				System.out.print(arr[i] + ", ");
				count += 1;
			} else if(flag && i==arr.length-1) {
				System.out.print(arr[i]);
				count += 1;
			}
		}
		System.out.println("\n문자 개수 : " + count);
	}
	
	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int input = sc.nextInt();
		String[] arr = new String[input];
		sc.nextLine();
		while(true) {
			int df = 0;
			int plus = 0;
			for(int i = df;i<arr.length+plus;i++) {
				System.out.printf("%d번째 문자열 : ",i+1);
				String A = sc.nextLine();
				arr[i] = A;
			}
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			String yn = sc.next();
			if(yn=="yes") {
				System.out.print("더 입력하고 싶은 개수 : ");
				plus = sc.nextInt();
				df = arr.length;
				System.arraycopy(arr, 0, arr, 0, arr.length+plus);
			}else {
				System.out.println(Arrays.toString(arr));
				break;
			}
		}	
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
