package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOJDBC;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	public BoardDAOJDBC boardDAO;
	
	@Override
	public BoardVO getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(board_seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(board_seq);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	
}
