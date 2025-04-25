package Java_oops_Worksheet_1;

// BasicCalculator class with a final method add()
class BasicCalculator {
    public final int add(int a, int b) {
        return a + b;
    }
}

// SmartCalculator class extending BasicCalculator
class SmartCalculator extends BasicCalculator {
    // Attempting to override the final method add() will result in a compilation error
    // @Override
    // public int add(int a, int b) {
    //     return a + b + 1; // This line will cause an error
    // }

    // New method subtract() in the subclass
    public int subtract(int a, int b) {
        return a - b;
    }
}

// Main class Q7_Calculator_Lockdown
public class Q7_Calculator_Lockdown {
    public static void main(String[] args) {
        SmartCalculator calculator = new SmartCalculator();
        System.out.println("Addition: " + calculator.add(5, 3)); // Output: Addition: 8
        System.out.println("Subtraction: " + calculator.subtract(5, 3)); // Output: Subtraction: 2
    }
}
