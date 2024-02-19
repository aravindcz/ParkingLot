package com.aravindcz.parkinglot;


import com.aravindcz.parkinglot.service.IParkingLotManager;
import com.aravindcz.parkinglot.service.ParkingLotManager;

import java.util.*;
public class ParkingLotMain {
    public static void main(String[] args) {
        IParkingLotManager parkingLotManager = new ParkingLotManager();
        ParkingLotCommandProcessor commandProcessor = new ParkingLotCommandProcessor(parkingLotManager);

        commandProcessor.processCommands();
    }
}
