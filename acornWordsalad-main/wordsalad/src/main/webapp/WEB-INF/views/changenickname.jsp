<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<title>비밀번호 변경</title>
<head>
<meta charset="UTF-8">

</head>
<body>

	<h2>닉네임 변경</h2>

	<c:if test="${not empty requestScope.errorMessage}">
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	</c:if>
	
	

	<form action="/Mypage/changenickname2" method="post">
    	<input type="hidden" name="id" value="${id}">
    	<br>
		<label for="pw">
		현재 비밀번호:
		</label> <input type="password" id="pw" name="pw" required><br>
		
		<label for="newPw">
		새 닉네임:
		</label> <input type="text" id="newNickName" name="newNickName" required><br>

		<input type="submit" value="닉네임 변경">
	</form>

</body>
</html>