package com.spring.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository
public class BoardDAOJDBC implements BoardDAO{

	@Autowired
	private JdbcTemplate template;
	
	private final String BOARD_GET="SELECT * FROM BOARD WHERE BOARD_SEQ=?";
	private final String BOARD_LIST="SELECT * FROM BOARD ORDER BY BOARD_SEQ DESC";
	private final String BOARD_INSERT="INSERT INTO BOARD(BOARD_SEQ,TITLE,WRITER,CONTENT) VALUE(BOARD_SEQ.NEXTVAL,?,?,?)";
	private final String BOARD_UPDATE="UPDATE BOARD SET TITLE=?,WRITER=?,CONTENT=?";
	private final String BOARD_DELETE="DELETE BOARD WHERE BOARD_SEQ=?";
	
	@Override
	public BoardVO getBoard(int board_seq) {
		// TODO Auto-generated method stub
		BoardVO board = template.queryForObject(BOARD_GET, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				BoardVO board = new BoardVO();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setCnt(rs.getInt("cnt"));
				return board;
			}
			
		},board_seq);
		return board;
	}

	@Override
	public List getBoardList() {
		// TODO Auto-generated method stub
		List boardlist = template.query(BOARD_LIST, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				BoardVO board = new BoardVO();
				board.setBoard_seq(rs.getInt("board_seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setCnt(rs.getInt("cnt"));
				return board;
			}
			
		});
		return boardlist;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		template.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		template.update(BOARD_UPDATE,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getBoard_seq());
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		template.update(BOARD_DELETE,board_seq);
	}
	
	
	
	

}
