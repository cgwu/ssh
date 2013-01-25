package wu.cg.demo.spring;

public class MessageCommunicator {
    public String name;

    public void deliver(String message) {
	System.out.println(message);
    }

    public void deliver(String person, String message) {
	System.out.println(person + ", " + message);
    }

    public int add(int a, int b) {
	System.out.println("a=" + a + ",b=" + b);
	return a + b;
    }
}
