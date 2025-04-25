package Java_oops_Worksheet_1;

// Define the Shape class with a draw() method
abstract class Shape {
    abstract void draw();
}

// Extend Shape with Circle class and override draw() method
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Extend Shape with Square class and override draw() method
class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }
}

// Extend Shape with Triangle class and override draw() method
class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
}

// Main class to test the polymorphism
public class Q4_Drawing_App {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = {new Circle(), new Square(), new Triangle()};

        // Loop through the array and call draw() method on each shape
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
