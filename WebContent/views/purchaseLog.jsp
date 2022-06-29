<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐購入履歴</title>
<link href = "/ShoppingSite/css/layoutAdmin.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/adminHome.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/log.css" rel = "stylesheet" media = "all">
</head>
<body>
<h1>購入履歴</h1><h5 class = msg>${loginmsg}</h5>
<p class = "error">${errmsg}</p>

<table>
<c:forEach var = "l" items = "${log}">
	<tr>

	<td class = "log">購入履歴 :
		<input type = "text" disabled="disabled" value = "${l.history_number}" class = "veryshort_input">
	</td>
	<td class = "log">会員番号 :
		<input type = "text" disabled="disabled" value = "${l.member_id}" class = "short_input2">
	</td>
	<td class = "log">商品ID :
		<input type = "text" disabled="disabled" value = "${l.product_id}" class = "veryshort_input">
	</td>
	<td class = "log">購入数 :
		<input type = "text" disabled="disabled" value = "${l.purchase_number}" class = "veryshort_input">
	</td>
	<td class = "log">購入金額 :
		<input type = "text" disabled="disabled" value = "${l.purchase_price}" class = "short_input2">
	</td>
	<td class = "log">購入日時 :
		<input type = "text" disabled="disabled" value = "${l.purchase_date}" >
	</td>

	</tr>
</c:forEach>
</table>
<br>

<form action="../servlets/transition" method = "post">
<input type = "submit" name = "adminHome" value = "戻る" class = "button">
</form>

</body>
</html>