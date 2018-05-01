package com.spring.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository("boardDAOJdbc")
public class BoardDAOJDBC {

	@Autowired
	private JdbcTemplate template;

	private final String BOARD_INSERT = "insert into board(board_seq,title,writer,content) values(board_seq.nextval,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?,content=? where board_seq=?";
	private final String BOARD_DELETE = "delete board where board_seq=?";
	private final String BOARD_GET = "select * from board where board_seq=?";
	private final String BOARD_LIST = "select * from board order by board_seq desc";

	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void insertBoard(BoardVO vo) {
		System.out.println(vo.getTitle()+vo.getWriter()+vo.getContent()+"!!!");
		template.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent()); 
	}

	public void updateBoard(BoardVO vo) {
		template.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getBoard_seq());
	}

	public void deleteBoard(BoardVO vo) {
		template.update(BOARD_DELETE, vo.getBoard_seq());
	}

	public BoardVO getBoard(BoardVO vo) {
		
		vo = template.queryForObject(BOARD_GET, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				BoardVO vo = new BoardVO();
				vo.setBoard_seq(rs.getInt("board_seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("Writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				return vo;
			}
		});
		
		return vo;	
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		
		List list = template.query(BOARD_LIST, new RowMapper<BoardVO>(){
			@Override
			public BoardVO mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				BoardVO vo = new BoardVO();
				vo.setBoard_seq(rs.getInt("board_seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("Writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
		
				return vo;
			}
			
		});
		System.out.println(list);
		return list;
	}

}
