package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class MyAbstractBattleSpaceShip extends MyAbstractSpaceShip {
	private List<Weapon> weapons;
	public MyAbstractBattleSpaceShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crew, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crew);
		this.weapons = weapons;
	}
	
	public List<Weapon> getWeapon(){
		return this.weapons;
	}
	
	@Override
	public int getFirePower() {
		return super.getFirePower() + this.weapons.stream().mapToInt(x -> x.getFirePower()).sum();
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return this.getWeapon().stream().mapToInt(x -> x.getAnnualMaintenanceCost()).sum();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\r\n	WeaponArray=" + this.getWeapon();
	}
}
