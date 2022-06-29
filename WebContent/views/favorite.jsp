<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐お気に入り</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/itemAll.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/img.css" rel = "stylesheet" media = "all">
</head>
<body>

<div class = "center"><h1>お気に入り</h1></div>
<h5>${welcome}</h5>

<p class = "msg">${msg}</p>
<p class = "erroe">${errmsg}</p>
<p>
<c:if test="${empty welcome }">
<input type = "submit" name = "home" value = "ログイン" form = "login" class = "button">　　
</c:if>
<input type="submit" name = "product" value = "商品一覧へ" class="button" form = "product">　　
<input type = "submit" name = "getCart" value = "カート" form = "cart" class = "button">　　
<input type = "submit" name = "purchase" value = "購入方法" form = "purchase" class = "button">　　
<input type = "submit" name = "logout" value = "ログアウト" form = "logout" class = "button">

</p>
<form action="../servlets/getItem" method = "post" id = "product"></form>
<form action="../servlets/transition" method = "post" id = "login"></form>
<form action="../servlets/logout" method = "post" id = "logout"></form>
<form action="../servlets/purchase" method = "post" id = "purchase"></form>
<form action="../servlets/cart" id = "cart" method = "post"></form>

<br>
<table>
	<c:forEach var = "p" items = "${favorite}">
		<tr>

		<th><div class = "name">${p.product_name}</div></th>
		<td>
		<div class = "image">
			<div class="big">
			<img src = "data:${p.contentType};base64,${p.base64String}" class = "img" name = "img" alt=""><br>
			</div>
			<a href="#modal${p.product_id }" class="button4">詳細</a>
		</div>
		</td>

		<td><div class = "price">値段 : ${p.price}円</div></td>

		<td>
		<div class = "price">
		<form action="../servlets/cart" id = "cart" method = "post">
		個数 :
		<select name = "amount" >
			<option value = "" selected="selected" disabled="disabled">
			<c:forEach var = "i" begin="1" end="15">
				<option value = "${i}">${i}</option>
			</c:forEach>
		</select><br>
		<input type = "hidden" name = "product_name" value = "${p.product_name}" >
		<input type = "submit" value = "カートに追加"  class = "buton3" name = "addCart" onClick="return Check()">
		</form>
		</div>
	</td>
		<td>
			<form action="../servlets/deleteFavorite" method="post">
			<input type = "hidden" name = "product_id" value = "${p.product_id}">
			<input type="hidden" name = "member_id" value = "${p.member_id}">
			<input type="hidden" name="product_name" value = "${p.product_name}">
			<input type="submit" name = "deleteFavorite" value = "お気に入りから削除"  class = "button4">
			</form>
		</td>

		</tr>
	</c:forEach>
</table>



<c:forEach var = "i" items = "${list}">
	<div id="modal${i.product_id}" class="overlays">
	<a class="cancel" href="#"></a>
	<div class="modals">
		<div class="cont">
			<p><img src = "data:${i.contentType};base64,${i.base64String}" class = "img2"  alt=""></p>
				<h2>${i.product_name}</h2>
				<p class = "modaal">${i.info}</p>
			<p class="close"><a href="#">×</a></p>
		</div>
	</div>
</div>
</c:forEach>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>

</body>
</html>