package com.spring.board.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOJDBC;

public class DispatcherServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, res);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
		}else if(path.equals("getBoardList.do")) {
			
			System.out.println("글 목록 검색 처리");
			
			BoardVO vo = new BoardVO();
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			HttpSession session = req.getSession();
			session.setAttribute("boardList", boardList);
			res.sendRedirect("getBoardList.jsp");
		}
		
		
		
		
	}

}
