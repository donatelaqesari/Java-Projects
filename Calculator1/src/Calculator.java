public class Calculator {

    private char operator;
    private double operandOne;
    private double operandTwo;
    private double result;

    public Calculator() {
    }

    public void performOperations() {
        if (operator == '+') {
            result = operandOne + operandTwo;
        } else if (operator == '-') {
            result = operandOne - operandTwo;
        } else System.out.println("There is an error!");
    }

    public void getResults() {
        System.out.println(result);
    }

    // GETTERS AND SETTERS
    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }
}
