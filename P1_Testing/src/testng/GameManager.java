package testng;
import java.util.ArrayList;
import java.util.Map;

public class GameManager 
{
	GameModel gameModel;
	
	GameManager (GameModel gameModel )
	{
		this.gameModel = gameModel;
	}
	
	void createGameForm (AccountManager accountManager , String username , 
			             CategoryManager categoryManager , String categoryName,
			             String n, String t, String h)
	{
		
//      GameForm gameForm = new GameForm();	
//      validateFormContent( gameForm );
//		Game game = new Game();
//		game.name = gameForm.name;
//		game.type = gameForm.type;
//		game.questions = gameForm.questions;
//		game.help = gameForm.help;
//		
//		gameModel.insertGame(game);
//		accountManager.addGameToAccount(username, game);
//		categoryManager.addGameToCategory(categoryName, game);
//		gameForm.gameCreatedSuccessfullyMessage();
		
		/*----- ABEER -----*/
		GameForm gameForm = new GameForm(n, t, h);
		if(gameModel.checkExist(gameForm.name)){
			gameForm.gameNameExistsMessage();
		}else{
			Game game = new Game();
			game.name = gameForm.name;
			game.type = gameForm.type;
			game.questions = gameForm.questions;
			game.help = gameForm.help;
			gameModel.insertGame(game);
			accountManager.addGameToAccount(username, game);
		}
		/*-----------------*/
		
	}
	
	void validateFormContent ( GameForm gameForm )
	{
		while ( gameModel.checkExist(gameForm.name) )
		{
			gameForm.gameNameExistsMessage();
			gameForm.insertName();
		}
	}
	
	void runGameInterface(String gameName, AccountManager accountManager, String username)
	{
		Game game = gameModel.retrieveGame(gameName);
		Game NewGame = new Game(game.name, game.type , game.questions , game.scoreboard , 0 , game.help);
		GameInterface gameInterface = new GameInterface(NewGame);		
		gameInterface.run();		
		accountManager.addScoreToAccount(username,NewGame.playerScore);
		gameInterface.showScore();
		NewGame.updateScoreboard(username);
		gameInterface.showScoreBoard();
	}
	
	
}
