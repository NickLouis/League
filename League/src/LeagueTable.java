import java.io.Console;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class LeagueTable {

	PrintStream out;

//	String teams = "AFC Bournemouth," + 
//			"Arsenal," + 
//			"Aston Villa," + 
//			"Brighton & Hove Albion," + 
//			"Burnley," + 
//			"Chelsea," + 
//			"Crystal Palace," + 
//			"Everton," + 
//			"Leicester City," + 
//			"Liverpool," + 
//			"Manchester City," + 
//			"Manchester United," + 
//			"Newcastle United," + 
//			"Norwich City," + 
//			"Sheffield United," + 
//			"Southampton," + 
//			"Tottenham Hotspur," + 
//			"Watford," + 
//			"West Ham United," + 
//			"Wolverhampton Wanderers";

	List <String> teamz;
	List <Team> clubs;


	public LeagueTable() {

		this.out = new PrintStream(System.out);

		setTeamz();

		this.clubs = new ArrayList<>();

		this.setTeamz();
		for (String s : this.teamz) {
			Team next  = new Team(s);
			this.clubs.add(next);
		}

	}

	public void setTeamz() {
		this.teamz = new ArrayList <>(Arrays.asList(LeagueConstants.TEAMS.split(",")));
	}

	public static void main(String [] args) {



		LeagueTable lt = new LeagueTable();

		PrintStream p = lt.out;

		lt.createGameweekOne();


		//		for (Team t : lt.clubs) {
		//			p.println("///////////////////////////////////////////");
		//			p.println(t.name);
		//			p.println(t.toString());
		//			for (String s : t.formattedFixtures) {
		//				p.println(s);
		//			}
		//		}

	}

	public List<Fixture> createGameweekOne() {
		
		//TODO REFACTOR TO USE NEW STUFF

		List<Team> home = new LinkedList<Team>();
		List<Team> away = new LinkedList<Team>();
		List<Fixture> gameWeek = new LinkedList<Fixture>();

		for (Team team : this.clubs) {
			if (team.lastHome) 
				home.add(team);// there will be a way to get this sorted with the boolean for home / away
			else
				away.add(team);
		}
		
		while(home.size()!=away.size()) {
			if (home.size()>away.size()) {
				home.get(0).lastHome=false;
				away.add(home.remove(0)); // need to change the boolean home/away fixture here.
				}
			else {
				away.get(0).lastHome=false;
				home.add(away.remove(0));}///// i have fucked up badly here... fix it
			
		}
		
		System.out.println("Home teams: "+ home + "\n\n\n\n");
		System.out.println("Away teams: "+away);
		
		for (int i = 0; i< home.size();i++) {
			System.out.println("Home team    " + home.get(i).name +"   "+home.get(i).lastHome );
			System.out.println("Away team    " + away.get(i).name +"   "+away.get(i).lastHome );
		}
		
		for (int i = 0; i< home.size();i++) {	
			Fixture f = new Fixture(home.get(i), away.get(i));
			gameWeek.add(f);	
		}
		
		
		
		return gameWeek;


	}



}
