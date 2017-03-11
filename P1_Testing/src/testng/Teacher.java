package testng;
import java.util.ArrayList;

public class Teacher extends Account 
{
	String professionalReference;
	ArrayList <Game> games = new ArrayList <Game>();
	ArrayList <Tournament> tournaments = new ArrayList <Tournament>();
	
	Teacher(String fN, String lN, String uN, String e, String bd, String pw, String g, String s) {
		super(fN, lN, uN, e, bd, pw, g);
		professionalReference = s;
	}
	
	void addGame ( Game game )
	{
		games.add(game);
		
	}
	void addTournament ( Tournament tournament )
	{
		tournaments.add(tournament);
	}

}

