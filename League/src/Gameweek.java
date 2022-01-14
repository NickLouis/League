import java.util.List;

public class Gameweek {

	int week;
	List<Fixture> fixtures;
	List<Game> results;
		
	public Gameweek(List<Fixture> fixtures, int week) {
		super();
		this.fixtures = fixtures;
		this.week=week;
	}
	
	public List<Game> getResults() {
		return results;
	}
	
	public void setResults(List<Game> results) {
		this.results = results;
	}
	
	public List<Fixture> getFixtures() {
		return fixtures;
	}
	
	public String fixturePrint() {
		String out = "{\n\t";
		for (Fixture s : fixtures) {
			out +=String.format("%-25s %-3s %25s", s.home , " - ", s.away)+",\n\t";
		}
		out+="}\n";
		return out;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Gameweek [week=" + week + ", fixtures=" + fixturePrint() + ", results=" + results + "]";
	}
	
	
}
