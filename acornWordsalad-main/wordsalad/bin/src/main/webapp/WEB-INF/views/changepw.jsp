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

	<h2>비밀번호 변경</h2>

	<c:if test="${not empty requestScope.errorMessage}">
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	</c:if>
	
	

	<form action="/Mypage/changepw2" method="post">
    	<input type="hidden" name="id" value="${id}">
    	<br>
		<label for="pw">
		현재 비밀번호:
		</label> <input type="password" id="pw" name="pw" required><br>
		
		<label for="newPw">
		새 비밀번호:
		</label> <input type="password" id="newPw" name="newPw" placeholder="8자리 이상 ~ 13자리 이하로 입력해주세요." required><br>
		
		<label for="checkNewPw">
		새 비밀번호 확인:</label>
    	<input type="password" id="checkNewPw" name="checkNewPw" placeholder="다시 한번 입력해주세요." required><br>

		<input type="submit" value="비밀번호 변경" onclick="check();">
	</form>

</body>

<script>
function check(){
	var newPw1 = document.getElementById('newPw').value;
	
	if(newPw1.length < 8){
		alert("비밀번호는 8자리 이상이여야 합니다.");
		return false;
	}
	if(newPw1.length > 13){
		alert("비밀번호는 13자리 이하이여야 합니다.");
		return false;
	}
	return true;
}

</script>
</html>