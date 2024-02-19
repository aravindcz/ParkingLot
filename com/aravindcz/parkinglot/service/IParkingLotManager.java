package com.aravindcz.parkinglot.service;

import java.util.HashSet;

public interface IParkingLotManager {

    void createParkingLot(int lotSize);

    void deleteParkingLot();

    void park(String registrationNumber, String colour);

    void leave(int slotNumber);

    void status();

    void getRegistrationNumbersOfColour(String colour);

    void getSlotNumberOfRegistrationNumber(String registrationNumber);

    void getSlotNumbesOfColour(String colour);
}

