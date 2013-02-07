<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Edit Portfolio</title>
    <s:head/>
	</head>

	<body>
		<h4>Edit the <s:property value="portfolio.name"/> Portfolio</h4> 
	  <s:form action="UpdatePortfolio">
    	  <s:textfield name="portfolio.name" label="Portfolio Name"/>
    	  <s:hidden name="id" value="%{portfolio.id}"/>
        <s:submit/>
		</s:form>	
		<hr/>
		<ul>
		<s:url action='AddImage' id="addImage">
		   <s:param name="id" value="%{portfolio.id}"/> 
		</s:url>
		   <li><a href="<s:property value='addImage'/>">Add image to portfolio.</a></li>	
   </ul>
		
	</body>
	
</html>
