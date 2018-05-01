<%@page import="com.spring.board.repository.BoardDAOJDBC"%>
<%@page import="com.spring.board.domain.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	String board_seq = request.getParameter("board_seq");
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
<center>
	<h1>글 상세</h1>
	<a href="logout_proc.jsp">Log-out</a>
	<hr>
	<form action="updateBoard_proc.jsp" method="post">
	<input name="board_seq" type="hidden" value="<%=board.getBoard_seq()%>">
		<table border="1" cellpadding="0" cellspacing="0">

			<tr>
				<td width="70">제목</td>
				<td align="left"><input type="text" name="title"
					value="<%=board.getTitle()%>" ></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td align="left"><%=board.getWriter()%></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td align="left"><%=board.getRegdate() %></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td align="left"><%=board.getCnt() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글수정">
				</td>
			</tr>
		</table>
	</form>
	
	<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?board_seq=<%=board.getBoard_seq()%>">글삭제</a>&nbsp;&nbsp;
	<a href="getBoardList.jsp">글목록</a>&nbsp;&nbsp;



</center>
</body>
</html>