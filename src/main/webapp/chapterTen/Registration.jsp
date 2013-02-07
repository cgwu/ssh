<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Portfolio Registration</title>
    <s:head/>
	</head>

	<body>
		<h4>Complete and submit the form to create your own portfolio.</h4> 
		<s:actionerror />
		<s:form action="Register">
    	  <s:textfield name="username" label="Username"/>
    	  <s:password name="password" label="Password"/>
    	  <s:textfield name="firstName" label="First Name"/>
    	  <s:textfield name="lastName" label="Last Name"/>
     	  <s:textfield name="portfolioName" label="Enter a name for your portfolio"/>  	
     	  <s:textfield name="email" label="Email"/>  	
    	  <s:checkbox name="receiveJunkMail" fieldValue="true" label="Check to receive junk mail"/>
    	  <s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
