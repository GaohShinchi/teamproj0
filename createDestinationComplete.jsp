<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 3秒後に移動、HTML -->
<meta http-equiv="refresh"content="3; url='SettlementConfirmAction'">

<!-- css部分「共通・個別」 -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/form.css">

<title>宛先情報入力完了</title>
</head>

<body>

<!-- ヘッダー部 -->
<jsp:include page="header.jsp" />

<!-- メイン -->
	<div id="main">

<!-- トップ部 -->
		<div id="top">
			<h1>宛先情報入力完了画面</h1>
		</div>

<!-- 中身 -->
		<div class="complete_box">
			<p>宛先情報入力が完了しました。</p>
		</div>
	</div>

</body>
</html>