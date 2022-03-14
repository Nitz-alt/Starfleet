package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends MyAbstractBattleSpaceShip{

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return  4000 + super.getAnnualMaintenanceCost() + super.getCrewMembers().size() * 500 + Math.round(this.getMaximalSpeed() * 500);
	}

}
