<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
	body {
	      font-family: Arial, sans-serif;
	      background-color: #f4f4f4;
	}

    .container {
      width: 50%;
      margin: 0 auto;
      padding: 20px;
      background-color: #ffffff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #D94925;
      text-align: center;
    }

    label {
      display: block;
      margin: 10px 0;
      color: #333;
    }

    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 8px;
      margin: 6px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    input[type="submit"] {
      background-color: #D94925;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #b73e1d;
    }
</style>
<script>




	function check(){
		
		var idCk = document.getElementById('isCheck').value;
		var nNCk = document.getElementById('isNickNameCheck').value;
		var pw1 = document.getElementById('pw').value;
		var pw2 = document.getElementById('pw2').value;
		
		if(idCk=="false"){
			alert("ID 중복확인을 진행해주세요.");
			return false;
		}
		if(nNCk=="false"){
			alert("닉네임 중복확인을 진행해주세요.");
			return false;
		}
		
		if(pw1.length < 6){
			alert("비밀번호는 6자리 이상이여야 합니다.");
			return false;
		}
		
		if(pw1!=pw2){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<main>
		<div>
			<form action="/regist" method="POST" onsubmit='return check();'>
				<fieldset>
		    		<h2>회원가입</h2>
					    <p>
							<label>아이디</label>
							<input type="text" id="id" name="id" onkeydown="inputIdChk()" required/>
							<input type="button" name="checkID" value="아이디 확인" onclick="idCheck()">
							<input type="hidden" id="isCheck" name="isIdCheck" value="false"/>
							<br>
					    </p>
					    <p>
					    	<label>닉네임</label>
					    	<input type="text" id="nickName" name="nickName" />
					    	<input type="button" name="checkID" value="닉네임 확인" onclick="nickNameCheck()">
					    	<input type="hidden" id="isCheck" name="isNickNameCheck" value="false"/>
					    </p>
					    <p>
							<label>비밀번호</label>
							<input type="password" id="pw" name="pw" required>
					      	<br>
					    </p>
					    <p>
					      	<label>비밀번호 확인</label>
							<input type="password" id="pw2" name="pw2" required>
					     	<br>
					    </p>
					    <p>
					      <label>핸드폰 번호</label>
					      <input type="text" name="teleNum" required>
					      <br>
					    </p>
					    <p>
					      <label>주소</label>
					      <input type="text" name="addr" required>
					      <br>
					    </p>
				</fieldset>
				<div id="buttons">
				  	<input type="submit" id="regist" value="회원가입">
				  	<input type="reset" value="다시 입력하기">
				</div>
			</form>
		</div>
	</main>
</body>
</html>