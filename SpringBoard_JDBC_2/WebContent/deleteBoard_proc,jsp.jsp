<%@page import="com.spring.board.repository.BoardDAOJDBC"%>
<%@page import="com.spring.board.domain.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
String board_seq = request.getParameter("board_seq");

BoardVO vo = new BoardVO();
vo.setBoard_seq(Integer.parseInt("board_seq"));

BoardDAOJDBC boardDAO = new BoardDAOJDBC();
boardDAO.deleteBoard(vo);

response.sendRedirect("getBoardList.jsp");
%>