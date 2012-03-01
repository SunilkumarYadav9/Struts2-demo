<%@page language="java" contentType="text/html; charset=GBK"%>
<html>
<head>
	<title>Login page</title>
</head>
<body>
<!-- summit the request-->
<form action="LoginAction.action" method="post">
	<table align="center">
		<caption>Login page</caption>
		<tr>
			<td>Accound:</td><td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>password:</td><td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"/><input type="reset"/>
		</tr>
	</table>
</form>
</body>	
</html>