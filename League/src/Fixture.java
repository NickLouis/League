/**
 * @author Nick's Account
 *
 */
public class Fixture {
	
	Team home;
	Team away;	
	/**
	 * @param home
	 * @param away
	 */
	public Fixture(Team home, Team away) {
		super();
		this.home = home;
		this.away = away;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fixture [home=" + home + ", away=" + away + "]";
	}
}
