package com.spring.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository("boardDAOJDBC")
public class BoardDAOJDBC implements BoardDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	private final String BOARD_GET = "select * from board where board_seq=?";
	private final String BOARD_LIST = "select * from board order by board_seq desc";
	private final String BOARD_INSERT = "insert into board(board_seq,title,writer,content) values(board_seq.nextval,?,?,?)";
	private final String BOARD_DELETE = "delete board from board_seq=?";
	private final String BOARD_UPDATE = "update board set title=?,writer=?,content=? where board_seq=?";

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
		vo = template.queryForObject(BOARD_GET, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rows) throws SQLException {
				// TODO Auto-generated method stub
				BoardVO vo = new BoardVO();
				vo.setBoard_seq(rs.getInt("board_seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				return vo;
			}
			
		});
		return vo;
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		
		List boardList = template.query(BOARD_LIST, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rows) throws SQLException {
				// TODO Auto-generated method stub
				BoardVO vo = new BoardVO();
				
				vo.setBoard_seq(rs.getInt("board_seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("conent"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
		
				
				return vo;
			}
			
		});
		return boardList;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		template.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		template.update(BOARD_DELETE,vo.getBoard_seq());
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		template.update(BOARD_UPDATE,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getBoard_seq());
	}

	
}
