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

<title>宛先情報入力画面</title>
</head>

<body>

<!-- ヘッダー部 -->
<jsp:include page="header.jsp" />

<!-- メイン -->
	<div id="main">

<!-- トップ部 -->
		<div id="top">
			<h1>宛先情報入力画面</h1>
		</div>

<!-- 中身 -->

<!-- testで試行する -->
<!-- 1.それぞれのエラーメッセージ(E)がnull状態ではない -->
<!-- 2.それぞれのエラーメッセージ(E)が0文字より多い -->
	<s:if test="lnameE != null && lnameE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="lnameE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="fnameE != null && fnameE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="fnameE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="lnameKanaE != null && lnameKanaE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="lnameKanaE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="fnameKanaE != null && fnameKanaE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="fnameKanaE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="addsE != null && addsE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="addsE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="tellE != null && tellE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="tellE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="emailE != null && emailE.size() > 0">
		<div class ="error_box">
			<div class="error-message">
				<s:iterator value="emailE"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
<!-- 宛先情報入力画面 -->

<!-- div class -->
<!-- 1.テーブル「tablelist」 -->
<!-- 2.ボタン部「btn」 -->
<!-- struts2の機能 -->
<!-- 1.textfieldでデータをActionに受け渡す -->
<!-- 2.#xxx.で呼び出す -->
		<s:form action="CreateDestinationConfirmAction">
			<table class = "T_box">
				<tr>
					<th scope="row"><s:label value="姓"/></th>
					<td><s:textfield name="lname" value="%{#session.lname}" placeholder="姓" class="txt" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="名"/></th>
					<td><s:textfield name="fname" value="%{#session.fname}" placeholder="名" class="txt" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="姓ふりがな"/></th>
					<td><s:textfield name="lnameKana" value="%{#session.lnameKana}" placeholder="姓ふりがな" class="txt" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="名ふりがな"/></th>
					<td><s:textfield name="fnameKana" value="%{#session.fnameKana}" placeholder="名ふりがな" class="txt" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="住所"/></th>
					<td><s:textfield name="adds" value="%{#session.adds}" placeholder="住所" class="txt" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="電話番号"/></th>
					<td><s:textfield name="tell" value="%{#session.tell}" placeholder="電話番号" class="txt" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="メールアドレス"/></th>
					<td><s:textfield name="email" value="%{#session.email}" placeholder="メールアドレス" class="txt" /></td>
				</tr>
				</table>
			<div class="submit_btn_box">
			<s:submit value="確認" class="btn" />
			</div>
		</s:form>
	</div>

</body>
</html>