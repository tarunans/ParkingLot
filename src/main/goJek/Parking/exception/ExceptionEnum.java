package main.goJek.Parking.exception;

public enum ExceptionEnum {
	VEHICLE_IS_ALREADY_PARKED("Vehicle is Already Parked."),
	INVENTORY_ALREADY_PRESENT("Parking Inventory Already Present"),
	INVENTORY_NOT_PRESENT("Inventory not present"),
	PARKING_UNAVAILALBLE("No Parking available at this moment"),
	VACANT_SLOT( "Slot is already vacant" ),
	INVALID_INPUT("Invalid Input"),
	FILE_NOT_CORRECT("Invalid File"), 
	PROCESSING_ERROR("Processing Error "), 
	INVALID_REQUEST("Invalid Request");
	
	private String message = "";
	
	private ExceptionEnum(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
}
