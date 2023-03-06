package edu.kh.polymorphism.ex2.dto;

public class Fish extends Animal {

	private int fin;  // 지느러미 개수
	
	public Fish() {}
	
	// alt + shift + s -> o
	public Fish(String type, String eatType, int fin) {
		super(type, eatType);
		this.fin = fin;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + fin;
	}
	
	@Override
	public void breath() {
		System.out.println("아가미 호흡을 합니다.");
	}
}
