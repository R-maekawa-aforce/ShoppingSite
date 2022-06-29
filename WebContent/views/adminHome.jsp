<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐管理者ホーム</title>
<link href = "/ShoppingSite/css/layoutAdminLogin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/layoutAdmin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/adminHome.css" rel = "stylesheet" media = "all">
</head>
<body>

<h1>管理者ホーム</h1><h5 class = msg>${loginmsg}</h5>
<p class = "error">${errmsg}</p>

<form action="../servlets/transition" method = "post">

<ul>
	<li><input type = "submit" name ="insertProduct" value = "商品登録" class = "button"></li>
	<li><input type="submit" name="updateProduct" value="商品情報更新" class = "button"></li>
	<li><input type = "submit" name ="deleteProduct" value = "商品削除" class = "button"></li>
</ul>
<br>
<br>
<br>
<br>

<ul>
	<li><input type = "submit" name ="stock" value = "在庫確認" class = "button" form = "stock"></li>
	<li><input type = "submit" name ="purchaseLog" value = "購入履歴" class = "button" form = "purchaseLog"></li>
	<li><input type = "submit" name ="logoutAdmin" value = "ログアウト" class = "button2" form = "logout"></li>
</ul>
<br>
<br>
<p>
<p>

</form>
<form action="../servlets/getLog" id = "purchaseLog" method = "post"></form>
<form action="../servlets/adminLogout" id = "logout" method = "post"></form>
<form action="../servlets/getStock" id = "stock" method = "post"></form>
</body>
</html>