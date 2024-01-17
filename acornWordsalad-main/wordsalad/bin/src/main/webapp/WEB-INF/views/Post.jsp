<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<script src="https://kit.fontawesome.com/334bc39b2b.js" crossorigin="anonymous"></script>
</head>
<style>
    .postmain {
        margin: 0;
        font-family: Arial, sans-serif;
        width: 80%;
        margin-right: 30px;
        float: right;
    }

    .header {
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
        margin-bottom: 10px;
    }

    .menu {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .menu-item {
        margin-bottom: 30px;
    }

    .menu-item a {
        color: #fff;
        text-decoration: none;
        font-size: 18px;
        position: relative;
    }

    .menu-item a:hover::after {
        content: "";
        position: absolute;
        left: 0;
        right: 0;
        bottom: -2px;
        height: 2px;
        background-color: #fff;
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

    .main-content {
        margin-left: 240px;
        padding: 20px;
    }

    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px auto; /* 중앙 정렬을 위해 추가 */
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 8px;
        text-align: left;
        font-size: 12px; /* 글자 크기를 12px로 지정 */
    }

    th {
        background-color: white;
        color: black;
    }

    .likeandhatebtn > input {
        height: 100px;
        width: 100px;
        border-radius: 100%;
    }

    .likeandhatebtn {
        display: flex;
        justify-content: center;
        margin-top: 20px;
        margin-bottom: 50px;
    }

    .likeandhatebtn input[type="submit"] {
        height: 50px;
        width: 50px;
        margin: 0 10px;
        border-radius: 50%;
        border: none;
        cursor: pointer;
        font-size: 18px;
        background-color: #D94925;
        color: #fff;
        transition: background-color 0.3s ease;
    }

    .likeandhatebtn input[type="submit"]:hover {
        background-color: #ff6347;
    }

    .comment-div tr:nth-child(even) {
        background-color: transparent;
    }
    .comment-form {
        text-align: center; /* 가운데 정렬을 위해 추가 */
        margin-top: 20px; /* 폼과 상단 간격 조절 */
    }

    .comment-form input[type="text"] {
        padding: 8px;
        font-size: 14px; /* 폼 안의 텍스트 입력란 크기 조절 */
    }

    .comment-form input[type="submit"] {
        height: 30px;
        width: 80px;
        margin-top: 10px;
        border: none;
        cursor: pointer;
        font-size: 14px;
        background-color: #D94925;
        color: #fff;
        transition: background-color 0.3s ease;
    }

    .comment-form input[type="submit"]:hover {
        background-color: #ff6347;
    }
.title {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #D94925;
    color: white;
    padding: 10px;
}

.title p {
    margin: 0;
}

.title p:nth-child(1) {
    flex: 1;
    font-weight: bold;
}

.title p:nth-child(2) {
    flex: 2;
    text-align: center;
}

.title p:nth-child(3) {
    flex: 1;
    text-align: right;
}

.title p:nth-child(4) {
    flex: 1;
    text-align: right;
}
.postmain .maintext {

	margin-top: 100px;
    min-height: 500px;
}
.postscore {
    text-align: center;
    font-size: 16px;
    margin-top: 20px;
    color: #333; /* 원하는 색상으로 변경하세요 */
}
   
</style>
<body>
 	<header>
	  <div class="header">
	    <%@ include file="/WEB-INF/views/include/header.jsp" %>
	  </div>
	</header>
 	<div class="postmain">
	<div class="title">
	<p>${postinfo.POSTNUMBER}</p>
	<p>${postinfo.POSTTITLE}</p>
	<p>${postinfo.POSTWRITER}</p>
	<p>${postinfo.POSTDATE}</p>
	</div>
	<p class="maintext">${postinfo.POSTCONTENTS}</p>
	<pre class="postscore">좋아요 ${postinfo.POSTLIKE}   싫어요 ${postinfo.POSTHATE}</pre>

	
	<form class="likeandhatebtn" action="/likeAndHate">
	 	<input name="postnum" type="hidden" value="${postinfo.POSTNUMBER}">	

	<input class="likeBtn" type="submit" value="좋아" name="butname">	
	<input class="hateBtn" type="submit" value="싫어" name="butname">
 
	</form>
	
	
	<table border="1">
		<tr>
			<th>게시글번호</th>
			<th>댓글내용</th>
			<th>댓글작성자</th>
			<th>작성일자</th>
			<th>좋아요수</th>
			<th>싫어요수</th>
		</tr>
	 		<c:forEach var="c" items="${cmtinfo}">
			<tr>
				<td>${c.POSTNUMBER}</td>
				<td>${c.COMMENTCONTENTS}</td>
				<td>${c.COMMENTWRITER}</td>
				<td>${c.COMMENTDATE}</td>
				<td>${c.COMMENTLIKE}</td>
				<td>${c.COMMENTHATE}</td>
			</tr>
			</c:forEach>
	</table>
        <form class="comment-form" action="newCmt">
            <input name="postnum" type="hidden" value="${postinfo.POSTNUMBER}">
            <input name="cmtcontenct" type="text" placeholder="댓글 내용">
            <input type="submit" value="전송">
        </form>
 	</div>
	
</body>
</html>
