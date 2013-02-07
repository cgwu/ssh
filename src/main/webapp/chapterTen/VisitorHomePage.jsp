<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>PortfolioHomePage</title>
    <s:head/>
	</head>

	<body>
		<h4>Welcome to the Struts 2 Portfolio!</h4>
		
	
     <hr/>

	 
	  <h5>View a Portfolio  </h5>
	  
	  <s:form action="ViewPortfolioJSP" >
			<s:doubleselect name="username" list='users' listKey="username" listValue="username" doubleName="id"  doubleList="portfolios" doubleListKey="id" doubleListValue="name"  label="Select an artist and portfolio"  />  
			<s:submit value="View"/>
      </s:form>	
	
	  <hr/>
	  
	 

	</body>
	
</html>
