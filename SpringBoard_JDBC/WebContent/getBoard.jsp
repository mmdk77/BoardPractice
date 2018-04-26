<%@page import="com.spring.board.repository.BoardDAOJDBC"%>
<%@page import="com.spring.board.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	String board_seq = request.getParameter("board");
	BoardVO vo = new BoardVO();
	vo.setBoard_seq(Integer.parseInt(board_seq));
	
	
	BoardDAOJDBC boardDAO = new BoardDAOJDBC();
	BoardVO board = boardDAO.getBoard(vo);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>글 상세</h1>
<a href="logout_proc.jsp">Log-out</a>



</body>
</html>