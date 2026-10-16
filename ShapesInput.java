import java.util.Scanner;

class Rectangle {
    double length, width;
    Rectangle(double l, double w) { length = l; width = w; }
    double area() { return length * width; }
}

class Circle {
    double radius;
    Circle(double r) { radius = r; }
    double area() { return Math.PI * radius * radius; }
}

class Cuboid {
    double length, width, height;
    Cuboid(double l, double w, double h) { length = l; width = w; height = h; }
    double area() { return 2 * (length * width + length * height + width * height); }
}

class Triangle {
    double base, height;
    Triangle(double b, double h) { base = b; height = h; }
    double area() { return 0.5 * base * height; }
}

public class ShapesInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Rectangle\n2. Circle\n3. Cuboid\n4. Triangle");
        System.out.print("Choose a shape: ");
        int choice = in.nextInt();

        if (choice == 1) {
            System.out.print("Enter length: ");
            double l = in.nextDouble();
            System.out.print("Enter width: ");
            double w = in.nextDouble();
            System.out.printf("Area = %.2f%n", new Rectangle(l, w).area());
        } else if (choice == 2) {
            System.out.print("Enter radius: ");
            double r = in.nextDouble();
            System.out.printf("Area = %.2f%n", new Circle(r).area());
        } else if (choice == 3) {
            System.out.print("Enter length: ");
            double l = in.nextDouble();
            System.out.print("Enter width: ");
            double w = in.nextDouble();
            System.out.print("Enter height: ");
            double h = in.nextDouble();
            System.out.printf("Surface area = %.2f%n", new Cuboid(l, w, h).area());
        } else if (choice == 4) {
            System.out.print("Enter base: ");
            double b = in.nextDouble();
            System.out.print("Enter height: ");
            double h = in.nextDouble();
            System.out.printf("Area = %.2f%n", new Triangle(b, h).area());
        } else {
            System.out.println("Invalid choice.");
        }
    }
}