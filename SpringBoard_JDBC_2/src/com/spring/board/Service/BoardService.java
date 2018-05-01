package com.spring.board.Service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {
	
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);

}
