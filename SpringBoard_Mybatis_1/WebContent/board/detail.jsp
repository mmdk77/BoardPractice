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

<script type="text/javascript">
	function updateBoard(){
		form1.action="/board/editForm/<%=board.getBoard_seq()%>";
		form1.submit();
	}
	function deleteBoard(){
		form2.action="/board/";
		form2.submit();
	}
</script>
<body>
	<center>
		<h1>글 보기</h1>
		<hr>
	
			<input type="hidden" name="id" value="<%=board.getBoard_seq()%>">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"
						value="<%=board.getTitle()%>"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"
						value="<%=board.getWriter()%>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="100" rows="20" name="content"><%=board.getContent() %></textarea></td>
				</tr>
			</table>
			<form name="form1" method="get">
				<input type="button" value="수정" onclick="updateBoard()">
			</form>
			<form name="form2" method="post">
				<input type="button" value="삭제" onclick="deleteBoard()">
			</form>
				
	</center> 

</body>
</html>