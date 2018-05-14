<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<style>
    table{
        border: 1px;
        border-style: solid;
        padding: 0;
        border-spacing: 0;
        width: 500px;

    }
    td{
        border:1px;
        border-style: solid;
        text-align: left;
        width: 70px;
    }
</style>
<body>
    <center>
        <h1>글 상세</h1>
        <a href="logout.do">logout</a>
        <hr>
        <form action="login.do" method="post">
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
                    <td>
                        <textarea name="content" cols="40" rows="10">
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td>등록일</td>
                    <td></td>
                    
                </tr>
                <tr>
                    <td>조회수</td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="글 수정"></td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="#">글 쓰기</a>&nbsp;&nbsp;&nbsp;
        <a href="#">글 삭제 </a>&nbsp;&nbsp;&nbsp;
        <a href="#">글 목록</a>
    </center>
    
</body>
</html>