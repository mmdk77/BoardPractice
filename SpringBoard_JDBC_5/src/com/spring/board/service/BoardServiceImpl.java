package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOJDBC;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAOJDBC boardDAOJDBC;

	@Override
	public BoardVO getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardDAOJDBC.getBoard(board_seq);
	}

	@Override
	public List getBoardList() {
		// TODO Auto-generated method stub
		return boardDAOJDBC.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOJDBC.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOJDBC.updateBoard(vo);
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		boardDAOJDBC.deleteBoard(board_seq);
	}
	

}
