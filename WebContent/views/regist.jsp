<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐会員情報登録</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/regist.css" rel = "stylesheet" media = "all">
</head>
<body>

	<h1>会員情報登録</h1>

<p class = "error">${errmsg}</p>
<p class = "success">${success}</p>
<section class="allInput">
	<form action="../servlets/regist" method = "post">
	<table>
		<tr>
			<th>性 :</th>
			<td><input type = "text" name = "last_name" class = "short_input" maxlength="15" value = "${member.last_name}">
			名 :
			<input type = "text" name = "first_name" class = "short_input"  maxlength="15" value = "${member.first_name}"></td>
		</tr>
		<tr>
			<th>性別 : </th>
			<td class = "left">
				<c:choose>
				<c:when test="${member.sex =='男'}">
					<input type = "radio" name = "sex" value = "男" class = "radio" id = "male" checked="checked">
					<label for = "male">男</label>
					<input type = "radio" name = "sex" value = "女" class = "radio" id = "female">
					<label for = "female">女</label>
				</c:when>
				<c:when test="${member.sex =='女'}">
					<input type = "radio" name = "sex" value = "男" class = "radio" id = "male" >
					<label for = "male">男</label>
					<input type = "radio" name = "sex" value = "女" class = "radio" id = "female" checked="checked">
					<label for = "female">女</label>
				</c:when>
				<c:otherwise>
					<input type = "radio" name = "sex" value = "男" class = "radio" id = "male">
					<label for = "male">男</label>
					<input type = "radio" name = "sex" value = "女" class = "radio" id = "female">
					<label for = "female">女</label>
				</c:otherwise>
				</c:choose>

			</td>
		</tr>
		<tr>
			<th>生年月日 : </th>
			<td>
				<div class = "form-select-wrap">
				<select name = "birth_year"  class = "birthday-year" >
					<option value = "" selected="selected" disabled="disabled" ></option>
						<c:if test="${not empty member.birth_year}">
							<option value = "${member.birth_year}" selected="selected">${member.birth_year}</option>
						</c:if>
				</select>年
				<select name = "birth_month"  class = "birthday-month">
					<option value = "" selected="selected" disabled="disabled"></option>
						<c:if test="${not empty member.birth_month}" >
							<option value = "${member.birth_month}" selected="selected">${member.birth_month}</option>
						</c:if>
				</select>月
				<select name = "birth_day"  class = "birthday-day">
					<option value = "" selected="selected" disabled="disabled"></option>
						<c:if test="${not empty member.birth_day}">
							<option value = "${member.birth_day}" selected="selected">${member.birth_day}</option>
						</c:if>
				</select>日
				</div>
			</td>
		</tr>
		<tr>
			<th>郵便番号 : </th>
			<td class = "left"><input type = "number"  max = "9999999" name = "post_code" class = "short_input" placeholder="0000000" value = "${member.post_code}"></td>
		</tr>
		<tr>
			<th>都道府県 : </th>
			<td class = "left"><input type = "text" maxlength="6" name = "prefectures" class = "short_input" value = "${member.prefectures}"></td>
		</tr>
		<tr>
			<th>市区町村 : </th>
			<td class = "left"><input type = "text" maxlength="15" name = "municipalities" class = "input" value = "${member.municipalities}"></td>
		</tr>
		<tr>
			<th>建物名 : </th>
			<td class = "left"><input type = "text" maxlength="15" name = "building" class = "input" value = "${member.building}"></td>
		</tr>
		<tr>
			<th>電話番号 : </th>
			<td class = "left"><input type = "tel" maxlength="11" name = "phone_number" class = "input" placeholder="000-0000-0000" value = "${member.phone_number}"></td>
		</tr>
		<tr>
			<th>メールアドレス : </th>
			<td class = "left"><input type = "email" maxlength="30" name = "mail_address" class = "input" placeholder="aaa@aaa.com" value = "${member.mail_address}"></td>
		</tr>
		<tr>
			<th>パスワード : </th>
			<td class = "left"><input type = "password" maxlength="30" name = "password" class = "input"></td>
		</tr>
	</table>

	<p>
		<input type = "submit" name = "home" value = "戻る" class = "button" form = "home">　　　　　
		<input type = "submit" name = "regist" value = "登録" class = "button"  onClick="return Check()">
	</p>
	</form>
	<br>
</section>
	<form action="../servlets/transition"  id = "home" method = "post"></form>

<script type = "text/javascript" src = "/ShoppingSite/js/datecreation.js"></script>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>
</body>
</html>