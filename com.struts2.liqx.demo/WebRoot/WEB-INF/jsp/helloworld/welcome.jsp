<%@page language="java" context="text/html; charset=UTF-8"%>
<#--this is a freemarker file and use it extend name as jsp is just convinient to edit file-->
<html>
<head>
 	<title>Login success!</title>
</head>
<body>
 		Login success! Welcome ${user}!
 		<table>
 		<#if books??><#--判断是否存在该变量-->
 		<#list books as blist>
 			<tr>${blist}</tr>
 		</#list>
 		</#if>
 		</table>
</body>
</html>