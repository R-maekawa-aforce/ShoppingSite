<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐在庫一覧</title>
<link href = "/ShoppingSite/css/layoutAdmin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/adminHome.css" rel = "stylesheet" media = "all">
<link href="/ShoppingSite/css/log.css" rel="stylesheet" media="all">
</head>
<body>

<h1>在庫一覧</h1><h5 class = msg>${loginmsg}</h5>
<p>${errmsg}</p>
<p>${msg}</p>

<table>
<c:forEach var = "p" items = "${list}">
	<tr>
	<td>商品ID : </td>
	<td><input type = "text" disabled="disabled" value = "${p.product_id}" class = "veryshort_input">
	<td>商品名 : </td>
	<td><input type = "text" disabled="disabled" value = "${p.product_name}" class="input"></td>
	<td>値段 : </td>
	<td><input type = "text" disabled="disabled" value = "${p.price}" class = "short_input"></td>
	<td>個数 : </td>
	<td>
	<form action="../servlets/updateProduct" method = "post" id = "updateProduct">
		<select name = "amount">
			<option value = "" selected="selected" disabled="disabled">
			<c:forEach var = "i" begin="1" end="500">
				<option value = "${i}">${i}</option>
			</c:forEach>
			<c:if test="${not empty p.amount}">
				<option value = "${p.amount}" selected="selected">${p.amount}</option>
			</c:if>
		</select>
	<input type = "hidden" name = "product_id" value = "${p.product_id}">
	<input type = "submit" name = "update_product" value = "在庫更新" class = "button3" onClick="return Check()" >
	</form>
	</td>
	</tr>
</c:forEach>
</table>

<p>
	<input type = "submit" name = "adminHome" value = "戻る" form = "back" class = "button">
</p>

<form action="../servlets/transition" id = "back" method = "post"></form>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>
</body>
</html>