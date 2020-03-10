package main.goJek.Parking.Services;

import main.goJek.Parking.Model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class CarParkingManager implements ParkingManager {

    private Vehicle[] parkingSlots;
    private Integer parkingSize;

    public CarParkingManager(int parkingSize){
        this.parkingSize = parkingSize;
        parkingSlots = new Vehicle[parkingSize];
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        for(Integer slot=0; slot<parkingSize; slot++){
            if( parkingSlots[slot]==null ){
                parkingSlots[slot] = vehicle;
                System.out.printf("Allocated slot number:%d\n", slot + 1);
                return;
            }
        }
        System.out.println("Sorry, parking lot is full");
    }

    @Override
    public void unparkVehicle( Integer slot ) {
        if( parkingSlots[slot]==null ){
            System.out.printf("Slot number %d is free\n", slot + 1);
        }
        parkingSlots[slot] = null;
    }

    @Override
    public void getStatus() {
        System.out.println("Slot No. Registration No Colour");
        for(Integer slot=0; slot < parkingSize; slot++){
            if( parkingSlots[slot]!=null ){
                System.out.println(slot + "   " + parkingSlots[slot].getRegistrationNumber() +
                        "  " + parkingSlots[slot].getColour() );
            }
        }
    }

    @Override
    public void registrationNumberWithColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        for(Integer slot=0; slot < parkingSize; slot++){
            if( parkingSlots[slot]!=null && color.equals(parkingSlots[slot].getColour()) ){
                registrationNumbers.add(parkingSlots[slot].getRegistrationNumber());
            }
        }
        printResultOnConsole(registrationNumbers);
    }

    @Override
    public void slot_numbers_for_cars_with_colour(String color) {
        List<String> slotNumbers = new ArrayList<>();
        for(Integer slot=0; slot < parkingSize; slot++){
            if( parkingSlots[slot]!=null && color.equals(parkingSlots[slot].getColour()) ){
                slotNumbers.add(slot.toString());
            }
        }
        printResultOnConsole(slotNumbers);
    }

    @Override
    public void slot_number_for_registration_number(String registrationNumber) {
        List<String> slotNumbers = new ArrayList<>();
        for(Integer slot=0; slot < parkingSize; slot++){
            if( parkingSlots[slot]!=null && registrationNumber.equals(parkingSlots[slot].getRegistrationNumber()) ){
                slotNumbers.add(slot.toString());
            }
        }
        printResultOnConsole(slotNumbers);
    }

    public void printResultOnConsole(List<String> vehicles) {
        String response = vehicles.size() > 0 ? String.join(", ", vehicles) : "Not found";
        System.out.println(response);
    }

}
