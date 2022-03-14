package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends MyAbstractBattleSpaceShip {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return 3500 + super.getAnnualMaintenanceCost() + super.getCrewMembers().size() * 500 + Math.round(1200 * this.getMaximalSpeed());
	}

	

}
