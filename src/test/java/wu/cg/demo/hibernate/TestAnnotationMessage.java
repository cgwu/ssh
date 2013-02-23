package wu.cg.demo.hibernate;

import org.hibernate.Session;
import org.junit.Test;

import wu.cg.demo.hibernate.domain.AnnotationMessage;

public class TestAnnotationMessage {

    @Test
    public void test() {

	Session session = AnnotationHibernateUtil.getSessionFactory()
		.getCurrentSession();
	session.beginTransaction();

	// Event theEvent = new Event();
	// theEvent.setTitle(title);
	// theEvent.setDate(theDate);

	AnnotationMessage msg = new AnnotationMessage();
	// msg.setId(1L);
	msg.setText("Annotation我是中国人!@#");

	AnnotationMessage msg2 = new AnnotationMessage();
	msg2.setText("2的下一个AnnotationMessage");
	msg2.setNextMessage(msg);

	session.save(msg);
	session.save(msg2);

	session.getTransaction().commit();

	System.out.println("完成");

    }

}
