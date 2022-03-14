package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> sortedList = fleet.stream().sorted((x,y) -> {
			// Compare by fire power
			if (x.getFirePower() != y.getFirePower())
				return Integer.compare(y.getFirePower(), x.getFirePower());
			// Compare by commission year
			if (x.getCommissionYear() != y.getCommissionYear())
				return Integer.compare(y.getCommissionYear(), x.getCommissionYear());
			// Compare by name
			return x.getName().compareTo(y.getName());
		}).collect(Collectors.toList());
		return sortedList.stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		return fleet.stream().collect(Collectors.groupingBy(x -> x.getClass().getSimpleName(), Collectors.reducing(0, y -> 1, Integer::sum)));
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		return fleet.stream().mapToInt(x -> x.getAnnualMaintenanceCost()).sum();
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		return fleet.stream().filter(x -> x instanceof MyAbstractBattleSpaceShip).map(MyAbstractBattleSpaceShip.class::cast)
				.flatMap(x -> x.getWeapon().stream()).map(x -> x.getName()).collect(Collectors.toSet());
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		return fleet.stream().mapToInt(x -> x.getCrewMembers().size()).sum();
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		return (float) fleet.stream().flatMap(x -> x.getCrewMembers().stream()).filter(x -> (x instanceof Officer)).mapToInt(x -> x.getAge()).average().orElse( (double) 0);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		return fleet.stream().filter(x -> x.getCrewMembers().stream().anyMatch(Officer.class::isInstance))
		.collect(Collectors.toMap((Spaceship x) -> {
			return x.getCrewMembers().stream().filter(Officer.class::isInstance)
			.map(Officer.class::cast).max((Officer a, Officer b) ->{
				return a.getRank().compareTo(b.getRank());
			}).orElse(null);
		}, (Spaceship x) -> { return x;}));
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		List<Map.Entry<OfficerRank, Integer>> finalList = fleet.stream().flatMap((Spaceship x) -> x.getCrewMembers().stream()).filter(Officer.class::isInstance)
		.map(Officer.class::cast).collect(Collectors.groupingBy(Officer::getRank, Collectors.reducing(0, e -> 1, Integer::sum)))
		.entrySet().stream().collect(Collectors.toList());
		finalList.sort((Entry<OfficerRank, Integer> x, Entry<OfficerRank, Integer> y) -> {
			if (x.getValue() != y.getValue())
				return x.getValue().compareTo(y.getValue());
			return x.getKey().compareTo(y.getKey());
		});
		return finalList;
		
	}

}
