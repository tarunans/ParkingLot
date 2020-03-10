package main.goJek.Parking.exception;

public class ParkingLotException extends Exception {
	
	private ExceptionEnum exceptionEnum;
	
	public ParkingLotException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMessage());
		this.exceptionEnum = exceptionEnum;
	}
	
}
