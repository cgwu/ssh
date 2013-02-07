<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Login</title>
   	</head>

	<body>
		<h4>Enter your username and password to login to your portfolio.</h4> 
		<s:form action="Login">
    		<s:textfield key="username"/>
     		<s:password name="password" label="Password"/>
    		<s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
