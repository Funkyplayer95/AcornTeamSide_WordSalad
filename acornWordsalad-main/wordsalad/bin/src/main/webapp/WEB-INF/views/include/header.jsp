<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Vertical Header</title>

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
}

.header {
    position: fixed;
    height: 100vh;
    width: 220px;
    background-color: #D94925;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    box-sizing: border-box;
}

.logo a {
    color: #fff;
    text-decoration: none;
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 10px; /* 변경: 로고 아래 간격을 조절합니다. */
}

.menu {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.menu-item {
    margin-bottom: 30px; /* 변경: 메뉴 항목 간격을 30px로 조절합니다. */
}

.menu-item a {
    color: #fff;
    text-decoration: none;
    font-size: 18px;
    position: relative; /* 부모에 상대적인 위치를 가지도록 설정 */
}

.menu-item a:hover::after {
    content: ""; /* 가상 요소 생성 */
    position: absolute;
    left: 0;
    right: 0;
    bottom: -2px; /* 밑줄의 두께를 조절합니다. */
    height: 2px; /* 밑줄의 높이를 조절합니다. */
    background-color: #fff; /* 밑줄의 색상을 지정합니다. */
}

.link-sns {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.link-sns a {
    color: #fff;
    text-decoration: none;
    font-size: 18px;
    margin-bottom: 10px;
}

</style>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String nickname = (String) session.getAttribute("nickName");
	%>
	
	<div class="header">
	    <div class="logo">
	        <a href="/main">아무말대잔치</a>
	    </div>
	    <div class="menu">
	        <div class="menu-item"><a href="/postlist?category=normal">카테고리</a></div>
	        <div class="menu-item"><a href="/postlist?category=notice">공지사항</a></div>
	        <div class="menu-item"><a href="/Mypage">마이페이지</a></div>
	    </div>
    	<%
			if (id != null) {
		%>
			<div class="link-sns">
				<a href="/Mypage"><%=nickname%></a>
				<a href="/logout">로그아웃</a>
			</div>
			<%
			} else {
			%>
				<div class="link-sns">
					<a href="/login">로그인</a>
					<a href="/regist">회원가입</a>
				</div>
			<%
			}
		%>
			
</body>
</html>
