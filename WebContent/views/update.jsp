<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>淀川カメラ‐会員情報更新</title>
<link href = "/ShoppingSite/css/layout.css" rel ="stylesheet" media="all">
<link href = "/ShoppingSite/css/button.css" rel = "stylesheet" media = "all">
<link href = "/ShoppingSite/css/regist.css" rel = "stylesheet" media = "all">
</head>
</head>
<body>

	<h1>会員情報更新</h1>

<p class = "error">${errmsg}</p>
<p class = "success">${success}</p>
<section class = "allInput">
	<form action="../servlets/update" method = "post" >
	<table>
	<tr>
		<c:choose>
			<c:when test="${not empty m}">
				<th>会員番号 : <br>パスワード :</th>
					<td class = "left">
					<input type = "text" class = "short_input" value = "${m.member_id}" disabled="disabled"><br>
					<input type = "password" maxlength="30" name = "password" class = "short_input" value = "${m.password}" disabled="disabled">
					<input type = "submit"  name = "clear" value = "クリア"  class = "button2">
					</td>
			</c:when>
		<c:otherwise>
			<th>会員番号 : <br>パスワード :</th>
			<td class = "left">
				<input type = "text" name = "member_id" class = "short_input" value = "${member_id}" ><br>
				<input type = "password" maxlength="30" name = "password" class = "short_input" value = "${password}">
				<input type = "submit"  name = "search" value = "検索"  class = "button2">
			</td>
		</c:otherwise>
	</c:choose>
	</tr>
	<tr><td>　　　</td></tr>

		<c:choose>
			<c:when test="${empty m}">
				<tr>
				<th>性 :</th>
				<td><input type = "text" name = "last_name" class = "short_input" maxlength="15" disabled="disabled"  value = "${m.last_name}">
				名 :
				<input type = "text" name = "first_name" class = "short_input"  maxlength="15" disabled="disabled" value = "${m.first_name}"></td>
			</tr>
			<tr>
				<th>性別 : </th>
				<td class = "left">
						<c:choose>
					<c:when test="${m.sex =='男'}">
						<input type = "radio" name = "sex" value = "男" class = "radio" id = "male" checked="checked" disabled="disabled">
						<label for = "male">男</label>
						<input type = "radio" name = "sex" value = "女" class = "radio" id = "female" disabled="disabled">
						<label for = "female">女</label>
					</c:when>
					<c:when test="${m.sex =='女'}">
						<input type = "radio" name = "sex" value = "男" class = "radio" id = "male"  disabled="disabled">
						<label for = "male">男</label>
						<input type = "radio" name = "sex" value = "女" class = "radio" id = "female" checked="checked" disabled="disabled">
						<label for = "female">女</label>
					</c:when>
					<c:otherwise>
						<input type = "radio" name = "sex" value = "男" class = "radio" id = "male" disabled="disabled">
						<label for = "male">男</label>
						<input type = "radio" name = "sex" value = "女" class = "radio" id = "female" disabled="disabled">
						<label for = "female">女</label>
					</c:otherwise>
					</c:choose>

				</td>
			</tr>
			<tr>
				<th>生年月日 : </th>
				<td>
					<div class = "form-select-wrap">
					<select name = "birth_year"  class = "birthday-year" disabled="disabled">
						<option value = "" selected="selected" disabled="disabled"></option>
							<c:if test="${not empty m.birth_year}">
								<option value = "${m.birth_year}" selected="selected">${m.birth_year}</option>
							</c:if>
					</select>年
					<select name = "birth_month"  class = "birthday-month" disabled="disabled">
						<option value = "" selected="selected" disabled="disabled"></option>
							<c:if test="${not empty m.birth_month}" >
								<option value = "${m.birth_month}" selected="selected">${m.birth_month}</option>
							</c:if>
					</select>月
					<select name = "birth_day"  class = "birthday-day" disabled="disabled">
						<option value = "" selected="selected" disabled="disabled"></option>
							<c:if test="${not empty m.birth_day}">
								<option value = "${m.birth_day}" selected="selected">${m.birth_day}</option>
							</c:if>
					</select>日
					</div>
				</td>
			</tr>
			<tr>
				<th>郵便番号 : </th>
				<td class = "left"><input type = "number"  max = "9999999" name = "post_code" class = "short_input" disabled="disabled" value = "${m.post_code}"></td>
			</tr>
			<tr>
				<th>都道府県 : </th>
				<td class = "left"><input type = "text" maxlength="6" name = "prefectures" class = "short_input" disabled="disabled" value = "${m.prefectures}"></td>
			</tr>
			<tr>
				<th>市区町村 : </th>
				<td class = "left"><input type = "text" maxlength="15" name = "municipalities" class = "input" disabled="disabled" value = "${m.municipalities}"></td>
			</tr>
			<tr>
				<th>建物名 : </th>
				<td class = "left"><input type = "text" maxlength="15" name = "building" class = "input" disabled="disabled" value = "${m.building}"></td>
			</tr>
			<tr>
				<th>電話番号 : </th>
				<td class = "left"><input type = "tel" maxlength="11" name = "phone_number" class = "input" disabled="disabled" value = "${m.phone_number}"></td>
			</tr>
			<tr>
				<th>メールアドレス : </th>
				<td class = "left"><input type = "email" maxlength="30" name = "mail_address" class = "input" disabled="disabled" value = "${m.mail_address}"></td>
			</tr>

			</c:when>
			<c:otherwise>
			<tr>
				<th>性 :</th>
				<td><input type = "text" name = "last_name" class = "short_input" maxlength="15" value = "${m.last_name}">
				名 :
				<input type = "text" name = "first_name" class = "short_input"  maxlength="15" value = "${m.first_name}"></td>
			</tr>
			<tr>
				<th>性別 : </th>
				<td class = "left">
					<c:choose>
					<c:when test="${m.sex =='男'}">
						<input type = "radio" name = "sex" value = "男" class = "radio" id = "male" checked="checked">
						<label for = "male">男</label>
						<input type = "radio" name = "sex" value = "女" class = "radio" id = "female">
						<label for = "female">女</label>
					</c:when>
					<c:when test="${m.sex =='女'}">
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
					<select name = "birth_year"  class = "birthday-year">
						<option value = "" selected="selected" disabled="disabled"></option>
							<c:if test="${not empty m.birth_year}">
								<option value = "${m.birth_year}" selected="selected">${m.birth_year}</option>
							</c:if>
					</select>年
					<select name = "birth_month"  class = "birthday-month">
						<option value = "" selected="selected" disabled="disabled"></option>
							<c:if test="${not empty m.birth_month}" >
								<option value = "${m.birth_month}" selected="selected">${m.birth_month}</option>
							</c:if>
					</select>月
					<select name = "birth_day"  class = "birthday-day">
						<option value = "" selected="selected" disabled="disabled"></option>
							<c:if test="${not empty m.birth_day}">
								<option value = "${m.birth_day}" selected="selected">${m.birth_day}</option>
							</c:if>
					</select>日
					</div>
				</td>
			</tr>
			<tr>
				<th>郵便番号 : </th>
				<td class = "left"><input type = "number"  max = "9999999" name = "post_code" class = "short_input" value = "${m.post_code}"></td>
			</tr>
			<tr>
				<th>都道府県 : </th>
				<td class = "left"><input type = "text" maxlength="6" name = "prefectures" class = "short_input" value = "${m.prefectures}"></td>
			</tr>
			<tr>
				<th>市区町村 : </th>
				<td class = "left"><input type = "text" maxlength="15" name = "municipalities" class = "input" value = "${m.municipalities}"></td>
			</tr>
			<tr>
				<th>建物名 : </th>
				<td class = "left"><input type = "text" maxlength="15" name = "building" class = "input" value = "${m.building}"></td>
			</tr>
			<tr>
				<th>電話番号 : </th>
				<td class = "left"><input type = "tel" maxlength="11" name = "phone_number" class = "input" value = "${m.phone_number}"></td>
			</tr>
			<tr>
				<th>メールアドレス : </th>
				<td class = "left"><input type = "email" maxlength="30" name = "mail_address" class = "input" value = "${m.mail_address}"></td>
			</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<p>
		<input type = "hidden" value = "${m.member_id}" name = "member_id">
		<input type = "hidden" value = "${m.password}" name = "password">
		<input type = "submit" name = "home" value = "戻る" class = "button" form = "home">　　　　　
		<input type = "submit" name = "update" value = "更新" class = "button"  onClick="return Check()">
	</p>
	</form>
	<br>
</section>
	<form action="../servlets/transition"  id = "home" method = "post"></form>

<script type = "text/javascript" src = "/ShoppingSite/js/datecreation.js"></script>
<script type="text/javascript" src = "/ShoppingSite/js/dialog.js"></script>
</body>
</html>