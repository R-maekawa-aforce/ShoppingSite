<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐購入方法</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/regist.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/buy.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/img.css" rel = "stylesheet" media = "all">

</head>
<body>

<h1>購入方法</h1>
<h5>${welcome}</h5>
<p class = "error">${errmsg}</p>
<form action="../servlets/getItem" method = "post">
<input type = "submit"  value = "商品一覧"  name = "product" class = "button">　　
<input type = "submit" name = "getCart" value = "カート" form = "cart" class = "button">　　
<input type = "submit" name = "favorite" value = "お気に入り" form = "favorite" class = "button">　　
<input type = "submit" name = "logout" value = "ログアウト" form = "logout" class = "button">
</form>
<form action="../servlets/transition" method = "post" id = "login"></form>
<form action="../servlets/getFavorite" method = "post" id = "favorite"></form>
<form action="../servlets/logout" method = "post" id = "logout"></form>
<form action="../servlets/cart" id = "cart" method = "post"></form>
<br>

<table>
	<c:forEach var = "c" items = "${cart}">
	<tr class = "tr">
		<th><div class = "name">${c.productBean.product_name}</div></th>
		<td><div class = "image">
			<img src = "data:${c.productBean.contentType};base64,${c.productBean.base64String}" class = "img" name = "img">　
		</div></td>

		<td><div class = "price">値段 : ${c.productBean.price}円</div></td>
		<td><div class = "price">個数 : ${c.count}個</div> </td>
		<td><div class = "price">小計 : ${c.semiTotal}</div> </td>

	</tr>
	</c:forEach>
</table>
	<p class = "sum">合計金額 :${sum}円</p>

<form action = "../servlets/decide" method = "post">
<table class = "table">
	<tr>
		<th class = "head">お届け先住所</th>
	</tr>

	<tr>
		<th>郵便番号 : </th>
		<td class = "left"><input type = "number"  max="9999999" name = "postCode" class = "short_input" value = "${information[0]}">
	</tr>
	<tr>
		<th>都道府県 : </th>
		<td class = "left"><input type = "text" maxlength="6" name = "prefectures" class = "short_input" value = "${information[1]}"></td>
	</tr>
	<tr>
		<th>市区町村 : </th>
		<td class = "left"><input type = "text" maxlength="15" name = "municipalities" class = "input" value = "${information[2]}"></td>
	</tr>
	<tr>
		<th>建物名 : </th>
		<td class = "left"><input type = "text" maxlength="15" name = "building" class = "input" value = "${information[3]}"></td>
	</tr>

	<tr>
		<th>ご購入方法 : </th>
		<td>
			<c:choose>
			<c:when test="${information[4] == 'paypay'}">
				<input type="radio" name = "pay" value = "paypay"  checked="checked">payapy
				<input type="radio" name = "pay" value = "代金引換">代金引換
				<input type="radio" name = "pay" value = "キャリア決済">キャリア決済
				<input type="radio" name = "pay" value = "クレジット">クレジット
				<input type="radio" name = "pay" value = "銀行振込">銀行振込
			</c:when>
			<c:when test="${information[4] == '代金引換'}">
				<input type="radio" name = "pay" value = "paypay" >payapy
				<input type="radio" name = "pay" value = "代金引換"  checked="checked">代金引換
				<input type="radio" name = "pay" value = "キャリア決済">キャリア決済
				<input type="radio" name = "pay" value = "クレジット">クレジット
				<input type="radio" name = "pay" value = "銀行振込">銀行振込
			</c:when>
			<c:when test="${information[4] == 'キャリア決済'}">
				<input type="radio" name = "pay" value = "paypay" >payapy
				<input type="radio" name = "pay" value = "代金引換">代金引換
				<input type="radio" name = "pay" value = "キャリア決済"  checked="checked">キャリア決済
				<input type="radio" name = "pay" value = "クレジット">クレジット
				<input type="radio" name = "pay" value = "銀行振込">銀行振込
			</c:when>
			<c:when test="${information[4] == 'クレジット'}">
				<input type="radio" name = "pay" value = "paypay">payapy
				<input type="radio" name = "pay" value = "代金引換">代金引換
				<input type="radio" name = "pay" value = "キャリア決済">キャリア決済
				<input type="radio" name = "pay" value = "クレジット"   checked="checked">クレジット
				<input type="radio" name = "pay" value = "銀行振込">銀行振込
			</c:when>
			<c:when test="${information[4] == '銀行振込'}">
				<input type="radio" name = "pay" value = "paypay" >payapy
				<input type="radio" name = "pay" value = "代金引換">代金引換
				<input type="radio" name = "pay" value = "キャリア決済">キャリア決済
				<input type="radio" name = "pay" value = "クレジット">クレジット
				<input type="radio" name = "pay" value = "銀行振込" checked="checked">銀行振込
			</c:when>

			<c:otherwise>
				<input type="radio" name = "pay" value = "paypay" >payapy
				<input type="radio" name = "pay" value = "代金引換">代金引換
				<input type="radio" name = "pay" value = "キャリア決済">キャリア決済
				<input type="radio" name = "pay" value = "クレジット">クレジット
				<input type="radio" name = "pay" value = "銀行振込">銀行振込
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th>配送方法</th>
		<td>
			<c:choose>
			<c:when test="${information[5] == '山田運輸'}">
				<input type = "radio" name = "transport" value = "山田運輸" checked="checked">山田運輸
				<input type = "radio" name = "transport" value = "佐田急便">佐田急便
				<input type = "radio" name = "transport" value = "白猫運輸">白猫運輸
				<input type = "radio" name = "transport" value = "黒猫トランスポート">黒猫トランスポート
			</c:when>
			<c:when test="${information[5] == '佐田急便'}">
				<input type = "radio" name = "transport" value = "山田運輸" >山田運輸
				<input type = "radio" name = "transport" value = "佐田急便" checked="checked">佐田急便
				<input type = "radio" name = "transport" value = "白猫運輸">白猫運輸
				<input type = "radio" name = "transport" value = "黒猫トランスポート">黒猫トランスポート
			</c:when>
			<c:when test="${information[5] == '白猫運輸'}">
				<input type = "radio" name = "transport" value = "山田運輸" >山田運輸
				<input type = "radio" name = "transport" value = "佐田急便">佐田急便
				<input type = "radio" name = "transport" value = "白猫運輸" checked="checked">白猫運輸
				<input type = "radio" name = "transport" value = "黒猫トランスポート">黒猫トランスポート
			</c:when>
			<c:when test="${information[5] == '黒猫トランスポート'}">
				<input type = "radio" name = "transport" value = "山田運輸" >山田運輸
				<input type = "radio" name = "transport" value = "佐田急便">佐田急便
				<input type = "radio" name = "transport" value = "白猫運輸">白猫運輸
				<input type = "radio" name = "transport" value = "黒猫トランスポート" checked="checked">黒猫トランスポート
			</c:when>
			<c:otherwise>
				<input type = "radio" name = "transport" value = "山田運輸">山田運輸
				<input type = "radio" name = "transport" value = "佐田急便">佐田急便
				<input type = "radio" name = "transport" value = "白猫運輸">白猫運輸
				<input type = "radio" name = "transport" value = "黒猫トランスポート">黒猫トランスポート
			</c:otherwise>
			</c:choose>
		</td>
	</tr>

</table>

<br>
<input type = "submit" name = "decide" class = "button"  value = "購入" onClick="return Check()">
</form>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>

</body>
</html>