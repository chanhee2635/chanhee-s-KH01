package edu.kh.control.loop.ex;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x=t;x>=1;x--) {
			System.out.print(" ") * 4;
			System.out.print("*") * 1;
		}
	}
}
