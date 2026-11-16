package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private BigDecimal price;


    // used to load transaction info from transactions.csv into the ledger array list
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.vehicleType = vehicleType;
        this.model = model;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
}
