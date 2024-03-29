<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>게시판 메인 페이지</title>
<script>
  document.addEventListener("DOMContentLoaded", function() {
    var rows = document.querySelectorAll("tr[data-user='admin']");
    rows.forEach(function(row) {
      row.style.backgroundColor = "#F89712";
      row.style.color = "white";
    });
  });
</script>
<style>
 .body-top{
 	width:80%;
    margin-right: 30px;
    float: right;
 }
.container {
    width:80%;
    margin-right: 30px;
    float: right;
    margin-bottom: 200px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 15px;
    text-align: left;
    border-top: 1px solid #ddd;
    border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

/* Remove borders for first and last td elements */
td:first-child, td:last-child {
    border-left: none;
    border-right: none;
}
.name-row {
    background-color: #fae8e3;
    color: #D94925;
    border-top: 5px solid #D94925;
}

.picture-div {
    height: 400px;
    width:80%;
    margin-right: 30px; 
    margin-bottom:60px;
    float: right; 
    display: flex;
    align-items: center;
    justify-content: center;
    background-size: cover;
    background-position: center;
}

.picture-div img {
    vertical-align: middle;
    height: 100%;
   	width:100%;
   	margin-top:80px;
}
/* 페이지네이션 */
 .pagination {
     margin-top: 20px;
     padding-left: 0;
     list-style: none;
     display: flex;
     justify-content: center;
 }

 .pagination li {
     display: inline-block;
     margin-right: 5px;
 }

 .pagination a,
 .pagination span {
     color: #007bff;
     border: 1px solid #007bff;
     padding: 5px 10px;
     text-decoration: none;
     cursor: pointer;
 }

 .pagination .active a,
 .pagination .active span {
     background-color: #007bff;
     color: #fff;
     border: 1px solid #007bff;
 }

 .pagination a:hover {
     background-color: #0056b3;
     color: #fff;
     border: 1px solid #0056b3;
 }
</style>
</head>
<body>
	<header>
	  <div class="header">
	    <%@ include file="/WEB-INF/views/include/header.jsp" %>
	  </div>
	</header>
  <div class="body-top">
  	<h1>POST LIST</h1>
  	<form action="/search">
		<table class="pull-right">
			<tr>
				<td><input type="text" class="form-control"
					placeholder="검색어 입력" name="searchText" maxlength="100"></td>
				<td><button type="submit" class="btn btn-success">검색</button></td>
			</tr>
		</table>
	</form>
  </div>
  <div class="picture-div">
  	<img alt="메인헤드이미지" src="/resources/images/mainImage.jpg">
  </div>
  <div class="container">
    <table>
      <tr class="name-row">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>좋아요</th>
        <th>싫어요</th>
        <th>작성일</th>
      </tr>
      <c:forEach var="postitem" items="${postlist.content}">
        <tr data-user="${postitem.userInfo_Id}">
          <td>${postitem.postnumber}</td>
          <td><a href="/Post?postnum=${postitem.postnumber}">${postitem.posttitle}</a></td>
          <td>${postitem.userInfo_Id}</td>
          <td>${postitem.postlike}</td>
          <td>${postitem.posthate}</td>
          <td>${postitem.postdate}</td>
        </tr>
      </c:forEach>
    </table>
	<!-- 페이징 영역 시작 -->
	<div class="text-xs-center">
		<ul class="pagination justify-content-center">
		
			<!-- 이전 -->
			<c:choose>
				<c:when test="${postitem.first}"></c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="/main?page=0">처음</a></li>
				</c:otherwise>
			</c:choose>

			<!-- 페이지 그룹 -->
			<c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
				<c:choose>
					<c:when test="${postitem.pageable.pageNumber+1 == i}">
						<li class="page-item disabled"><a class="page-link" href="/main?page=${i-1}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="/main?page=${i-1}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 -->
			<c:choose>
				<c:when test="${postitem.last}"></c:when>
				<c:otherwise>
					<li class="page-item "><a class="page-link" href="/main?page=${postitem.totalPages+1}">마지막</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<!-- 페이징 영역 끝 -->
	<div class="text-right">
		<input type="button" value="글쓰기" onclick="loginCheck();">
  	</div>
  </div>
</body>
<script>
	function loginCheck(){
		var id = '<%= (String) session.getAttribute("id")%>';
		if(id == null){
			alert("글 작성을 하려면 로그인을 하세요.")
		}
		else{
			location.replace("/postwrite")
		}
	}
</script>
</html>

