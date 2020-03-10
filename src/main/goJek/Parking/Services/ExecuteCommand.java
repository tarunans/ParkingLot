package main.goJek.Parking.Services;

import main.goJek.Parking.Inventory.SingletonParkingLotInventory;
import main.goJek.Parking.Model.Car;
import main.goJek.Parking.constants.ParkingLotConstants;
import main.goJek.Parking.exception.ParkingLotException;

import static main.goJek.Parking.exception.ExceptionEnum.INVALID_INPUT;

public class ExecuteCommand {

    SingletonParkingLotInventory singletonParkingLotInventory;

    public void execute( String input ) throws ParkingLotException {
        String[] inputs = input.split(" ");
        String key = inputs[0];
        switch (key) {
            case ParkingLotConstants.CREATE_PARKING_LOT:
                try {
                    Integer slots = Integer.parseInt(inputs[1]);
                    singletonParkingLotInventory = SingletonParkingLotInventory.createNewInventory(slots);
                }
                catch (NumberFormatException e) {
                    throw new ParkingLotException(INVALID_INPUT);
                }
                break;
            case ParkingLotConstants.PARK:
                singletonParkingLotInventory.parkVehicle(new Car(inputs[1], inputs[2]));
                break;
            case ParkingLotConstants.LEAVE:
                try {
                    Integer slotNumber = Integer.parseInt(inputs[1]);
                    singletonParkingLotInventory.unparkVehicle(slotNumber);
                }
                catch (NumberFormatException e) {
                    throw new ParkingLotException(INVALID_INPUT);
                }
                break;
            case ParkingLotConstants.STATUS:
                singletonParkingLotInventory.getStatus();
                break;
            case ParkingLotConstants.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOUR:
                singletonParkingLotInventory.registrationNumberWithColor(inputs[1]);
                break;
            case ParkingLotConstants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR:
                singletonParkingLotInventory.slotNumbersForCarsWithColour(inputs[1]);
                break;
            case ParkingLotConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                singletonParkingLotInventory.slotNumbersForCarsWithRegNumber(inputs[1]);
                break;
            case ParkingLotConstants.EXIT:
                System.exit(0);
            default:
                System.out.println("Ivalid input command type");
                break;
        }
    }
}
