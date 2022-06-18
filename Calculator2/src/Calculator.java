import java.util.ArrayList;

public class Calculator {
    //Array list for all the operators
    ArrayList<String> operators = new ArrayList<String>();
    //Array list for all the numbers
    ArrayList<Double> operands = new ArrayList<Double>();
    Double result;

    public Calculator() {
    }

    // fill the array list of numbers
    public void performOperations(double num) {
        operands.add( num);
    }

    public void performOperations(String operator) {
        if (operator != "=") {
            operators.add(operator);
        } else {
            Double start = operands.get(operands.size() - 1);
            for (int i = operators.size() - 1; i >= 0; i--) {
                switch (operators.get(i)) {
                    case "+":
                        start = start + operands.get(i);
                        break;
                    case "-":
                        start = start - operands.get(i);
                        break;
                    case "*":
                        start = start * operands.get(i);
                        break;
                    case "/":
                        start = start / operands.get(i);
                        break;
                    default:
                        System.out.println("Invalid operator.");
                        break;
                }
            }
            result = start;
        }
    }
    public void getResults(){
        System.out.println(this.result);
    }
}