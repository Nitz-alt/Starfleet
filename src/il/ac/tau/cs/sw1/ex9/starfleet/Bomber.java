package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends MyAbstractBattleSpaceShip{
	private int numberOfTechnicians;
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}
	
	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return  5000 + Math.round(super.getAnnualMaintenanceCost() * (1 - (float) this.numberOfTechnicians/10));
	}
	
	@Override
	public String toString() {
		return super.toString() + "\r\n	NumberOfTechnicians=%d".formatted(this.getNumberOfTechnicians());
	}
}
