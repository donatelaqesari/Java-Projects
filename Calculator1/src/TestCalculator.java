public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperandOne(10.0);
        calculator.setOperandTwo(5.2);
        calculator.setOperator('+');
        calculator.performOperations();
        calculator.getResults();
    }
}
