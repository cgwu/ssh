<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Select a Portfolio</title>
	</head>

	<body>
		<h5>Please select one of <s:property value="username"/> portfolios for viewing.</h5>
		<s:form action="ViewPortfolio" >
			<s:select name="portfolioName" list='portfolios' listKey="name" listValue="name" label="Select a portfolio" />  
			<s:hidden name="username"/>
			<s:submit value="View Portfolio"/>
      	</s:form>	
	</body>
	
</html>
