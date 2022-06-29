<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/home.css" rel = "stylesheet" media = "all">

</head>
<body>
	<h1>淀川カメラ</h1>
<p class = "msg">${logout}</p>
<p class = "msg">${nologin}</p>
<br>
<form action="../servlets/transition" method = "post">
	<input type ="submit" name ="product" value ="商品一覧へ" class = "button" form = "itemAll">

	<section><p>会員登録がお済みでない方は<br>会員登録をお願いします。</p></section>
	<input type = "submit" name = "regist" value = "会員登録" class = "button">　　
	<input type = "submit" name = "update" value = "会員情報更新" class = "button">　　
	<input type = "submit" name = "delete" value = "会員情報削除" class = "button">
</form>
<br>

<section>
<form action="../servlets/login" method = "post">
<p>会員登録済みの方</p>
	<table>
		<tr>
			<th>ID : </th>
			<td><input type ="text" maxlength="15" name = "member_id"  class = "input" value ="${member_id}"></td>
		</tr>
		<tr>
			<th>PASSWORD : </th>
			<td><input type ="password" maxlength="30" name = "password"  class = "input" value = "${pssword}"></td>
		</tr>
	</table>

		<p class = "error">${loginMiss}</p>

		<p><input type = "submit" name = "login" value = "ログイン" class = "button" onClick="return Check()"></p>
</form>
<br>
</section>
<br>
	<form action="../servlets/transition"  method = "post" class = "right-top">
	<input type = "submit" name = "admin" value = "管理者の方はこちら"  class = "button2" >
	</form>

<form action="../servlets/getItem" method = "post" id = "itemAll"></form>
<form action="../servlets/update" method = "post" id = "update"></form>
<form action="../servlets/delete" method = "post" id = "delete"></form>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>

<footer></footer>
</body>
</html>