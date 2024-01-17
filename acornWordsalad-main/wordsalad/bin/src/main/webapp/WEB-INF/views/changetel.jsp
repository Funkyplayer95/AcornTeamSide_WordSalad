<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>비밀번호 변경</title>
<head>
<meta charset="UTF-8">

</head>
<body>

	<h2>전화번호 변경</h2>

	<c:if test="${not empty requestScope.errorMessage}">
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	</c:if>
	
	

	<form action="/Mypage/changetel2" method="post">
    	<input type="hidden" name="id" value="${id}">
    	<br>
		<label for="pw">
		현재 비밀번호:
		</label> <input type="password" id="pw" name="pw" required><br>
		
		<label for="newPw">
		새 전화번호:
		</label> <input type="text" id="newTel" name="newTel" required><br>

		<input type="submit" value="전화번호 변경">
	</form>

</body>
</html>