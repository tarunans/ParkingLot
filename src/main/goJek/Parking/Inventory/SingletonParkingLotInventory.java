package main.goJek.Parking.Inventory;

import main.goJek.Parking.Model.Vehicle;
import main.goJek.Parking.Services.CarParkingManager;
import main.goJek.Parking.Services.ParkingManager;
import main.goJek.Parking.exception.ExceptionEnum;
import main.goJek.Parking.exception.ParkingLotException;

public class SingletonParkingLotInventory {
	
	private static SingletonParkingLotInventory singletonParkingLotInventory = null;
	private ParkingManager parkingManager = null;
	
	private SingletonParkingLotInventory(int n){
		System.out.println("Created a parking lot with " + n + " slots");
		parkingManager = new CarParkingManager(n);
	}

	public static SingletonParkingLotInventory getInventory() throws ParkingLotException  {
		if( singletonParkingLotInventory == null ) {
			throw new ParkingLotException(ExceptionEnum.INVENTORY_NOT_PRESENT);
		}
		return singletonParkingLotInventory;
	}

	public static SingletonParkingLotInventory createNewInventory( Integer n ) throws ParkingLotException {
		if( singletonParkingLotInventory == null ) {
			singletonParkingLotInventory = new SingletonParkingLotInventory(n);
		}else {
			throw new ParkingLotException(ExceptionEnum.INVENTORY_ALREADY_PRESENT);
		}
		return singletonParkingLotInventory;
	}

	public void parkVehicle( Vehicle vehicle ) {
		parkingManager.parkVehicle(vehicle);
	}

	public void unparkVehicle( Integer slotnumber ) {
		parkingManager.unparkVehicle(slotnumber);
	}

	public void getStatus() {
		parkingManager.getStatus();
	}

	public void registrationNumberWithColor(String color) {
		parkingManager.registrationNumberWithColor(color);
	}

	public void slotNumbersForCarsWithColour(String color) {
		parkingManager.slot_numbers_for_cars_with_colour(color);
	}

	public void slotNumbersForCarsWithRegNumber(String registrationNumber) {
		parkingManager.slot_number_for_registration_number(registrationNumber);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
