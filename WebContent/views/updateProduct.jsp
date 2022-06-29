<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐商品情報更新</title>
<link href = "/ShoppingSite/css/layoutAdmin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/adminHome.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/img.css" rel = "stylesheet" media = "all">

</head>
<body>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>商品情報更新</h1><h5 class = msg>${loginmsg}</h5>
<p class = "error">${errmsg}</p>
<c:if test="${not empty success }"><p>${success} [${product.product_name}]</p></c:if>
<c:if test="${not empty success }">
</c:if>

<form action="../servlets/changeProduct" method = "post" enctype="multipart/form-data" >
<table>
	<tr>
		<c:choose>
			<c:when test="${not empty product}">
				<th>商品番号 :</th>
					<td class = "left">
					<input type = "text" class = "short_input" value = "${product.product_id}" disabled="disabled">
					<input type = "submit"  name = "clear" value = "クリア" >
					</td>
			</c:when>
		<c:otherwise>
			<th>商品番号 :</th>
			<td class = "left">
				<input type = "text" name = "product_id" class = "short_input"  value = "${product_id}" >
				<input type = "submit"  name = "search" value = "検索" >
			</td>
		</c:otherwise>
	</c:choose>
	</tr>
</table>

<table>
	<c:choose>
		<c:when test="${empty product}">
		<tr>
			<th>商品名 : </th>
				<td><input type = "text" maxlength="15" name = "product_name" class = "input" value = "${product.product_name}" disabled="disabled"></td>
		</tr>
		<tr>
			<th>値段 :</th>
				<td><input type = "number" min="0" step="500" maxlength="10" name = "price"  class = "short_input" value = "${product.price}" disabled="disabled"></td>
				<td>円</td>
		</tr>
		<tr>
			<th>個数 : </th>
				<td>
				<select name = "amount"  class = "veryshort_input" disabled="disabled">
						<option value = "" selected="selected" disabled="disabled"></option>
					<c:forEach var = "i" step="10" begin="0" end="300">
						<option value = "${i}">${i}</option>
					</c:forEach>
					<c:if test="${not empty product}">
						<option value = "${product.amount}" selected="selected">${product.amount}</option>
					</c:if>
				</select>
				</td>
		</tr>
		<tr>
			<th>商品説明 : </th>
				<td><textarea name = "info" rows = "5" cols="50"  disabled="disabled">${product.info}</textarea></td>
		</tr>

		<tr>
			<th>画像 : </th>
				<td><input type = "file" name = "image" disabled="disabled"></td>
		</tr>
		</c:when>
		<c:otherwise>
		<tr>
			<th>商品名 : </th>
				<td><input type = "text" maxlength="15" name = "product_name" class = "input" value = "${product.product_name}"></td>
		</tr>
		<tr>
			<th>値段 :</th>
				<td><input type = "number" min="0" step="500" maxlength="10" name = "price"  class = "short_input" value = "${product.price}"></td>
				<td>円</td>
		</tr>
		<tr>
			<th>個数 : </th>
				<td>
				<select name = "amount"  class = "veryshort_input">
						<option value = "" selected="selected" disabled="disabled"></option>
					<c:forEach var = "i" step="10" begin="0" end="500">
						<option value = "${i}">${i}</option>
					</c:forEach>
					<c:if test="${not empty product}">
						<option value = "${product.amount}" selected="selected">${product.amount}</option>
					</c:if>
				</select>
				</td>
		</tr>
		<tr>
			<th>商品説明 : </th>
				<td><textarea name = "info" rows = "5" cols="50" >${product.info}</textarea></td>
		</tr>

		<tr>
			<th>画像 : </th>
				<td><input type = "file" name = "image"></td>
		</tr>
		</c:otherwise>
	</c:choose>
</table>
	<input type ="hidden" name = "product_id" value = "${product.product_id}" >
	<input type = "submit" name = "adminHome" value = "戻る" form = "back" class = "button">　　　　　　　
	<input type = "submit" name = "update_product" value = "商品情報変更" class = "button" onClick="return Check()">
</form>


<form action="../servlets/transition" id = "back" method = "post"></form>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>
</body>
</html>