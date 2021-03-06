package com.spring.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOMybatis;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Resource(name="boardDAOMybatis")
	private BoardDAOMybatis boardDAOMybatis;

	@Override
	public BoardVO getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardDAOMybatis.getBoard(board_seq);
	}

	@Override
	public List getBoardList() {
		// TODO Auto-generated method stub
		return boardDAOMybatis.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOMybatis.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAOMybatis.updateBoard(vo);
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		boardDAOMybatis.deleteBoard(board_seq);
	}
	

}
