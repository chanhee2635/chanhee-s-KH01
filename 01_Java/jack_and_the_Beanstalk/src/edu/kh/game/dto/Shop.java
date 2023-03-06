package edu.kh.game.dto;

public class Shop {
	private int bronze = 100; // 동도끼
	private int silver = 200; // 은도끼
	private int gold = 300; // 금도끼
	
	private int fertiliser = 50; // 비료
	private int potion = 100; // 물약
	private int bugKiller = 200; // 해충제
	private int scissors = 10; // 가위
	
	public int getBronze() {
		return bronze;
	}

	public int getSilver() {
		return silver;
	}

	public int getGold() {
		return gold;
	}

	public int getFertiliser() {
		return fertiliser;
	}

	public int getPotion() {
		return potion;
	}

	public int getBugKiller() {
		return bugKiller;
	}

	public int getScissors() {
		return scissors;
	}

}