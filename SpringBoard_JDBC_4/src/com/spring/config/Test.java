package com.spring.config;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.domain.BoardVO;
import com.spring.board.service.BoardService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext("com/spring/config/applicationContext.xml");
		
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO board:boardList) {
			System.out.println(board.toString());
		}
		
		container.close();
		
	}

}
