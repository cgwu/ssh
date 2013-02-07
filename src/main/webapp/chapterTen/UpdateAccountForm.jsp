<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Portfolio Account Update</title>
    <s:head/>
	</head>

	<body>
		<h4>Please edit your account. </h4> 
		<s:form action="UpdateAccount">
    	  <s:label key="user.username" />
    	  <s:hidden name="user.username" />
    	  <s:hidden name="id" />
     	  <s:textfield name="user.firstName" label="First Name" />
     	  <s:textfield name="user.lastName" label="Last Name" />
    	  <s:password name="user.password" label="Password" showPassword="true"/>
    	  <s:textfield name="user.email" label="Email Address"/>
     	  <s:checkbox name="user.receiveJunkMail"  label="Do you want to receive junk mail?" />
    	  <s:submit/>
		</s:form>	 
		
	</body>
	
</html>
