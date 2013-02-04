package com.thinkinginjava.innerclass;

public class OperationClient {

    static IOperation getAddOperator(int xx, int yy) {
	return new IOperation(xx, yy) {
	    @Override
	    public int result() {
		return x + y;
	    }
	};
    }

    static IOperation getMinusOperator(int xx, int yy) {
	return new IOperation(xx, yy) {
	    @Override
	    public int result() {
		return x - y;
	    }
	};
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	System.out.println(getAddOperator(1, 20).result());
	System.out.println(getMinusOperator(1, 20).result());
    }

}
