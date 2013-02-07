<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>Name Collector</title>
    <script type="text/javascript" src='<s:url value="/js/jquery-1.9.1.min.js" />'></script>
    <script type="text/javascript">
    var urlTestAjax = '<s:url action="TestAjax"/>';
    $(function(){
    	//alert('jquery is here');
    	$("#btnAjax").click(function(){
    		var formData = $('form:eq(0)').serialize();
    		$.ajax({
    			url : urlTestAjax,
    			data : formData,
    			//dataType : 'json',
    			dataType : 'text',
    			success:function(rsp){
    				//alert('ajax success');
    				$("#dvJson").text(rsp);
    			}
    		});
    	});
    });
    </script>
	</head>

	<body>
	    <hr>
		<h4>Enter your name so that we can customize a greeting just for you!</h4> 	
		<s:form action="HelloWorld" namespace="/chapterTwo">
	    	<s:textfield name="model.name" label="Your name"/>
	    	<s:textfield name="model.age" label="Your age"/>
	    	<s:textfield name="customGreeting" label="CustomGreeting"/>
	    	<s:submit/>
		</s:form>
	    <hr>
	    
	    <a href='<s:url action="Name" namespace="/chapterTwo" />'>Name Action</a> <br/>
	    <a href='<s:url action="AddImage" namespace="/chapterThree" />'>上传图片</a>
	    <hr>
	    <input id="btnAjax" type="button" value="测试struts2 ajax" />
	    <div style="border:solid 1px red;" id="dvJson">
	    
	    </div>
	</body>
	
</html>
