package hello.gameService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static hello.user.UserService.logger;

@Service
public interface GameModel  extends CrudRepository<Game, String>{
	

	ArrayList<Game> games = new ArrayList<>();

    public GameModel(){
      //  String[] as = { "fine","good","not good" };
       // this.games.add(new Game("0","first game","mhmeeaad@gmail.com","000", new Q("How are you ?", as  )));
    }


	public Game getGame(String id){
        for (int i = 0; i < games.size(); i++) {
            logger.info("search for :"+ id);
            if(games.get(i).getId().equals(id)) {
                logger.info("Found :"+ id);
                return games.get(i);
            }
        }

        return null;
    }
	
	public void addGame(Game game){
        game.setId( String.valueOf(games.size()) );
        games.add(game);
	}

}
