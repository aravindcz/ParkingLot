import service.IParkingLotManager;
import service.ParkingLotManager;

import java.util.*;
public class ParkingLotMain {
    public static void main(String[] args) {
        IParkingLotManager parkingLotManager = new ParkingLotManager();
        ParkingLotCommandProcessor commandProcessor = new ParkingLotCommandProcessor(parkingLotManager);

        commandProcessor.processCommands();
    }
}
