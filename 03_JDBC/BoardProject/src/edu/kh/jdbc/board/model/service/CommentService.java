package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;

public class CommentService {

	CommentDAO dao = new CommentDAO();
	
	public int insertComment(String commentContent, int boardNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insertComment(conn, commentContent, boardNo, memberNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int checkComment(int boardNo, int commentNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.checkComment(conn, boardNo, commentNo, memberNo);
		
		close(conn);
		
		return result;
	}

	public int updateComment(int commentNo, String commentContent) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateComment(conn, commentNo, commentContent);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteComment(int commentNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteComment(conn, commentNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	
}
