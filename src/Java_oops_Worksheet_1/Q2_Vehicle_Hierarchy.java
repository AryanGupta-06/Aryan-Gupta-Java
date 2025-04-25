package Java_oops_Worksheet_1;

import java.util.Scanner;

abstract class Vehicle {
    private int speed;
    private int fuelCapacity;

    public Vehicle(int speed, int fuelCapacity) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    // Abstract method to be implemented by subclasses
    public abstract double getMileage();
}

class Car extends Vehicle {
    public Car(int speed, int fuelCapacity) {
        super(speed, fuelCapacity);
    }

    @Override
    public double getMileage() {
        // Formula to calculate mileage for Car
        return getSpeed() * 0.05 * getFuelCapacity();
    }
}

class Truck extends Vehicle {
    public Truck(int speed, int fuelCapacity) {
        super(speed, fuelCapacity);
    }

    @Override
    public double getMileage() {
        // Formula to calculate mileage for Truck
        return getSpeed() * 0.03 * getFuelCapacity();
    }
}

public class Q2_Vehicle_Hierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of vehicle (Car/Truck): ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter the speed of the vehicle: ");
        int speed = scanner.nextInt();

        System.out.print("Enter the fuel capacity of the vehicle: ");
        int fuelCapacity = scanner.nextInt();

        Vehicle vehicle;
        if (vehicleType.equalsIgnoreCase("Car")) {
            vehicle = new Car(speed, fuelCapacity);
        } else if (vehicleType.equalsIgnoreCase("Truck")) {
            vehicle = new Truck(speed, fuelCapacity);
        } else {
            System.out.println("Invalid vehicle type!");
            scanner.close();
            return;
        }

        System.out.println("The mileage of the " + vehicleType + " is " + vehicle.getMileage() + " km/l.");
        scanner.close();
    }
}
