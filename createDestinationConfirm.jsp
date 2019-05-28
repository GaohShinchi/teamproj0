<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css部分「共通・個別」 -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">

<title>宛先情報入力確認</title>
</head>

<body>
<script type="text/javascript" src= "./js/createDestination.js"></script>

<!-- ヘッダー部 -->
<jsp:include page="header.jsp" />

<!-- メイン -->
	<div id="main">

<!-- トップ部 -->
		<div id="top">
			<h1>宛先情報入力確認画面</h1>
		</div>

<!-- 中身 -->

<!-- div class -->
<!-- 1.テーブル「tablelist」 -->
<!-- 2.ボタン部「btn」 -->
<!-- hiddenの初期値未入力 -->
<!-- btnを押下した場合それぞれのアクションへ -->
		<s:form id="createDestinationForm">
			<table class="T_box">
				<tr>
					<th><s:label value="姓" /></th>
					<td><s:property value="lname"/></td>
				</tr>
				<tr>
					<th><s:label value="名" /></th>
					<td><s:property value="fname"/></td>
				</tr>
				<tr>
					<th><s:label value="姓ふりがな" /></th>
					<td><s:property value="lnameKana"/></td>
				</tr>
				<tr>
					<th><s:label value="名ふりがな" /></th>
					<td><s:property value="fnameKana"/></td>
				</tr>
				<tr>
					<th><s:label value="住所" /></th>
					<td><s:property value="adds"/></td>
				</tr>
				<tr>
					<th><s:label value="電話番号" /></th>
					<td><s:property value="tell"/></td>
				</tr>
				<tr>
					<th><s:label value="メールアドレス" /></th>
					<td><s:property value="email"/></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<s:submit value="登録" class="btn" onclick="goCreateDestinationCompleteAction()"/>
				<s:submit value="戻る" class="btn" onclick="goCreateDestinationAction()"/>
			</div>
				<s:hidden id="keep_flag" name="keep_flag" value=""/>
		</s:form>

	</div>

</body>
</html>