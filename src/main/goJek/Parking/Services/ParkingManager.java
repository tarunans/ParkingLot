package main.goJek.Parking.Services;

import main.goJek.Parking.Model.Vehicle;
import main.goJek.Parking.exception.ParkingLotException;

public interface ParkingManager {

    public void parkVehicle(Vehicle vehicle);

    public void unparkVehicle( Integer slot );

    public void getStatus();

    public void registrationNumberWithColor(String color);

    public void slot_numbers_for_cars_with_colour(String color);

    public void slot_number_for_registration_number(String registrationNumber);

}
