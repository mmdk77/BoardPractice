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
	function update(){
		form1.action = "/board/update";
		form1.submit();
	}
	function cancel(){
		alert("test action");
		form2.action="/board/list";
		form2.submit();
		
	}
	
</script>
<body>
<center>
		<h1>글 수정</h1>
		<hr>
			<form name="form1" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="<%=board.getBoard_seq()%>"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" value="<%=board.getBoard_seq()%>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="100" rows="20" name="content"><%=board.getBoard_seq()%></textarea></td>
				</tr>
			</table>
			<hr>
			<div>
				<input type="button" value="수정" onclick="update()">
			</div>
			</form>
			
			<form name="form2" method="get">
				<input type="button" value="취소" onclick="cancel()">
			</form>
	</center> 

</body>
</html>