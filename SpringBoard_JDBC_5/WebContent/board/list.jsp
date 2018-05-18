<%@page import="com.spring.board.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	List<BoardVO> boardList = (List) request.getAttribute("list");
    	out.println(boardList.size()+"개수");
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>글 목록</h1>
	<hr>
	<table border="1" width="700" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th width="8">번호</th>
			<th width="200">제목</th>
			<th width="30">글쓴이</th>
			<th width="30">게시일</th>
			<th width="3">추천</th>
		</tr>
		
		
		<%for(int a=1; a<boardList.size(); a++){ %>
		<%BoardVO board=boardList.get(a); %>
		<tr align="center">
			<td><%=board.getBoard_seq() %></td>
			<td><%=board.getTitle() %></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate() %></td>
			<td><%=board.getCnt() %></td>			
		</tr>
		<%}%>
	</table>
</center>
</body>
</html>