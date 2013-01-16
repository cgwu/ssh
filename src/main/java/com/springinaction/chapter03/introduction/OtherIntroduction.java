package com.springinaction.chapter03.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class OtherIntroduction implements IntroductionInterceptor, IOther {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
	// 如果呼叫的方法来自IOther介面的定义
	if (implementsInterface(methodInvocation.getMethod()
		.getDeclaringClass())) {
	    // 呼叫执行额外加入的行为
	    return methodInvocation.getMethod().invoke(this,
		    methodInvocation.getArguments());
	} else {
	    return methodInvocation.proceed();
	}
    }

    // 是否实作自IOther介面
    public boolean implementsInterface(Class<?> clazz) {
	return clazz.isAssignableFrom(IOther.class);
    }

    public void doOther() {
	System.out.println("增加的职责。。。");

    }

}
