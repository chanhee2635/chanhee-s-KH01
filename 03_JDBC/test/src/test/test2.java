package test;

import java.util.Arrays;

public class test2 {

	public static void main(String[] args) {
		int[][] board = {{1, 1, 1, 1, 1}, 
			       {1, 0, 0, 0, 0}, // 1.1 | 1.2 | 1.3
			       {1, 0, 1, 0, 0}, // 2.1 | 2.2 | 2.3
			       {1, 0, 0, 0, 0}, // 3.1 | 3.2 | 3.3
			       {1, 0, 0, 0, 0}};
		System.out.println(solution1(board));
	}
	public static int solution1(int[][] board) {
        int answer = 0;
        int[][] boardadd = new int[board.length+2][board.length+2];
        for(int i=0;i<boardadd.length;i++) {
        	for(int j=0;j<boardadd.length;j++) {
        		boardadd[i][j] = 0;
        	}
        }
        
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board.length;j++) {
        		if(board[i][j]==1) {
        			boardadd[i][j] = 1;
        			boardadd[i][j+1] = 1;
        			boardadd[i][j+2] = 1;
        			boardadd[i+1][j] = 1;
        			boardadd[i+1][j+1] = 1;
        			boardadd[i+1][j+2] = 1;
        			boardadd[i+2][j] = 1;
        			boardadd[i+2][j+1] = 1;
        			boardadd[i+2][j+2] = 1;
        		}
        	}
        }
        for(int i=1;i<boardadd.length-1;i++) {
        	for(int j=1;j<boardadd.length-1;j++) {
        		if(boardadd[i][j]==0) {
        			answer++;
        		}
        	}
        }
        
        return answer;
	}
}
