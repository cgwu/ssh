<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Portfolio Creation</title>
    <s:head/>
	</head>

	<body>
		<h4>Complete and submit the form to add another portfolio to your account.</h4> 
		<s:form action="CreatePortfolio">
    	  <s:textfield name="name" label="Portfolio Name"/>
    	  <s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
