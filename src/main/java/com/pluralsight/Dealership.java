package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileRange(int min, int max){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getMake().equalsIgnoreCase(make.trim()) && vehicle.getModel().equalsIgnoreCase(model.trim())) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear &&
                    vehicle.getYear() <= maxYear) {

                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    public String toString() {
        return String.format(
                "%s|%s|%s",
                name,
                address,
                phone
        );
    }

}
