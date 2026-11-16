package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership = DealershipFileManager.getDealership();

    public void display(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1) Find vehicles within a price range");
            System.out.println("2) Find vehicles by make / model");
            System.out.println("3) Find vehicles by year range");
            System.out.println("4) Find vehicles by color");
            System.out.println("5) Find vehicles by mileage range");
            System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7) List ALL vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("99) Quit");
            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "1" -> dealership.getVehiclesByPrice();
                case "2" -> dealership.getVehiclesByMakeModel();
                case "3" -> dealership.getVehiclesByYear();
                case "4" -> dealership.getVehiclesByColor();
                case "5" -> dealership.getVehiclesByMileRange();
                case "6" -> dealership.getVehiclesByType();
                case "7" -> dealership.getAllVehicles();
                case "8" -> dealership.addVehicle();
                case "9" -> dealership.removeVehicle();
                case "99" -> {
                    return;
                }
                default -> {
                    System.out.println("\nInvalid option\n");
                    continue;
                }
            }
            break;
        }
    }
}


