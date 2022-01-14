import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Team implements Comparable<Team> {

	String name = "";
	int pos;
	int games_played=0;
	int games_won=0;
	int games_lost=0;
	int games_drawn=0;
	int goals_scored=0;
	int goals_conceded=0;
	int points=0;
	boolean lastHome = new Random().nextBoolean();// intialise randomly 

	// list of lists for dealing with with fixtures
	List<String> opponents;
	List<String> home;
	List<String> away;
	List<String> formattedFixtures;
	List<Fixture> fixtures;
	List<Game> results;

	String oppNames="AFC Bournemouth," + 
			"Arsenal," + 
			"Aston Villa," + 
			"Brighton & Hove Albion," + 
			"Burnley," + 
			"Chelsea," + 
			"Crystal Palace," + 
			"Everton," + 
			"Leicester City," + 
			"Liverpool," + 
			"Manchester City," + 
			"Manchester United," + 
			"Newcastle United," + 
			"Norwich City," + 
			"Sheffield United," + 
			"Southampton," + 
			"Tottenham Hotspur," + 
			"Watford," + 
			"West Ham United," + 
			"Wolverhampton Wanderers,";
	
	public Team(String name) {
		super();
		this.name = name;
		setOpponents();
		createFixtures();
	}


	public void createFixtures() {
		
		home = new ArrayList <>();
		away = new ArrayList <>();
		formattedFixtures = new ArrayList <>();

		opponents.remove(name);
		for (String s: opponents) {
			formattedFixtures.add(String .format("%-25s %-3s %25s", name , " - ", s));
			formattedFixtures.add(String .format("%-25s %-3s %25s", s , " - ", name));
			home.add(name+ " - "+ s);
			away.add(s+ " - "+ name);
		}
		
		Collections.shuffle(home);
		Collections.shuffle(away);
//		for (int i = 0;i<home.size();i++) { // next thing to rite is a means of distancing fixtures from one another
//			System.out.println(home.get(i));// so compare strings and 
//			System.out.println(away.get(i));
//		}
	}

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos+1;
	}

	public int getGames_played() {
		return games_played;
	}

	public void setGames_played(int games_played) {
		this.games_played = games_played;
	}

	public int getGames_won() {
		return games_won;
	}

	public void setGames_won(int games_won) {
		this.games_won = games_won;
	}

	public int getGames_lost() {
		return games_lost;
	}

	public void setGames_lost(int games_lost) {
		this.games_lost = games_lost;
	}

	public int getGames_drawn() {
		return games_drawn;
	}

	public void setGames_drawn(int games_drawn) {
		this.games_drawn = games_drawn;
	}

	public int getGoals_scored() {
		return goals_scored;
	}

	public void setGoals_scored(int goals_scored) {
		this.goals_scored = goals_scored;
	}

	public int getGoals_conceded() {
		return goals_conceded;
	}

	public void setGoals_conceded(int goals_conceded) {
		this.goals_conceded = goals_conceded;
	}

	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public void setOpponents() {

		this.opponents = new ArrayList <>(Arrays.asList(this.oppNames.split(",")));

	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Team o) {

		int goalDiff1 = this.getGoals_scored()-this.getGoals_conceded();
		int goalDiff2 = o.getGoals_scored()-o.getGoals_conceded();

		if (this. getPoints()>o.getPoints())
		{return 1;}
		else if (this.getPoints()<o.getPoints())
		{return -1;}
		else if (goalDiff1>goalDiff2)
		{return 1;}
		else if (goalDiff1<goalDiff2)
		{return -1;}
		else
			return 0;
	}


	@Override
	public String toString() {
		return name + " = {\n\t points: " + points +",\n\t games played: "+games_played+",\n\t games_won: "+ games_won
				+",\n\t games lost: "+ games_lost+",\n\t games drawn: "+ games_drawn+",\n\t goals scored: "+ goals_scored
				+",\n\t goals against: "+ goals_conceded+",\n\t pos: "+ pos + ",\n}";
	}



}
