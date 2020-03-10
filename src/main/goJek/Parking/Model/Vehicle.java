package main.goJek.Parking.Model;

import java.util.Objects;

public abstract class Vehicle {
	private String registrationNumber;
	private String colour;
	
	public Vehicle(String registrationNumber, String colour) {
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public String setRegistrationNumber(String registrationNumber) {
		return this.registrationNumber = registrationNumber;
	}
	
	public String setColour(String colour) {
		return this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Vehicle)) return false;
		Vehicle vehicle = (Vehicle) o;
		return getRegistrationNumber().equals(vehicle.getRegistrationNumber()) &&
				colour.equals(vehicle.colour);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRegistrationNumber(), getColour());
	}
}
