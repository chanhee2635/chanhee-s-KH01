package test;

import java.util.ArrayList;
import java.util.List;

public class test1 {

    public static void main(String[] args) {
    	int[][] score = {{1, 3}, {3, 1}, {2, 3}, {3, 2}, {1, 2}, {0, 0}};
    	for(int i : solution(score)) {
    		System.out.print(i+" ");
    	}
    }
    public String[] solution(String[][] plans) {
        String[] answer = {};
        if()
        if(a[i+1][1] - a[i][1] > a[i][2])
        
        
        
        return answer;
    }
    public static int[][] hhmm(String[][] a){
        for(int i=0;i<a.length;i++){
        	int hh = Integer.parseInt(a[i][0].substring(0, 2));
            int mm = Integer.parseInt(a[i][1].substring(3));
            
        }
        return;
        
    }
    
    public static int[][] change(int[][] a){
    	String[] temp = null;
        for(int i=0;i<a.length;i++){
            if(a[i][1]>a[i+1][1]){
                temp[i] = a[i];
                a[i] = a[i+1];
                a[i+1] = temp[i];
            }
        }
        return a;
    }
}
