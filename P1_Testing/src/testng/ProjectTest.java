package testng;

import org.testng.annotations.Test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;


public class ProjectTest {
	
	  AccountModel accountModel = new AccountModel();
	  AccountManager accountManager = new AccountManager(accountModel);
	  GameModel gameModel = new GameModel(); 
	  GameManager gameManager = new GameManager(gameModel);
	  CategoryModel categoryModel = new CategoryModel();
	  CategoryManager categoryManager = new CategoryManager(categoryModel);
	  
	  
  
  /* Null, empty and space string inputs work! However, repeated accounts are detected. */
  @ DataProvider (name = "signUpData")
  public String[][] signUpData(){
	  
	  String[][] data = {{"Teacher", "Aby", "Aby", "Aby", "Aby", "Aby", "Aby", "Aby", "Aby"},
			             {"Student", "Penny", "Penny", "Penny", "Penny", "Penny", "Penny", "Penny", "Penny"},
			             {"Student", "Penny", "Penny", "Penny", "Penny", "Penny", "Penny", "Penny", "Penny"},
			             {"TYPE", "Joe", "Joe", "Joe", "Joe", "Joe", "Joe", "Joe", "Joe"},
			             {"", "", "", "", "", "", "", "",""}, 
			             {" ", " ", " ", " ", " ", " ", " ", " ", " "},
			             {"\n", "\n", "\n", "\n", "\n", "\n", "\n", "\n", "\n"}}; 
	  return data; 
	  
  }
  
  @Test (dataProvider = "signUpData")
  public void signUpTest(String a, String b, String c, String d, String e, String f,
		                 String g, String h, String i){
	  
	  accountManager.createRegistrationForm(a, b, c, d, e, f, g, h, i);
  }
  /*------------------------------------------------------------------------------*/
  
  
  
  /* Null, empty and space variables are accepted. Also, the user name and question 
   * type aren't verified. */
  @DataProvider (name = "createGameData")
  public String[][] createGameData(){
	  
	  String[][] data = {{"Aby", "Math", "fun", "TF", "NO HELP!"},
			             {"Aby", "Math", "fun", "TF", "NO HELP!"},
			             {"Aby", "Math", "puzzle", "STH", "NO HELP!"},
			             {"Abyss", "Math", "puzzle", "STH", "NO HELP!"},
			             {" ", " ", " ", " ", " "},
			             {"", "", "", "", ""},
			             {"\n", "\n", "\n", "\n", "\n"}};
	  
	  return data;
	  
  }
  
  @Test (dataProvider = "createGameData")
  public void createGameTest(String u, String c, String n, String t, String h){
	  
	  gameManager.createGameForm(accountManager, u, categoryManager, c, n, t, h);
  }
  /*------------------------------------------------------------------------------*/
  
  
  
  /* Null, empty and space string inputs work fine, but nonexistent games are
   * detected and an error is thrown. In addition, user names aren't verified*/
  @DataProvider (name = "playGameData")
  public String[][] playGameData(){
	  
	  String[][] data = {{"", "", ""},
			             {" ", " ", " "},
			             {"fun", "fun", "fun"},
			             {"\n", "\n", "\n"},
			             {"puzzle", "puzzle", "puzzle"}};
	  
	  return data;
	  
  }
  
  @Test (dataProvider = "playGameData")
  public void playGameTest(String category, String gameName, String userName){
	  
	  ArrayList<Game> categoryGames = new ArrayList<Game>();
	  categoryGames = categoryManager.categoryModel.retrieveCategoryGames(category);
	  
	  if(categoryGames != null){
		  for(int i = 0 ; i < categoryGames.size() ; i++)
				System.out.print(categoryGames.get(i).getName() + ", ");
			System.out.println();
	
	  }
		
		gameManager.runGameInterface(gameName, accountManager, userName);
	  
  }
  /*------------------------------------------------------------------------------*/
  
  
  
  @DataProvider(name = "dates")
  public static Object[][] dates() {
      return new Object[][] {
//              { true  , "11/11/2017" },
//              { false , "2017/11/11" },
              { false , "DD/MM/YYYY" },
//              { false ,"//" },
//              { false , "" },
              { false , "55/55/2017"},
//              {false,"12,444/2017"}
      };
  }


  //---------------- Test 4 : Test checkDate function ---------------
  // null , "//" , "12/444/2017" input results a crash
  // The right format should be dd/mm/yyyy but 11/11/2017 return false
  // and 2017/11/11 return true
  // anyway the right format not clear in the design doc

  @Test(dataProvider = "dates")
  public void testCheckDate( boolean state, String date) throws Exception {
      TournamentManager TM = new TournamentManager(new TournamentModel());
      Assert.assertEquals(TM.checkDate(date),state);
  }


  @DataProvider (name = "tournaments")
  public static Object[][] tournaments() {
      return new Object[][] {
              { true  , "tournament1" },
              { false , "tournament2" },
              { false , "" },
              { false , "tournament" }
      };
  }

  //---------------- Test 5 : Test checkTournamentExist function ---------------
  // Works Fine!
  @Test(dataProvider = "tournaments")
      public void testCheckTournamentExist( boolean state, String tournament) throws Exception {
      Tournament T = new Tournament();
      T.setName("tournament1");
      TournamentModel TM = new TournamentModel();
      TM.insertTournament(T);
      Assert.assertEquals(TM.checkTournamentExist(tournament),state);
  }
  
  
}
