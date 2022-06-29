<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐商品情報削除</title>
<link href = "/ShoppingSite/css/layoutAdmin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/adminHome.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/layoutAdminLogin.css" rel = "stylesheet" media = "all">
</head>
<body>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>商品削除</h1><h5 class = msg>${loginmsg}</h5>
<p class = "error">${errmsg}</p>
<p class = "success">${success}</p>

<form action="../servlets/deleteProduct" method = "post">
<table>
	<tr>
		<th>商品番号 : </th>
			<td><input type = "text" maxlength="10" name = "product_id" value = "${product_id}" class = "short_input"></td>
			<td><input type = "submit" name = "search_product" value = "検索" class = "button2" ></td>
	</tr>

	<tr>
		<th>商品名 : </th>
			<td><input type = "text" maxlength="15" name = "product_name" value = "${product.product_name}" class = "short_input" disabled="disabled"></td>
	</tr>
	<tr>
		<th>値段 :</th>
			<td><input type = "text" maxlength="10" name = "price" value = "${product.price}" class = "short_input" disabled="disabled"></td>
			<td>円</td>
	</tr>
</table>
<br>
	<input type = "submit" name = "adminHome" value = "戻る" form = "back" class = "button">　　　　　　　
	<input type = "submit" name = "delete_product" value = "商品削除" class = "button" onClick="return Check()">
</form>

<form action="../servlets/transition" id = "back" method = "post"></form>

<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>
</body>
</html>