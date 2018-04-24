package com.spring.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;
import com.spring.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = "insert into board(board_seq,title,writer,content) values(board_seq.nextval,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?,content=? where board_seq=?";
	private final String BOARD_DELETE = "delete board where board_seq=?";
	private final String BOARD_GET = "select * from board where board_seq=?";
	private final String BOARD_LIST= "select * from board order by board_seq desc";
	
	//�۵��
	public void insertBoard(BoardVO vo){
		System.out.println("====>JDBC insertboard()��� ó��");
		try {
			con=JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, con);
		}
		
	}
	
	//�ۼ���
	public void updateBoard(BoardVO vo){
		System.out.println("====>JDBC updateBoard()��� ó��");
		try {
			con = JDBCUtil.getConnection();
			pstmt=con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setInt(3, vo.getBoard_seq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, con);
		}
		
	}
	
	//�ۻ���
	public void deleteBoard(BoardVO vo){
		System.out.println("====>JDBC deleteBoard()��� ó��");
		
		try {
			con=JDBCUtil.getConnection();
			pstmt=con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBoard_seq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(pstmt, con);
		}
	}
	
	//�� ��ȸ
	public BoardVO getBoard(BoardVO vo){
		System.out.println("====>JDBC getBoard()��� ó��");
		BoardVO board =null;
		try {
			con=JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getBoard_seq());
			rs = pstmt.executeQuery();
			if(rs.next()){
				board=new BoardVO();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return board;
		
	}
	
	//�� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("====>JDBC getBoardList()��� ó��");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			con=JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_LIST);
			System.out.println(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO board = new BoardVO();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return boardList;
		
		
	}
	
	
	
}
