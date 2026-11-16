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

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getMake().equalsIgnoreCase(make.trim()) && vehicle.getModel().equalsIgnoreCase(model.trim())) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int year){
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory){
            if (vehicle.getYear() == year) {
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


}
