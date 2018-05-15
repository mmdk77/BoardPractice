<%@page import="com.spring.board.repository.BoardDAOJDBC"%>
<%@page import="com.spring.board.domain.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR" %>
<%

request.setCharacterEncoding("EUC-KR");
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String board_seq = request.getParameter("board_seq");

BoardVO vo = new BoardVO();

vo.setTitle(title);
vo.setWriter(writer);
vo.setContent(content);
vo.setBoard_seq(Integer.parseInt("board_seq"));


BoardDAOJDBC boardDAO = new BoardDAOJDBC();
boardDAO.updateBoard(vo);

response.sendRedirect("getBoardList.jsp");

%>