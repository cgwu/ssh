package wu.cg.demo.struts2.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyLogInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 9188816448918166609L;

    static Logger log = LoggerFactory.getLogger(MyLogInterceptor.class);
	    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        StringBuilder message = new StringBuilder(100);
        message.append("action [");
        String namespace = invocation.getProxy().getNamespace();
        if ((namespace != null) && (namespace.trim().length() > 0)) {
            message.append(namespace).append("/");
        }
        message.append(invocation.getProxy().getActionName());
        message.append("!");
        message.append(invocation.getProxy().getMethod());
        message.append("]");
        
        log.info("开始执行:{}", message);
        String result = invocation.invoke();
        log.info("结束执行:{}", message);
        
        return result;
    }

}
