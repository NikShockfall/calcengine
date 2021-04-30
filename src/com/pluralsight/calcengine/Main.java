package com.pluralsight.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0){
            performCalculations();

        } else if(args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if(args.length == 3)
            performOperation(args);
        else{
            System.out.println("Please provide an operation code and 2 numeric values.");
            executeInteractively();
        }
    }

    static void performCalculations(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m',11.0d, 3.0d);

        for(MathEquation equation : equations){
            equation.execute();
            displayResult(equation);
        }
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts){
        char opCode = opCodeFromString(parts[0]);

        if(opCode == 'w')
            handleWhen(parts);
        else{
            double leftVal = valueFromWord(parts[1]);
            double rightVal = valueFromWord(parts[2]);
            //double result = execute(opCode, leftVal, rightVal);
            MathEquation equation = new MathEquation(opCode, leftVal, rightVal);
            equation.execute();
            displayResult(equation);

        }
    }

    private static void handleWhen(String[] parts){
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void displayResult(MathEquation eq){
        displayResult(eq.getOpCode(), eq.getLeftVal(), eq.getRightVal(), eq.result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);

        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode){
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';

        for(int index = 0; index < opCodes.length; index++){
            if(opCode == opCodes[index]){
                return symbols[index];
            }
        }

        return symbol;
    }


    static char opCodeFromString(String operationName){
        return operationName.charAt(0);
    }

    static double valueFromWord(String word){
        String[] numberWords = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty"};
        double value = -1d;

        int index = 0;
        for(String str : numberWords){
            if(word.equals(str)){
                value = index;
                break;
            } else index++;
        }

        if(value == -1d)
            value = Double.parseDouble(word);

        return value;
    }
}
