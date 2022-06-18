public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.performOperations(10.5);

        calculator.performOperations("+");

        calculator.performOperations(5.2);

        calculator.performOperations("*");

        calculator.performOperations(10);

        calculator.performOperations("=");

        calculator.getResults();

    }
}
