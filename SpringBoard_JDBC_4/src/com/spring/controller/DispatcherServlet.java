package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOJDBC;
import com.spring.user.domain.UserVO;
import com.spring.user.repository.UserDAOJDBC;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, res);
	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");

			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			System.out.println("1111"+id+"22222"+password);

			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			System.out.println("11111111111111" + vo.toString());
			UserDAOJDBC userDAOJDBC = new UserDAOJDBC();

			UserVO user = userDAOJDBC.getUser(vo);

			
			if (user != null) {
				res.sendRedirect("getBoardList.do");
			}else{
				res.sendRedirect("login.jsp");
			}
			
		} else if (path.equals("/logout.do")) {

			System.out.println("로그아웃 처리");

			HttpSession session = req.getSession();
			session.invalidate();
			res.sendRedirect("login.jsp");

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");

			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.insertBoard(vo);

			res.sendRedirect("getBoardList.do");

		} else if (path.equals("/updateBoard.do")) {

			System.out.println("글 수정 처리");

			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.updateBoard(vo);

			res.sendRedirect("getBoardList.do");

		} else if (path.equals("/deleteBoard.do")) {

			System.out.println("글 삭제 처리");

			String board_seq = req.getParameter("board_seq");

			BoardVO vo = new BoardVO();
			vo.setBoard_seq(Integer.parseInt(board_seq));

			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.deleteBoard(Integer.parseInt(board_seq));

		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");

			String board_seq = req.getParameter("board_seq");

			BoardVO vo = new BoardVO();
			vo.setBoard_seq(Integer.parseInt(board_seq));

			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			BoardVO board = boardDAO.getBoard(Integer.parseInt(board_seq));

			HttpSession session = req.getSession();
			session.setAttribute("board", board);
			res.sendRedirect("getBoard.jsp");

		} else if (path.equals("/getBoardList.do")) {

			System.out.println("글 목록 조회 처리");

			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			List<BoardVO> boardList = boardDAO.getBoardList();

			HttpSession session = req.getSession();
			session.setAttribute("boardList", boardList);
			res.sendRedirect("getBoardList.jsp");

		}

	}
}
