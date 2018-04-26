package com.spring.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spring.board.domain.BoardVO;
import com.spring.common.JDBCUtil;

public class BoardDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private final static String BOARD_INSERT = "insert into board(board_seq,title,writer,content) values(board_seq.nextval,?,?,?)";
	private final static String BOARD_UPDATE = "update board set title=?,content=? where board_seq=?";
	private final static String BOARD_DELETE = "delete board where board_seq=?";
	private final static String BOARD_GET = "select * from board where board_seq=?";
	private final static String BOARD_LIST = "select * from board order by desc";

	//글쓰기
	public void insertBoard(BoardVO vo) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}

	// 글수정
	public void updateBoard(BoardVO vo) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoard_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}

	// 글삭제
	public void deleteBoard(BoardVO vo) {
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBoard_seq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, con);
		}
	}

	// 글조회
	public BoardVO getBoard(BoardVO vo) {
		con = JDBCUtil.getConnection();
		BoardVO board = null;
		try {
			pstmt = con.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getBoard_seq());
			pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("redate"));
				board.setCnt(rs.getInt("cnt"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, pstmt, con);
		}
		return board;

	}
	
	//글 목록조회
	public List<BoardVO> getBoardList(BoardVO vo){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		con = JDBCUtil.getConnection();
		try {
			pstmt=con.prepareStatement(BOARD_LIST);
			System.out.println(BOARD_LIST);
			pstmt.executeQuery();
			while(rs.next()){
				BoardVO board = new BoardVO();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, con);
		}
		return boardList;
	}
}
