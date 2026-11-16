package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DealershipFileManager {
    public static Dealership getDealership() {
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] dealershipParts = bufferedReader.readLine().split("\\|");
            Dealership dealership = new Dealership(dealershipParts[0], dealershipParts[1], dealershipParts[2]);

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                BigDecimal price = new BigDecimal(parts[7]);

                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(newVehicle);
            }
            return dealership;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveDealership(Dealership dealership){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv"));
            bufferedWriter.newLine();
            bufferedWriter.write(dealership.toString());
            for (Vehicle vehicle : dealership.getAllVehicles())
            bufferedWriter.write(vehicle.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
