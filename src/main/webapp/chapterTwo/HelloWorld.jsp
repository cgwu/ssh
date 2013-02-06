<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
    <title>HelloWorld</title>
	</head>

	<body>
	
	  <!-- The property struts tag reads the value off the value stack.  In our case
	       the Struts 2 framework has automatically made the Java bean properties of
	       our action available to the result.  We just need to match the nomenclature
	       of our value paramater below with the Java Beans attribute name of our 
	       HelloWorld action.  
	  -->
	  <hr>
	    <h3>Custom Greeting Page</h3>      
        <h4><s:property value="customGreeting"/></h4>
        <h4>年龄 : <s:property value="model.age" /></h4>
        <s:if test="model.age<10">太小了吧!</s:if>
        <s:elseif test="model.age<30">年轻人啊</s:elseif>
        <s:else>老人家了</s:else>
      <hr>
      判断名字: 
      <s:if test="model.name == @wu.cg.demo.constant.Foo@USER_NAME">欢迎您主人,${model.name }</s:if>
      <s:else>不认识您: ${model.name }</s:else>
      
	</body>	
</html>
