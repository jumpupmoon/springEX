<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 폼</h1>
	<form action="./fileAdd" method="post" enctype="multipart/form-data">
		<div>
			File Title : 
			<input type="text" name="fileTitle"/>
		</div>
		<div>
			File :
			<input type="file" name="file" />
		</div>
		<div>
			<input type="submit" value="저장" />
		</div>
	</form>
</body>
</html>