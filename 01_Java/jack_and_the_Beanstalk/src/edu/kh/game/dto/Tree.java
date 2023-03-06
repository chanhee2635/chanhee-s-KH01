package edu.kh.game.dto;

public class Tree {

	int treeLength = 0;
	double growthRate = 1.0;
	private String userId;
	private String userPw;
	private String userPwConfirm;

	public String getUserPwConfirm() {
		return userPwConfirm;
	}

	public void setUserPwConfirm(String userPwConfirm) {
		this.userPwConfirm = userPwConfirm;
	}

	public String getUserId() {
		return userId;
	}

	public Tree() {} 

	public Tree(String userId, String userPw, String userPwConfirm, 
			      String userName) {
		
	   this.userId = userId;	
	   this.userPw = userPw;	
	   this.userPwConfirm = userPwConfirm;	
	}
	

	public String toString() {
		return String.format("%s / %s / %s", userId, userPw, userPwConfirm);
		
	}
	
	public String getuserId() {
		return userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
   
	
	public double getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(double growthrate) {
		this.growthRate = growthrate;
	}

	public int getTreeLength() {
		return treeLength;
	}

	public void setTreeLength(int treeLength) {
		this.treeLength = treeLength;
	}
}
