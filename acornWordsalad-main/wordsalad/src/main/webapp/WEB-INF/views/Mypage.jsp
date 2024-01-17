<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<style>
body {
	text-align: center;
}

#bigdiv {
	margin: 0 auto;
	width: 600px;
	/* height: 600px; */
	border: 1px solid black;
	padding: 0;
	border-top-left-radius: 5%; 
	border-top-right-radius: 5%;
	
}

#updiv {
	justify-content: center;
	width: 500px;
	height: 300px;
	margin: 0 auto;
	text-align: left;
}

#underdiv {
	justify-content: center;
	display: flex;
	height: 200px;
	margin: 0 auto;
}

#underdiv>div {
	width: 50%;
	border: 1px solid black;
	height: 100%;
}

#underdiv>div>a {
	font-size: 100px;
	color: red;
}
hr {
	border: 10px;
	margin: 0;
}
</style>
<body>
	<header>	
	  <div class="header">
	    <%@ include file="/WEB-INF/views/include/header.jsp" %>
	  </div>
	</header>
<br><br><br>
	<div id="bigdiv">
		<h1>&#60; ${userinfo.nickname} &#62; 님의 My Page</h1>
		<c:if test="${not empty requestScope.successMessage}">
	    <p style="color: green;"><%= request.getAttribute("successMessage") %></p>
	</c:if>
		<br> <br>
		<div id="updiv">
			<h3>아이디 : ${userinfo.id}</h3>
				<form action="/Mypage/changenickname" method="post">
				<h3>
					닉네임 : ${userinfo.nickname}   &nbsp;
    						<input type="hidden" name="id" value="${userinfo.id}">
    						<input type="submit" value="닉네임 변경">
				</h3>
			</form>
			<form action="/Mypage/changepw" method="post">
				<h3>
					비밀번호 변경 : 
    						<input type="hidden" name="id" value="${userinfo.id}">
    						<input type="submit" value="비밀번호 변경">
				</h3>
			</form>
			<form action="/Mypage/changetel" method="post">
				<h3>
					핸드폰 번호 : ${userinfo.TELENUM} 
    						<input type="hidden" name="id" value="${userinfo.id}">
    						<input type="submit" value="전화번호 변경">
    						
				</h3>
			</form>
		</div>
		<hr>
		<div id="underdiv">
			<div>
				&#60; 내가 쓴 게시글 &#62; <br> <a> ${userinfo.POSTCOUNT} </a>
			</div>
			<div>
				&#60; 내가 쓴 댓글 &#62; <br> <a> ${userinfo.COMMENTCOUNT} </a>
			</div>
		</div>

	</div>
<br><br>
</body>
</html>
