import java.util.*;

public class Calculator {
    // Changed float to double to handle larger numbers and initializing to 0
    Double stored_value = 0.0;

    private double divide(double num1, double num2) {
        // adding check for division by 0
        if (num2 == 0) {
            System.out.println("Division by 0\n");
            return Double.NaN;
        }
        return num1 / num2;
    }
    private double multiply(double num1, double num2) {
        return num1 * num2;
    }
    private double add(double num1, double num2) {
        return num1 + num2;
    }
    private double subtract(double num1, double num2) {
        return num1 - num2;
    }
    private double modulo(double num1, double num2) {
        return num1 % num2;
    }
    private void store(double result) {
        // adding overflow/underflow check
        if (isOverflow(result)) {
            System.out.println("Previous result cannot be stored: Overflow\n");
        } else if (isUnderflow(result)) {
            System.out.println("Previous result cannot be stored: Underflow\n");
        } else {
            this.stored_value = result;
            System.out.println("Value stored: " + this.stored_value + "\n");
        }
    }
    private double retrieve() {
        // adding check for null value
        if (this.stored_value == null) {
            System.out.println("Stored value is null\n");
            return Double.NaN;
        }
        return this.stored_value;
    }
    private void clear() {
        this.stored_value = 0.0;
        System.out.println("Value cleared\n");
    }
    private boolean isOverflow(double num) {
        return num > Double.MAX_VALUE;
    }
    private boolean isUnderflow(double num) {
        return num < -Double.MAX_VALUE;
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        Scanner in = new Scanner(System.in);
        double result = 0;
        double num1 = 0, num2 = 0;
        do {
            System.out.println("1: Add\n2: Subtract\n3: Divide\n4: Multiply\n5: Modulo\n6: Store\n7: Retrieve\n8: Clear\n9: Exit\n");
            System.out.println("Enter num: ");
            // add input validation with try and catch
            try {
                int choice = in.nextInt();
                // if input is type int, verify that it is within the range 1-9
                if (choice < 1 || choice > 9) {
                    System.out.println("Invalid option\n");
                    continue;
                }
                // if operation selected is add, subtract, divide, multiply, or modulo, get values from user input
                if (choice < 6) {
                    System.out.println("Enter number 1: ");
                    num1 = in.nextDouble();
                    System.out.println("Enter number 2: ");
                    num2 = in.nextDouble();
                    // check input values for overflow or underflow
                    if (calculator.isOverflow(num1) || calculator.isOverflow(num2)) {
                        System.out.println("Invalid input: Overflow\n");
                        continue;
                    } else if (calculator.isUnderflow(num1) || calculator.isUnderflow(num2)) {
                        System.out.println("Invalid input: Underflow\n");
                        continue;
                    }
                }
                if (choice == 1) {
                    result = calculator.add(num1, num2);
                    if (calculator.isOverflow(result)) {
                        System.out.println("Overflow occurred\n");
                        continue;
                    } else if (calculator.isUnderflow(result)) {
                        System.out.println("Underflow occurred\n");
                        continue;
                    }
                    System.out.println(result + "\n");
                } else if (choice == 2) {
                    result = calculator.subtract(num1, num2);
                    if (calculator.isOverflow(result)) {
                        System.out.println("Overflow occurred\n");
                        continue;
                    } else if (calculator.isUnderflow(result)) {
                        System.out.println("Underflow occurred\n");
                        continue;
                    }
                    System.out.println(result + "\n");
                } else if (choice == 3) {
                    result = calculator.divide(num1, num2);
                    if (calculator.isOverflow(result)) {
                        System.out.println("Overflow occurred\n");
                        continue;
                    } else if (calculator.isUnderflow(result)) {
                        System.out.println("Underflow occurred\n");
                        continue;
                    }
                    System.out.println(result + "\n");
                } else if (choice == 4) {
                    result = calculator.multiply(num1, num2);
                    if (calculator.isOverflow(result)) {
                        System.out.println("Overflow occurred\n");
                        continue;
                    } else if (calculator.isUnderflow(result)) {
                        System.out.println("Underflow occurred\n");
                        continue;
                    }
                    System.out.println(result + "\n");
                } else if (choice == 5) {
                    result = calculator.modulo(num1, num2);
                    if (calculator.isOverflow(result)) {
                        System.out.println("Overflow occurred\n");
                        continue;
                    } else if (calculator.isUnderflow(result)) {
                        System.out.println("Underflow occurred\n");
                        continue;
                    }
                    System.out.println(result + "\n");
                } else if (choice == 6) {
                    calculator.store(result);
                } else if (choice == 7) {
                    System.out.println(calculator.retrieve() + "\n");
                } else if (choice == 8) {
                    calculator.clear();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input\n");
                in.next();
            }
        } while(true);
        in.close(); // closing scanner
    }
}