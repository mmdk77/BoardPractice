package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOJDBC;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDAOJdbc")
	private BoardDAOJDBC boardDAOJdbc;
	
	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOJdbc.insertBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOJdbc.deleteBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOJdbc.updateBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAOJdbc.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAOJdbc.getBoardList(vo);
	}

}
