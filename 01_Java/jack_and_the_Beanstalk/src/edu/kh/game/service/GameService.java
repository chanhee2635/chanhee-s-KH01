package edu.kh.game.service;

import edu.kh.game.dto.Tree;

public class GameService {

		public Tree signUp(String userId, String userPw, String userPwConfirm,
				           String userName) {
			
			Tree user = null;
			
			if(userPw.equals(userPwConfirm) ) {
				
				user = new Tree(userId, userPw, userPwConfirm, userName);
			}
			
			
			return user;
			
			
		}
}
