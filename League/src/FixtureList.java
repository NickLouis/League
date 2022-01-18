
public class FixtureList {



	public String [][] fixtureList(){


		String [][] leagueFixtures = new String[21][21];
		
		for (int i =0;i<leagueFixtures.length;i++) {
			leagueFixtures[i][i]=String.format("%-25s","X");
		}
		for (int i =1;i<leagueFixtures.length;i++) {
			leagueFixtures[0][i]=String.format("%-25s",LeagueConstants.TEAMS.split(",")[i-1]);
		}
		for (int i =1;i<leagueFixtures.length;i++) {
			leagueFixtures[i][0]=String.format("%-25s",LeagueConstants.TEAMS.split(",")[i-1]);
		}	
		for (int i =0;i<leagueFixtures.length;i++) {
			for (int j =0;j<leagueFixtures.length;j++) {
				if (leagueFixtures[i][j]==null)
					leagueFixtures[i][j]=String.format("%-25s","O");

			}
		}

		return leagueFixtures;
	}


	public void printFixtures(String [][] leagueFixtures) {

		for (int i =0;i<leagueFixtures.length;i++) {
			for (int j =0;j<leagueFixtures.length;j++) {
				System.out.print(leagueFixtures[i][j]); 
			}
			System.out.println();
		}
	}





	public static void main(String[] args) {


		FixtureList fl = new FixtureList();
		
		fl.printFixtures(fl.fixtureList());







	}

}
