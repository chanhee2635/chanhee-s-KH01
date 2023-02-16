package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	static Scanner sc = new Scanner(System.in);

	public void practice1() {
		int[] arr = new int[9]; 				// 길이가 9인 1차원 배열 arr 선언
		int sum = 0;  							// arr 인덱스의 합을 저장할 변수 sum 생성 및 초기화 
		for(int i=0;i<arr.length;i++) {			// 1~9를 대입하는 반복문
			arr[i] = i+1;						// 배열의 인덱스에 1을 더한 값을 대입
			System.out.print(arr[i] + " ");		// 대입값 출력
			if(i%2==0) {						// 인덱스 값이 짝수이면
				sum += arr[i];					// sum에 arr[i]의 값을 대입연산자 사용
			}
		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);  // sum 값을 출력
	}
	
	public void practice2() {
		int[] arr = new int[9];					// 길이가 9인 1차원 배열 arr 선언
		int sum = 0;							// arr 인덱스의 합을 저장할 변수 sum 생성 및 초기화 
		for(int i=0;i<arr.length;i++) {			// 9~1을 대입하는 반복문
			arr[i] = arr.length-i;				// 배열의 길이에서 인덱스를 뺀 값을 대입
			System.out.print(arr[i]+" ");		// 대입값 출력
			if(i%2!=0) {						// 인덱스 값이 짝수가 아니면
				sum += arr[i];					// sum에 arr[i]의 값을 대입연산자 사용
			}
		}
		System.out.print("\n홀수 번째 인덱스 합 : " + sum);  // sum 값을 출력
	}
	
	public void practice3() {
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();				// 양의 정수 입력 = input
		int[] arr = new int[input];				// input 크기의 배열 arr에 할당
		for(int i=0;i<input;i++) {				// arr배열에 1~input 값 대입
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
		}
	}
	
	public void practice4() {
		int[] arr = new int[5];  					// 5 크기의 int 자료형 배열을 생성
		for(int i=0;i<arr.length;i++) { 			// 입력 값을 Scanner 클래스로 받기
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			arr[i] = input;							// 배열을 입력값으로 초기화
		}
		System.out.print("검색할 값 : ");
		int find = sc.nextInt();					// 검색할 값 입력받기
		int index = 0;
		boolean flag = true;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==find) {
				System.out.println("인덱스 : " +i);
				flag = false;
			}
		}
		if(flag) System.out.println("일치하는 값이 존재하지 않습니다.");
	}
	
	public void practice5() {
		System.out.print("문자열 : ");
		String input = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		char[] arr = new char[input.length()];
		int count = 0;
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) : ", input, ch);
		for(int i=0;i<arr.length;i++) {
			arr[i] = input.charAt(i);
			if(arr[i]==ch) {
				System.out.print(i + " ");
				count += 1;
			}
		}
		System.out.printf("\n%s 개수 : %d", ch, count);
	}
	
	public void practice6() {
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
				System.out.print(arr[i]+", ");
			}else {
				arr[i] = input-i;
				if(i==arr.length-1) {
					System.out.print(arr[i]);
				}else {
					System.out.print(arr[i]+", ");
				}
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
		System.out.print("배열의 크기를 입력하세요 : ");
		int len = sc.nextInt();  // 처음 배열 크기가 입력될 변수(계속 추가될 예정)
		sc.nextLine();  // next(). nextInt(), nextDouble() 는 사이띄기, tab키, enter키를 
		                // 구분문자로 분리해서 분리된 자료만 읽어간다. 사이띄기, tab키, enter키는 남겨짐
		                // nextLine() 는 한 줄 단위로 입력, 입력하고 Enter키를 누르면 Enter까지 읽어간다.
		String[] arr = new String[len];  // 값 입력받을 배열 
		String[] des = new String[len];  // arr을 깊은복사로 대입할 배열
		for(int i=0;i<len;i++) {
			System.out.printf("%d번째 문자열 : ", i+1);  // 문자열을 arr 배열에 반복문으로 입력
			arr[i]= sc.nextLine();
			if(i==len-1) {  // 반복문 끝에서
				System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
				String A = sc.nextLine();  // y, n 을 확인할 변수
				if(A.equals("y")) {
					des = new String[len];  // des 배열 선언
					System.arraycopy(arr, 0, des, 0, len);  // arr 배열을 des 배열로 깊은 복사
					System.out.print("더 입력하고 싶은 개수 : ");
					len += sc.nextInt();  // 더 입력할 길이를 기본 길이에 추가
					sc.nextLine();  // 다시 돌아갔을 때 nextLine을 위해 엔터값을 받아줌
					arr = new String[len];  // 추가한 길이만큼 arr 배열을 다시 선언
					System.arraycopy(des, 0, arr, 0, i+1);  // des에 담았던 값을 arr에 넣기
				}else {
					System.out.println(Arrays.toString(arr));
				}
			}
		}
		
	}	
	
	public void practice15() {
		String[][] arr = new String[3][3];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = "("+i+", "+j+")";
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice16() {
		int[][] arr = new int[4][4];
		int num = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = num++;
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice17() {
		int[][] arr = new int[4][4];
		int num = 16;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = num--;
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice18() {
		int[][] arr = new int[4][4];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i==3||j==3) {
					System.out.printf("%3d ", arr[i][j]);
				}else {
					arr[i][j] = (int)(Math.random()*10+1);
					arr[i][3] += arr[i][j];
					arr[3][j] += arr[i][j];
					arr[3][3] += arr[i][j];
					System.out.printf("%3d ", arr[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	public void practice19() {
		System.out.print("행 크기 : ");
		int row = sc.nextInt();
		while(row<1||row>10) {
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			System.out.print("행 크기 : ");
			row = sc.nextInt();
		}
		System.out.print("열 크기 : ");
		int col = sc.nextInt();
		while(col<1||col>10) {
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			System.out.print("열 크기 : ");
			col = sc.nextInt();
		}
		char[][] arr = new char[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j] = (char)(Math.random()*26+65);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice20() {
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		char[][] arr = new char[row][];
		char alphabet = 97;
		for(int i=0;i<row;i++) {
			System.out.print(i+"열의 크기 : ");
			int col = sc.nextInt();
			arr[i] = new char[col];
			for(int j=0;j<col;j++) {
				arr[i][j] = alphabet++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public void practice21() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		int studentsCount = 0;
		System.out.println("== 1분단 ==");
		for(int i =0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr1[i][j] = students[studentsCount++];
				System.out.print(arr1[i][j] + "  ");
				if(i==2&&j==1) {
					System.out.println();
					System.out.println("== 2분단 ==");
					for(int x =0;x<arr2.length;x++) {
						for(int y=0;y<arr2[x].length;y++) {
							arr2[x][y] = students[studentsCount++];
							System.out.print(arr2[x][y] + "  ");
						}
						System.out.println();
					}
				}
			}
			System.out.println();
		}
		
		
		
	}
	
	public void practice22() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];
		int studentsCount = 0;
		System.out.println("== 1분단 ==");
		for(int i =0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr1[i][j] = students[studentsCount++];
				System.out.print(arr1[i][j] + "  ");
				if(i==2&&j==1) {
					System.out.println();
					System.out.println("== 2분단 ==");
					for(int x =0;x<arr2.length;x++) {
						for(int y=0;y<arr2[x].length;y++) {
							arr2[x][y] = students[studentsCount++];
							System.out.print(arr2[x][y] + "  ");
						}
						if(x!=2) System.out.println();
					}
				}
			}
			System.out.println();
		}
		System.out.println("============================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String input = sc.next(); 
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				if(arr1[i][j].equals(input)) {
					String point = null;
					if(j==0) {
						point = "왼쪽";
					} else if(j==1) {
						point = "오른쪽";
					}
					System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 %s에 있습니다.", input, i+1,point);
				}
				if(arr2[i][j].equals(input)) {
					String point = null;
					if(j==0) {
						point = "왼쪽";
					} else if(j==1) {
						point = "오른쪽";
					}
					System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 %s에 있습니다.", input, i+1,point);
				}
			}
		}
	}
	
	public void practice23() {
		
	}
	
	public void practice24() {
		
	}
	
	public void BingoGame() {
		
	}
	
	
}
