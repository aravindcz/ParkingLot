package com.aravindcz.parkinglot.service;



import com.aravindcz.parkinglot.model.Car;
import com.aravindcz.parkinglot.model.MinHeap;
import com.aravindcz.parkinglot.model.ParkingSlot;

import java.util.*;

public class ParkingLotManager implements IParkingLotManager {
    private List<ParkingSlot> parkingSlotList;
    private MinHeap nearestParkingSlot;
    private Map<String, HashSet<String>> colourRegistrationNumberMap;
    private Map<String, String> registrationNumberSlotMap;
    private Map<String, HashSet<String>> colourSlotNumberMap;

    public ParkingLotManager() {
        this.parkingSlotList = new ArrayList<>();
        this.nearestParkingSlot = null;
        this.colourRegistrationNumberMap = new HashMap<>();
        this.registrationNumberSlotMap = new HashMap<>();
        this.colourSlotNumberMap = new HashMap<>();
    }

    public void createParkingLot(int lotSize) {
        if (nearestParkingSlot != null) {
            System.out.println("A parking lot is currently in use, use delete_parking_lot and then create it again");
            return;
        }

        parkingSlotList = new ArrayList<>(lotSize);
        nearestParkingSlot = new MinHeap(lotSize);

        colourRegistrationNumberMap.clear();
        registrationNumberSlotMap.clear();
        colourSlotNumberMap.clear();

        System.out.println("Created a parking lot with " + lotSize + " slots");
    }

    public void deleteParkingLot() {
        parkingSlotList = null;
        nearestParkingSlot = null;
        colourRegistrationNumberMap.clear();
        registrationNumberSlotMap.clear();
        colourSlotNumberMap.clear();
        System.out.println("Parking lot successfully deleted");
    }

    public void park(String registrationNumber, String colour) {
        if (parkingSlotList == null) {
            System.out.println("No parking lot created. Please create a parking lot first.");
            return;
        }

        if (nearestParkingSlot.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }

        int slotNumber = nearestParkingSlot.poll();
        ParkingSlot parkingSlot = new ParkingSlot(new Car(registrationNumber, colour));
        parkingSlotList.add(slotNumber, parkingSlot);

        updateMapsOnParking(slotNumber, registrationNumber, colour);

        System.out.println("Allocated slot number: " + (slotNumber + 1));
    }

    private void updateMapsOnParking(int slotNumber, String registrationNumber, String colour) {
        registrationNumberSlotMap.put(registrationNumber, String.valueOf(slotNumber + 1));

        colourRegistrationNumberMap.computeIfAbsent(colour, k -> new HashSet<>()).add(registrationNumber);

        colourSlotNumberMap.computeIfAbsent(colour, k -> new HashSet<>()).add(String.valueOf(slotNumber + 1));
    }

    public void leave(int slotNumber) {
        if (parkingSlotList == null) {
            System.out.println("No parking lot created. Please create a parking lot first.");
            return;
        }

        if (slotNumber < 1 || slotNumber > parkingSlotList.size()) {
            System.out.println("Invalid slot number");
            return;
        }

        if (parkingSlotList.get(slotNumber - 1) == null) {
            System.out.println("Slot number " + slotNumber + " is already free");
            return;
        }

        Car leavingCar = parkingSlotList.get(slotNumber - 1).getCar();
        nearestParkingSlot.add(slotNumber - 1);
        parkingSlotList.set(slotNumber - 1, null);

        updateMapsOnLeaving(leavingCar, slotNumber);

        System.out.println("Slot number " + slotNumber + " is free");
    }

    private void updateMapsOnLeaving(Car leavingCar, int slotNumber) {
        String registrationNumber = leavingCar.getRegistrationNumber();
        String colour = leavingCar.getColour();

        registrationNumberSlotMap.remove(registrationNumber);

        colourRegistrationNumberMap.get(colour).remove(registrationNumber);

        if (colourRegistrationNumberMap.get(colour).isEmpty()) {
            colourRegistrationNumberMap.remove(colour);
        }

        colourSlotNumberMap.get(colour).remove(String.valueOf(slotNumber));

        if (colourSlotNumberMap.get(colour).isEmpty()) {
            colourSlotNumberMap.remove(colour);
        }
    }

    public void status() {
        if (parkingSlotList == null) {
            System.out.println("No parking lot created. Please create a parking lot first.");
            return;
        }

        System.out.println("Slot No. Registration No Colour");
        for (int i = 0; i < parkingSlotList.size(); i++) {
            if (parkingSlotList.get(i) != null) {
                Car car = parkingSlotList.get(i).getCar();
                System.out.println((i + 1) + " " + car.getRegistrationNumber() + " " + car.getColour());
            }
        }
    }

    public void getRegistrationNumbersOfColour(String colour) {
        if (colourRegistrationNumberMap.containsKey(colour)) {
            HashSet<String> registrationNumbers = colourRegistrationNumberMap.get(colour);
            System.out.println(String.join(", ", registrationNumbers));
        } else {
            System.out.println("No cars found with colour " + colour);
        }
    }

    public void getSlotNumberOfRegistrationNumber(String registrationNumber) {
        if (registrationNumberSlotMap.containsKey(registrationNumber)) {
            String slotNumber = registrationNumberSlotMap.get(registrationNumber);
            System.out.println(registrationNumber + " " + slotNumber);
        } else {
            System.out.println("No car found with registration number " + registrationNumber);
        }
    }

    public void getSlotNumbesOfColour(String colour) {
        if (colourSlotNumberMap.containsKey(colour)) {
            HashSet<String> slotNumbers = colourSlotNumberMap.get(colour);
            System.out.println(colour + " " + String.join(", ", slotNumbers));
        } else {
            System.out.println("No cars found with colour " + colour);
        }
    }
}
