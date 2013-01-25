package wu.cg.demo.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void test() {
	ApplicationContext context = new ClassPathXmlApplicationContext(
		"spring/aop.xml");
	MessageCommunicator communicator = context.getBean("communicator",
		MessageCommunicator.class);

//	 communicator.deliver("Hello","cg");
	
	int i = communicator.add(1, 2);
	System.out.println(i);
    }

}
