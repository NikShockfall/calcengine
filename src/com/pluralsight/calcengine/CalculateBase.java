package com.pluralsight.calcengine;

public abstract class CalculateBase {
    private double leftVal;
    private double rightVal;
    private double result;

    public CalculateBase() {}

    public CalculateBase(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
    }

    public void setLeftVal(double leftVal) { this.leftVal = leftVal; }
    public void setRightVal(double rightVal) { this.rightVal = rightVal; }
    public void setResult(double result) { this.result = result; }

    public double getLeftVal() { return this.leftVal; }
    public double getRightVal() { return this.rightVal; }
    public double getResult() { return this.result; }

    public abstract void calculate();
}
