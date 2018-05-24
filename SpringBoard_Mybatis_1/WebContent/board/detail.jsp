<%@page import="com.spring.board.domain.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		Board board =(Board) request.getAttribute("board"); 
		out.print(board.getBoard_seq()+"입니다.");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 보기</h1>
		<hr>
	
			<input type="hidden" name="board_seq" value="<%=board.getBoard_seq()%>" disabled="disabled">
			<table>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title" value="<%=board.getTitle()%>" disabled="disabled">
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" name="writer" value="<%=board.getWriter()%>" disabled="disabled">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="100" rows="20" name="content" disabled="disabled"><%=board.getContent() %></textarea></td>
				</tr>
			</table>
			<a href="/board/list">목록</a>&nbsp;&nbsp;&nbsp;
			<a href="/board/editForm/<%=board.getBoard_seq()%>">수정</a>&nbsp;&nbsp;&nbsp;
			<a href="/board/delete/<%=board.getBoard_seq()%>">삭제</a>
				
	</center> 

</body>
</html>