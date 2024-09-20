import java.util.*;

public class Calculator {

    Float stored_value;

    public Float divide(Float num1, Float num2) {
        return num1 / num2;
    }
    public Float multiply(Float num1, Float num2) {
        return num1 * num2;
    }
    public Float add(Float num1, Float num2) {
        return num1 + num2;
    }
    public Float subtract(Float num1, Float num2) {
        return num1 - num2;
    }
    public Float modulo(Float num1, Float num2) {
        return num1 % num2;
    }
    public void store(Float result) {
        this.stored_value = result;
        System.out.println("Value stored: " + this.stored_value);
    }
    public Float retrieve() {
        return this.stored_value;
    }
    void clear() {
        this.stored_value = (float) 0;
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        Scanner in = new Scanner(System.in);
        float result = 0;
        do {
            System.out.println("1: Add\n2: Subtract\n3: Divide\n4: Multiply\n5: Modulo\n6: Store\n7:Retrieve\n8:Clear\n9:Exit\n");
            System.out.println("Enter num: ");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Enter number 1: ");
                Float num1 = in.nextFloat();
                System.out.println("Enter number 2: ");
                Float num2 = in.nextFloat();
                result = calculator.add(num1, num2);
                System.out.println(result + "\n");
            } else if (choice == 2) {
                System.out.println("Enter number 1: ");
                Float num1 = in.nextFloat();
                System.out.println("Enter number 2: ");
                Float num2 = in.nextFloat();
                result = calculator.subtract(num1, num2);
                System.out.println(result + "\n");
            } else if (choice == 3) {
                System.out.println("Enter number 1: ");
                Float num1 = in.nextFloat();
                System.out.println("Enter number 2: ");
                Float num2 = in.nextFloat();
                result = calculator.divide(num1, num2);
                System.out.println(result + "\n");
            } else if (choice == 4) {
                System.out.println("Enter number 1: ");
                Float num1 = in.nextFloat();
                System.out.println("Enter number 2: ");
                Float num2 = in.nextFloat();
                result = calculator.multiply(num1, num2);
                System.out.println(result + "\n");
            } else if (choice == 5) {
                System.out.println("Enter number 1: ");
                Float num1 = in.nextFloat();
                System.out.println("Enter number 2: ");
                Float num2 = in.nextFloat();
                result = calculator.modulo(num1, num2);
                System.out.println(result + "\n");
            } else if (choice == 6) {
                calculator.store(result);
            } else if (choice == 7) {
                System.out.println(calculator.retrieve() + "\n");
            } else if (choice == 8) {
                calculator.clear();
            } else if (choice == 9) {
                break;
            }
        } while (true);
    }
}