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
	  <h5>Account Management</h5>
	 	
		<ul>
      <li><a href="<s:url action='LoginForm'/>">Login to an Existing Account</a></li>	
      <li><a href="<s:url action='Registration'/>">Create an Account</a></li>	
    </ul> 
	  <hr>
	</body>
	
</html>
