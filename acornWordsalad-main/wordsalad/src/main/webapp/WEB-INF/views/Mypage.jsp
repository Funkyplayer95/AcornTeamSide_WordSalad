<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>

		<head>
			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
			<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
			<meta charset="UTF-8">

			<title>마이페이지</title>
		</head>
		<style>
			body {
				margin-top: 600px;
				justify-content: center;
				align-items: center;
				text-align: center;
				font-family: 'Nanum Gothic', sans-serif;

			}

			#bigdiv {
				margin: 0 auto;
				width: 700px;
				/* height: 600px; */
				border: 2px solid black;
				padding: 0;
				border-radius: 2%;
				
			}

			#updiv {
				justify-content: center;
				width: 500px;
				height: 320px;
				margin: 0 auto;
				text-align: left;
			}

			#underdiv {
				justify-content: center;
				display: flex;
				height: 150px;
				margin: 0 auto;
			}

			#leftdiv {
				
				border-right: 2px solid black;
			}

			#underdiv>div {
				width: 50%;
				border-top: 2px solid black;
				height: 100%;
				font-weight: bolder;
			}

			#underdiv>div>a {
				font-size: 70px;
				color: red;

			}

			hr {
				border: 10px;
				margin: 0;
			}

			.cssbtn {
				margin-left: 100px;
				display:inline-block;
				padding: 7px 15px;
				font-size: 16px;
				text-align: center;
				text-decoration: none;
				cursor: pointer;
				border: 2px solid #D94925;
				background-color: #D94925;
				color: white;
				border-radius: 4px;
				width: 150px;
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
				<div id="firstdiv">
					<h1>Hello, &#60; ${userinfo.nickname} &#62; 님 !</h1>
				</div>
				<c:if test="${not empty requestScope.successMessage}">
					<p style="color: green;">
						<%= request.getAttribute("successMessage") %>
					</p>
				</c:if>

				<br> <br>
				<div id="updiv">
					<form action="/Mypage/changepw" method="post">
						<h3 class="textbox">아이디 &nbsp;:&nbsp; ${userinfo.id} &nbsp;&nbsp;&nbsp;
							<input type="hidden" name="id" value="${userinfo.id}">
							<input type="submit" value="비밀번호 변경" class="cssbtn">
						</h3>

					</form>
					<br>
					<form action="/Mypage/changenickname" method="post">
						<h3 class="textbox">
							닉네임 &nbsp;:&nbsp; ${userinfo.nickname} &nbsp;&nbsp;
							<input type="hidden" name="id" value="${userinfo.id}">
							<input type="submit" value="닉네임 변경" class="cssbtn">
						</h3>
					</form>
					<br>
					<form action="/Mypage/changetel" method="post">
						<h3 class="textbox">
							Tel. &nbsp;:&nbsp; ${userinfo.TELENUM} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="hidden" name="id" value="${userinfo.id}">
							<input type="submit" value="전화번호 변경" class="cssbtn">

						</h3>
					</form>
				</div>
				<hr>
				<div id="underdiv">
					<div id="leftdiv">
						&#60; 내가 쓴 게시글 &#62; <br><br> <a> ${userinfo.POSTCOUNT}</a>개
					</div>
					<div>
						&#60; 내가 쓴 댓글 &#62; <br><br> <a> ${userinfo.COMMENTCOUNT}</a>개
					</div>
				</div>

			</div>
			<br><br>
		</body>

		</html>