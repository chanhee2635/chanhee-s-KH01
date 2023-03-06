package edu.kh.game.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.game.dto.Tree;
import edu.kh.game.service.GameService;

public class GameView {

	private Scanner sc = new Scanner(System.in);	
	
	GameService service = new GameService();
	Tree tree = new Tree();
	int day = 0;
	
	public void displayMenu() {
		int input = 0;
		
		do {
			System.out.println("[♣♣♣콩나무 키우기♣♣♣]");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 행동화면");
			System.out.println("4. 전투게임");
			System.out.println("5. 상점");
			System.out.println("6. 정보확인");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 : ");
			try {
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거
				
				switch(input) {
				case 1 : signUp(); break;
				case 2 : login(); break;
				case 3 : behavior(); break;
				case 4 : fight(); break;
				case 5 : shop(); break;
				case 6 : inforamtion(); break;
				case 0 : System.out.println("게임을 종료합니다."); break;
				default: System.out.println("메뉴에 존재하는 번호만 입력 해주세요.");
				}
				
			} catch(InputMismatchException e) {
				// Scanner 입력이 잘못된 경우
				System.out.println("잘못된 형식을 입력 하셨습니다. 다시 시도해주세요.");
				
				sc.nextLine();  // 입력 버퍼에 남아있는 
								// 잘못 입력된 문자열을 읽어와 없앰
				
				input = -1;  // input값에 0이 아닌 값을 대입하여
							 // while이 종료되지 않게함
			}
		} while(input!=0);
		
	}
	
	private void signUp() {
		System.out.println("--- 회원 가입 ---");
		
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("Pw : ");
		String userPw = sc.next();
		
		System.out.print("Pw 확인 : ");
		String userPwConfirm = sc.next();
		
		System.out.print("나무 이름 : ");
		String userName = sc.next();
		
		
		Tree signUpUser = service.signUp(userId, userPw, userPwConfirm, userName);
		
		if(signUpUser != null) {
			
			System.out.println("회원 가입 완료");
		} else {
			
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		
	}
	private void login() {
		
	}
	
	private void behavior() {
		int input = 0;
		
		do {
			System.out.println("[행동 입력]");
			System.out.println("1. 물주기");
			System.out.println("2. 가지치기");
			System.out.println("3. 아이템사용하기");
			System.out.println("0. 종료");

			
			System.out.print("메뉴 선택 : ");
			try {
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거
				
				switch(input) {
				case 1 : water(); break;
//				case 2 : branchcut(); break;
//				case 3 : useItem(); break;
				case 0 : break;
				default: System.out.println("메뉴에 존재하는 번호만 입력 해주세요.");
				}
				
			} catch(InputMismatchException e) {
				// Scanner 입력이 잘못된 경우
				System.out.println("잘못된 형식을 입력 하셨습니다. 다시 시도해주세요.");
				
				sc.nextLine();  // 입력 버퍼에 남아있는 
								// 잘못 입력된 문자열을 읽어와 없앰
				
				input = -1;  // input값에 0이 아닌 값을 대입하여
							 // while이 종료되지 않게함
			}
		} while(input!=0);
	}

	
	
	
	
	private void fight() {
		int input = 0;
		
		do {
			System.out.println("[행동 입력]");
			System.out.println("1. 물주기");
			System.out.println("2. 가지치기");
			System.out.println("3. 아이템사용하기");
			System.out.println("0. 종료");

			
			System.out.print("메뉴 선택 : ");
			try {
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거
				
				switch(input) {
				case 1 : water(); break;
//				case 2 : branchcut(); break;
//				case 3 : useItem(); break;
				case 0 : break;
				default: System.out.println("메뉴에 존재하는 번호만 입력 해주세요.");
				}
				
			} catch(InputMismatchException e) {
				// Scanner 입력이 잘못된 경우
				System.out.println("잘못된 형식을 입력 하셨습니다. 다시 시도해주세요.");
				
				sc.nextLine();  // 입력 버퍼에 남아있는 
								// 잘못 입력된 문자열을 읽어와 없앰
				
				input = -1;  // input값에 0이 아닌 값을 대입하여
							 // while이 종료되지 않게함
			}
		} while(input!=0);
	}
	
	private void shop() {
		
	}
	
	private void inforamtion() {
		
	}



	
	private void water() {
		tree.setTreeLength((int)((tree.getTreeLength()+5)*tree.getGrowthRate()))  ;
	}
	
//	private void branchcut() {
//		if(sissor) { System.out.println("가위가 없습니다.");
//			
//		} else tree.setGrowthRate(tree.getGrowthRate()+0.05);
//	}
	
//	private void useItem() {
//		int input = 0;
//		
//		do {
//			for(String s : itemList) {
//				System.out.println(s +"");
//			}
//
//			System.out.print("메뉴 선택 : ");
//			try {
//				input = sc.nextInt();
//				sc.nextLine(); // 버퍼에 남은 개행문자 제거
//				
//				switch(input) {
//				case 1 : fertilizer(); break;
//				case 2 : potion(); break;
//				case 3 : bugKiller(); break;
//				case 0 : break;
//				default: System.out.println("메뉴에 존재하는 번호만 입력 해주세요.");
//				}
//				
//			} catch(InputMismatchException e) {
//				// Scanner 입력이 잘못된 경우
//				System.out.println("잘못된 형식을 입력 하셨습니다. 다시 시도해주세요.");
//				
//				sc.nextLine();  // 입력 버퍼에 남아있는 
//								// 잘못 입력된 문자열을 읽어와 없앰
//				
//				input = -1;  // input값에 0이 아닌 값을 대입하여
//							 // while이 종료되지 않게함
//			}
//		} while(input!=0);
//	}
//	
//	private void bugKiller() {
//		tree.setTreeLength(tree.getTreeLength()+200);
//	}
//
//	private void potion() {
//		tree.setTreeLength(tree.getTreeLength()+100);
//	}
//
//	private void fertilizer() {
//		tree.setTreeLength(tree.getTreeLength()+50);
//	}
}
