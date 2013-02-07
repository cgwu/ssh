<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>PortfolioHomePage</title>
    <s:head/>
	</head>

	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4>
		
	  <hr>
		<h5>Are you a  <a href="<s:url action='VisitorHomePage'/>">visitor</a> or <a href="<s:url action='ArtistHomePage'/>">user</a> of Struts 2 Portfolio?</h5>		
	  <hr>
	  
</body>
	
</html>
