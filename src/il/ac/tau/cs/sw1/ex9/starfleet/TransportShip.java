package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends MyAbstractSpaceShip{
	private int cargoCapacity;
	private int passengersCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengersCapacity = passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return 3000 + 5 * this.cargoCapacity + 3 * this.passengersCapacity;
	}
	
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return this.passengersCapacity;
	}
	
	@Override
	public String toString() {
		return super.toString()
		+ "\r\n	CargoCapacity=%d\r\n".formatted(this.cargoCapacity)
		+ "	PassengerCapacity=%d".formatted(this.passengersCapacity);
	}
}
