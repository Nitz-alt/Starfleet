package il.ac.tau.cs.sw1.ex9.starfleet;
import java.util.Objects;
import java.util.Set;

public abstract class MyAbstractSpaceShip implements Spaceship {
	private String name;
	private int commissionYear;
	private float maximalSpeed;
	private int firePower = 10;
	private Set<? extends CrewMember> crewMembers;
	
	public MyAbstractSpaceShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crew) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crew;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getCommissionYear() {
		return this.commissionYear;
	}
	
	@Override
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}
	
	@Override
	public int getFirePower() {
		return this.firePower;
	}
	
	@Override
	public Set<? extends CrewMember> getCrewMembers(){
		return this.crewMembers;
	}
	
	public String toString() {
		return "%s\r\n".formatted(this.getClass().getSimpleName())
				+ "	Name=%s\r\n".formatted(this.getName())
				+ "	CommissionYear=%d\r\n".formatted(this.getCommissionYear())
				+ "	MaximalSpeed=%.1f\r\n".formatted(this.getMaximalSpeed())
				+ "	FirePower=%d\r\n".formatted(this.getFirePower())
				+ "	CrewMembers=%d\r\n".formatted(this.getCrewMembers().size())
				+ "	AnnualMaintenanceCost=%d".formatted(this.getAnnualMaintenanceCost());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAbstractSpaceShip other = (MyAbstractSpaceShip) obj;
		return Objects.equals(name, other.name);
	}
	
}
