<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐管理者ログイン</title>
<link href = "/ShoppingSite/css/layoutAdminLogin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/adminHome.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/layoutAdmin.css" rel = "stylesheet" media = "all">
</head>
<body>
<div class = "body">

<h1>管理者ログイン</h1>
<p class = "msg">${msg}</p>
<form action="../servlets/adminLogin" method = "post">
<table>
	<tr>
		<th>ID : </th>
			<td><input type = "text" maxlength="15" name = "admin_id" value = "${admin_id}" class = "input"></td>
	</tr>
	<tr>
		<th>PASSWORD :</th>
			<td><input type = "password" maxlength="30" name = "password" value = "${password}" class = "input"></td>
	</tr>
</table>
<p class = "error">${errmsg}</p>
<br>
	<input type = "submit" name = "home" value = "戻る"  class = "button"  form = "back">　　　　　　　
	<input type = "submit" name ="adminLogin" value = "ログイン" onClick = "return Check()" class = "button">

</form>
<form action="../servlets/transition"  method = "post" id = "back"></form>
</div>
<script type="text/javascript" src = "../js/dialog.js"></script>
</body>
</html>