package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal, rightVal;
    private char opCode;
    double result;

    private static int numberOfCalculations;
    private static  double sumOfResults = 0;

    public void setLeftVal(double leftVal) { this.leftVal = leftVal; }
    public void setRightVal(double rightVal) { this.rightVal = rightVal; }
    public void setOpCode(char opCode) { this.opCode = opCode;}

    public double getLeftVal() { return this.leftVal; }
    public double getRightVal() { return this.rightVal; }
    public char getOpCode() {  return this.opCode ;}
    public double getResult() { return this.result; }
    public static double getAverageResult() { return sumOfResults / numberOfCalculations; }


    MathEquation() {}

    MathEquation(char opCode){
        setOpCode(opCode);
    }

    MathEquation(char opCode, double leftVal, double rightVal){
        this(opCode);
        setLeftVal(leftVal);
        setRightVal(rightVal);
    }

    public void execute(){
        CalculateBase calculation = null;
        switch (opCode) {
            case 'a':
                calculation = new Adder(leftVal, rightVal);
                break;
            case 's':
                calculation =  new Subtracter(leftVal, rightVal);
                break;
            case 'm':
                calculation =  new Multiplier(leftVal, rightVal);
                break;
            case 'd':
                calculation = new Divider(leftVal, rightVal);
                break;
            default:
                System.out.println("Invalid operation code: " + opCode);
                result =  0.0d;
        }
        if(calculation != null) {
            result = calculation.getResult();
        }

        numberOfCalculations++;
        sumOfResults += result;
    }

    public void execute(double leftVal, double rightVal){
        setLeftVal(leftVal);
        setRightVal(rightVal);

        execute();
    }
    public void execute(int leftVal, int rightVal){
        setLeftVal(leftVal);
        setRightVal(rightVal);

        result = (int) result;
    }
}
