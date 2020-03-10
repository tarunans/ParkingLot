package main.goJek.Parking;

import main.goJek.Parking.Services.ExecuteCommand;
import main.goJek.Parking.exception.ParkingLotException;
import java.io.*;

import static main.goJek.Parking.exception.ExceptionEnum.FILE_NOT_CORRECT;
import static main.goJek.Parking.exception.ExceptionEnum.INVALID_INPUT;

public class ParkingLotMain{

	public static void main(String[] args) throws ParkingLotException {

		ParkingLotMain goJekParkingLotService = new ParkingLotMain();
		ExecuteCommand executeCommand = new ExecuteCommand();
		goJekParkingLotService.printUsage();

		BufferedReader bufferReader = null;
		String input = null;
		if( args.length == 0 ){
			while(true) {
				bufferReader = new BufferedReader(new InputStreamReader(System.in));
				try {
					input = bufferReader.readLine().trim();
				} catch (Exception ex) {
					throw new ParkingLotException(INVALID_INPUT);
				}
				executeCommand.execute(input.trim());
			}
		}else {
			File inputFile = new File(args[0]);
			try {
				bufferReader = new BufferedReader(new FileReader(inputFile));
				while ((input = bufferReader.readLine()) != null) {
					input = input.trim();
					try{
						executeCommand.execute(input);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			} catch (FileNotFoundException ex) {
				throw new ParkingLotException(FILE_NOT_CORRECT);
			} catch (IOException ex) {
				throw new ParkingLotException(INVALID_INPUT);
			}
		}
	}

	private void printUsage() {
		System.out.println("Welcome To GOJEK PARKING LOT");
		System.out.println("Please enter one of the below commands");
		System.out.println("1:  To create parking lot of size n  ----------------> : create_parking_lot [capacity]");
		System.out.println("2:  To park a car -----------------------------------> : park [car_number] [car_clour]");
		System.out.println("3:  Unpark car from parking -------------------------> : leave [slot number]");
		System.out.println("4:  Print status of parking slot --------------------> : status");
		System.out.println("5:  Print registration number for cars with color ---> : registration_numbers_for_cars_with_colour {car_color}");
		System.out.println("6:  Print slot for cars with color ------------------> : slot_numbers_for_cars_with_colour {car_color}");
		System.out.println("7:  Print slot for cars with registration number ----> : slot_number_for_registration_number {car_color}");
		System.out.println("8:  To exit -----------------------------------------> : exit");
	}
	
}
