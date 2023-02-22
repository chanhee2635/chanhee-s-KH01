package edu.kh.inheritance.dto;

public class Parent /*extends Object*/{
				 	// 컴파일러가 자동 추가
	
	private int money = 400_000_000;
	private String lastName = "박";  // 성
	
	// 기본 생성자
	public Parent() {
		System.out.println("Parent() 기본 생성자");
	}
	 
	// 매개변수 생성자
	public Parent(int money, String lastName) {
		this.money = money;
		this.lastName = lastName;
		
		System.out.println("Parent(int, String) 매개변수 생성자");
	}
	
	// getter / setter
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return money + " / " + lastName;
	}
}
