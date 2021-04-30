package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal, rightVal;
    private char opCode;
    double result;

    void setLeftVal(double leftVal) { this.leftVal = leftVal; }
    void setRightVal(double rightVal) { this.rightVal = rightVal; }
    void setOpCode(char opCode) { this.opCode = opCode;}

    double getLeftVal() { return this.leftVal; }
    double getRightVal() { return this.rightVal; }
    char getOpCode() {  return this.opCode ;}

    MathEquation() {}

    MathEquation(char opCode){
        setOpCode(opCode);
    }

    MathEquation(char opCode, double leftVal, double rightVal){
        this(opCode);
        setLeftVal(leftVal);
        setRightVal(rightVal);
    }

    void execute(){
        switch (opCode) {
            case 'a':
                result =  leftVal + rightVal;
                break;
            case 's':
                result =  leftVal - rightVal;
                break;
            case 'm':
                result =  leftVal * rightVal;
                break;
            case 'd':
                result =  rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid operation code: " + opCode);
                result =  0.0d;
        }
    }
}
