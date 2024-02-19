package com.aravindcz.parkinglot;


import com.aravindcz.parkinglot.service.IParkingLotManager;

import java.util.Scanner;

public class ParkingLotCommandProcessor {

    private final IParkingLotManager parkingLotManager;

    public ParkingLotCommandProcessor(IParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public void processCommands() {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            printCommandOptions();
            command = scanner.nextLine();
            processCommand(command);
        } while (!command.equalsIgnoreCase("exit"));
    }

    private void printCommandOptions() {
        System.out.println("Command Options:");
        System.out.println("1. create_parking_lot lot_size");
        System.out.println("2. delete_parking_lot");
        System.out.println("3. park registration_number colour");
        System.out.println("4. leave slot_number");
        System.out.println("5. status");
        System.out.println("6. registration_numbers_for_cars_with_colour colour");
        System.out.println("7. slot_number_for_car_with_registration_number registration_number");
        System.out.println("8. slot_numbers_for_cars_with_colour colour");
        System.out.println("9. exit");
    }

    private void processCommand(String command) {
        String[] commandParts = command.split(" ");
        String operation = commandParts[0].toLowerCase();

        switch (operation) {
            case "create_parking_lot":
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please provide the lot size.");
                    break;
                }
                int lotSize = Integer.parseInt(commandParts[1]);
                parkingLotManager.createParkingLot(lotSize);
                break;

            case "delete_parking_lot":
                parkingLotManager.deleteParkingLot();
                break;

            case "park":
                if (commandParts.length != 3) {
                    System.out.println("Invalid command. Please provide registration number and colour.");
                    break;
                }
                String registrationNumber = commandParts[1];
                String colour = commandParts[2];
                parkingLotManager.park(registrationNumber, colour);
                break;

            case "leave":
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please provide slot number.");
                    break;
                }
                int slotNumber = Integer.parseInt(commandParts[1]);
                parkingLotManager.leave(slotNumber);
                break;

            case "status":
                parkingLotManager.status();
                break;

            case "registration_numbers_for_cars_with_colour":
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please provide colour.");
                    break;
                }
                String colourForRegNum = commandParts[1];
                parkingLotManager.getRegistrationNumbersOfColour(colourForRegNum);
                break;

            case "slot_number_for_car_with_registration_number":
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please provide registration number.");
                    break;
                }
                String regNumForSlot = commandParts[1];
                parkingLotManager.getSlotNumberOfRegistrationNumber(regNumForSlot);
                break;

            case "slot_numbers_for_cars_with_colour":
                if (commandParts.length != 2) {
                    System.out.println("Invalid command. Please provide colour.");
                    break;
                }
                String colourForSlots = commandParts[1];
                parkingLotManager.getSlotNumbesOfColour(colourForSlots);
                break;

            case "exit":
                System.out.println("Exiting the program.");
                break;

            default:
                System.out.println("Invalid command. Please enter a valid command.");
        }
    }
}
