<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Name Collector</title>
	</head>

	<body>
	    <hr>
		<h4>Enter your name so that we can customize a greeting just for you!</h4> 	
		<s:form action="HelloWorld" namespace="/chapterTwo">
	    	<s:textfield name="model.name" label="Your name"/>
	    	<s:textfield name="model.age" label="Your age"/>
    	<s:submit/>
		</s:form>
	    <hr>
	    
	    <a href='<s:url action="Name" namespace="/chapterTwo" />'>Name Action</a> <br/>
	    <a href='<s:url action="AddImage" namespace="/chapterThree" />'>上传图片</a>
	</body>
	
</html>
