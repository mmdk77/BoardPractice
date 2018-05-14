<%@page import="com.spring.board.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html; charset=UTF-8"%>

<%
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<style>
table {
	border: 1px;
	border-style: solid;
	padding: 0;
	border-spacing: 0;
	width: 500px;
	margin: 0;
}

#select {
	text-align: right;
} 	

td {
	border: 1px;
	border-style: solid;
	text-align: center;
	margin: 0;
}
</style>
<body>
	
		<h1>글 목록</h1>
		<h3>테스트님 환영 합니다.....</h3>
		<form action="getBoardList.do" method="post">
			<table>
				<tr>
					<td id="select"><select name="searchCondition">
							<option value="title">제목</option>
							<option value="content">내용</option>
					</select> <input type="text" name="searchKeyword"> <input
						type="submit" value="검색"></td>
				</tr>
			</table>
		</form>

		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<%
				for (BoardVO board : boardList) {
			%>
			<tr>
				<td><a href="getBoard.do?board_seq=<%= board.getBoard_seq()%>"><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getContent() %></td>
				<td><%=board.getRegdate() %></td>
				<td><%=board.getCnt() %></td>
			</tr>
			<%
				}
			%>
		</table>
		<br> <a href="getBoard.jsp">새글 등록</a>
	

</body>
</html>