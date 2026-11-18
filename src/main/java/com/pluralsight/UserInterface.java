package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
    private Scanner scanner = new Scanner(System.in);

    public void display(){
        init();
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
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> {
                    return;
                }
                default -> System.out.println("\nInvalid option\n");
            }
        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Minimum price: ");
        BigDecimal min = new BigDecimal(scanner.nextLine());

        System.out.print("Maximum price: ");
        BigDecimal max = new BigDecimal(scanner.nextLine());

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByPrice(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByMakeModel(make, model);

        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());


        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByYear(year);

        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByColor(color);

        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.print("Minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByMileRange(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Vehicle type: ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> vehicles =
                dealership.getVehiclesByType(type);

        displayVehicles(vehicles);
    }

    private void processGetAllVehiclesRequest() {
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle);
        }
    }

    private void processAddVehicleRequest() {
        System.out.print("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Mileage: ");
        int mileage = Integer.parseInt(scanner.nextLine());

        System.out.print("Price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        Vehicle vehicle = new Vehicle(
                vin,
                year,
                make,
                model,
                type,
                color,
                mileage,
                price
        );

        dealership.addVehicle(vehicle);

        DealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully.");
    }

    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        dealership.removeVehicle(vehicleToRemove);

        DealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle removed successfully.");
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No matching vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}


