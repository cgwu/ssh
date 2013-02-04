package com.thinkinginjava.rtti;

public class TestStaticInitialization {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try {
	    // Class<A> a = (Class<A>)Class.forName("com.thinkinginjava.rtti.A");
	    Class<?> a = Class.forName("com.thinkinginjava.rtti.A");
	    System.out.println(a);
	    
	    Class<Integer> intClass = int.class;
	    System.out.println(intClass);
	    Class<Integer> integerClass = Integer.TYPE;
	    System.out.println(integerClass);
	    
	    System.out.println(intClass == integerClass);
	    
//	    intClass= double.class;	// Illegal
	    Class<?> genericClass = int.class;
	    System.out.println(genericClass);
	    genericClass = double.class;
	    System.out.println(genericClass);
	    
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

	// for (int i = 0; i < 5; i++) {
	// new A();
	// }

    }

}
