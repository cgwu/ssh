package wu.cg.demo.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import wu.cg.demo.hibernate.domain.Message;

public class TestMesasge {

    @Test
    public void test() {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();

	// Event theEvent = new Event();
	// theEvent.setTitle(title);
	// theEvent.setDate(theDate);
	Message msg = new Message();
	msg.setText("我是中国人!@#");
	

//	Message msgLoad = (Message)session.get(Message.class, 1L);
	
	Message msg2 = new Message();
	msg2.setText("2的下一个Message");
//	msg2.setNextMessage(msgLoad);
	msg2.setNextMessage(msg);
	
	session.save(msg);
	session.save(msg2);
	
	session.getTransaction().commit();
	
	System.out.println("完成");
    }

}
