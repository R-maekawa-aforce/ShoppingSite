<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐カート</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/itemAll.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/img.css" rel = "stylesheet" media = "all">
</head>
<body>
<h1>カート</h1>
<h5>${welcome}</h5>
<br>
<form action="../servlets/getItem" method = "post">
<c:if test="${empty welcome }">
<input type = "submit" name = "home" value = "ログイン" form = "login" class = "button">　　
</c:if>
<input type = "submit"  value = "商品一覧"  name = "product" class = "button">　　
<input type = "submit" name = "purchase" value = "購入方法" class = "button" form="purchase">　　
<input type = "submit" name = "favorite" value = "お気に入り" form = "favorite" class = "button">　　
<input type = "submit" name = "logout" value = "ログアウト" form = "logout" class = "button">
</form>
<form action="../servlets/transition" method = "post" id = "login"></form>
<form action="../servlets/getFavorite" method = "post" id = "favorite"></form>
<form action="../servlets/logout" method = "post" id = "logout"></form>
<form action="../servlets/purchase" method = "post" id = "purchase"></form>
<br>
<p class = "msg">${changemsg}</p>
<br>

<table>
	<c:forEach var = "c" items = "${cart}">
	<tr>
		<th><div class = "name">${c.productBean.product_name}</div></th>
		<td>
		<div class = "image">
			<div class = "center">
			<img src = "data:${c.productBean.contentType};base64,${c.productBean.base64String}" class = "img" name = "img">
			</div>
		</div>
		</td>


		<td><div class = "price">値段 : ${c.productBean.price}円</div></td>

		<td>
		<div class = "price">
			<form action = "../servlets/changeCart" method = "post">
				個数 : <select name = "amount">
					<c:forEach var = "i" begin="1" end="15">
						<option value = "${i}">${i}</option>
					</c:forEach>
				<c:if test="${not empty c.count}">
					<option value = "${c.count}"selected>${c.count}</option>
				</c:if>
				</select><br>
				<input type = "submit" name = "update" value = "個数変更" onClick="return Check()">
				<input type = "hidden" name = "product_name" value = "${c.productBean.product_name}" >
			</form>
			</div>
		</td>

		<td><div class = "price">小計 : ${c.semiTotal}</div></td>


		<td>
			<form action = "../servlets/changeCart" method = "post">
				<input type = "hidden" name = "product_name" value = "${c.productBean.product_name}" >
				<input type = "submit" name = "delete" value = "カートから削除"  onClick="return Check()">
			</form>
		</td>
	</tr>
	</c:forEach>
</table>
<br>
	<p class = "sum">合計金額 :${sum}円</p>
<br>

<c:choose>
	<c:when test="${cart.size() > 0}">
		<p class = "msg">${cart.size()}種類の商品があります。</p>
	</c:when>
	<c:otherwise>
		<p class = "msg">カートに商品がありません。</p>
	</c:otherwise>
</c:choose>

<br>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>
</body>
</html>