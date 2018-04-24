package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {

	//CRUD ����� �޼ҵ� ����
	//�۵��
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	
}
