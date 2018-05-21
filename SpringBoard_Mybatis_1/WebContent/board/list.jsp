<%@page import="com.spring.board.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<Board> list = (List) request.getAttribute("list");
	out.print(list.size()+"개");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
	<h1>게시판 목록</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>추천수</th>
			</tr>
		</thead>
		<tbody>
			<%for(int a=0; a<list.size(); a++) {%>
			<%Board board = list.get(a); %>
			<tr align="center" height="20px">
				<td width="50"><%=board.getBoard_seq() %></td>
				<td width="300"><a href="/board/<%=board.getBoard_seq()%>"><%=board.getTitle()%></a></td>
				<td width="100"><%=board.getWriter()%></td>
				<td width="100"><%=board.getRegdate().substring(0, 10) %></td>
				<td width="50"><%=board.getCnt() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>

</center>


</body>
</html>