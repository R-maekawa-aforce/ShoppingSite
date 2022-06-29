<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐購入完了</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/regist.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/img.css" rel = "stylesheet" media = "all">
</head>
<body>
<h1>購入確定</h1>
<h5>${welcome}</h5>

<form action="../servlets/logout" method = "post">
<input type = "submit"  value = "商品トップへ"  name = "product" class = "button" form = "removeCart">　　　　
<input type = "submit" name = "logout" value = "ログアウト"  class = "button">
</form>
<form action="../servlets/removeCart" method = "post" id = "removeCart"></form>

<section>
<p>ご購入いただきありがとうございました。<br>またのご利用お待ちしてます。</p>
</section>

<section>
<p>お買い上げ項目</p>
<table class = "table">
	<c:forEach var = "c" items = "${cart}">
	<tr class = "tr">
		<td class = "td">${c.productBean.product_name}</td>
		<td class = "td">値段 : ${c.productBean.price}円</td>
		<td class = "td">個数 : ${c.count}個</td>
		<td class = "td">小計 : ${c.semiTotal}</td>

	</tr>
	</c:forEach>
</table>
<br>
<p>お買い上げ内容</p>
<table class = "table">
	<tr>
		<th class = "th">お買い上げ金額 : </th><td class = "td">${sum}円</td>
	</tr>
	<tr>
		<th class = "th">お支払い方法 : </th><td class = "td">${information[4]}</td>
	</tr>
	<tr>
		<th class = "th">配送方法 : </th><td class = "td">${information[5]}<td>
	</tr>
	<tr>
		<th class = "th">配送先郵便番号 : </th><td class = "td">〒${information[0]}</td>
	</tr>
	<tr>
		<th class = "th">住所 : </th><td class = "td">${information[1]}${information[2]}${information[3]}</td>
	</tr>
</table>
<br>
</section>

</body>
</html>