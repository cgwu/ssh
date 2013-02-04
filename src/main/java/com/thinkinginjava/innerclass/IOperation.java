package com.thinkinginjava.innerclass;

public abstract class IOperation {
    protected int x;
    protected int y;

    public IOperation(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public abstract int result();
}
