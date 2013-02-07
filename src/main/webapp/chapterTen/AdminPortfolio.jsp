<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Administrate Your Portfolio</title>
	</head>

	<body>
		<h4></h4>
		<ul>
     <li><a href="<s:url action='UpdateAccountForm'/>">Update your Account</a></li>	
     <li><a href="<s:url action='CreatePortfolioForm'/>">Add Another Portfolio</a></li>	
 	  </ul> 	
 	
 	<hr/>
    <s:form action="EditPortfolio" >
			<s:select name="id" list='user.portfolios' listKey="id" listValue="name" label="Select a portfolio to work with."  />  
			<s:submit value="View"/>
    </s:form>	
      
	</body>
	
</html>
