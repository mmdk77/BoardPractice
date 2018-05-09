<%@page import="com.spring.board.repository.BoardDAOJDBC"%>
<%@page import="com.spring.board.domain.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR" %>
<%

request.setCharacterEncoding("EUC-KR");
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");

BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setWriter(writer);
vo.setContent(content);

BoardDAOJDBC boardDAO = new BoardDAOJDBC();
boardDAO.insertBoard(vo);

response.sendRedirect("getBoardList.jsp");

%>