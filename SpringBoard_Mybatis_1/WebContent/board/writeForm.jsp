<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function regist(){
		form1.action = "/board/write";
		form1.submit();
	}
	function cancel(){
		form2.action="/board/list";
		form2.submit();
	}
	
</script>
<body>
<center>
		<h1>글 쓰기</h1>
		<hr>
			<form name="form1" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="100" rows="20" name="content"></textarea></td>
				</tr>
			</table>
			<hr>
			<div>
				<input type="button" value="확인" onclick="regist()">
			</div>
			</form>
			
			<form name="form2" method="get">
				<input type="button" value="취소" onclick="cancel()">
			</form>
	</center> 

</body>
</html>