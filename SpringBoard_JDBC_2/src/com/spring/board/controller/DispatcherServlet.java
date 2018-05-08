package com.spring.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.board.domain.BoardVO;
import com.spring.board.repository.BoardDAOJDBC;
import com.spring.user.domain.UserVO;
import com.spring.user.repository.UserDAOJDBC;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAOJDBC userDAOJDBC = new UserDAOJDBC();
			UserVO user = userDAOJDBC.getUser(vo);
			
			if(user!=null) {
				response.sendRedirect("getBoardList.do");
			}else {
				response.sendRedirect("login.jsp");
			}
			
		} else if (path.equals("/logout.do")) {
			
			System.out.println("로그아웃 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
			
		} else if (path.equals("/updateBoard.do")) {
			
			System.out.println("글 수정 처리");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
			
		} else if (path.equals("/deleteBoard.do")) {
			
			System.out.println("글 삭제 처리");
			
			String board_seq = request.getParameter("board_seq");
			
			BoardVO vo = new BoardVO();
			vo.setBoard_seq(Integer.parseInt(board_seq));
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			boardDAO.deleteBoard(vo);
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			String board_seq = request.getParameter("board_seq");
			
			BoardVO vo = new BoardVO();
			vo.setBoard_seq(Integer.parseInt(board_seq));
			
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			BoardVO board = boardDAO.getBoard(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
		} else if (path.equals("/getBoardList.do")) {
			
			System.out.println("글 목록 조회 처리");
			
			BoardVO vo = new BoardVO();
			BoardDAOJDBC boardDAO = new BoardDAOJDBC();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
			
		}

	}

}
