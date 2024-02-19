package com.aravindcz.parkinglot.model;


public class ParkingSlot {
    private Car car;

    public ParkingSlot(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
