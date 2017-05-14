package com.restful.hello.game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class GameService {

    public static final Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private GameModel gameModel;
    @Autowired
    private QuestionModel questionModel;
    @Autowired
    private CommentModel commentModel;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/create/game", method = RequestMethod.POST)
    public ResponseEntity<?> createGame(@RequestBody Game game){
        logger.info("Creating Game : {}", game.getName());
        gameModel.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/add/q", method = RequestMethod.POST)
    public ResponseEntity<?> addQ(@RequestBody Question q){
        logger.info("Creating Game : {}", q.getQ());
        questionModel.save(q);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getGames(){
        logger.info("requesting All Games");
        List<Game> game = (List<Game>) gameModel.findByAvailable(true);
        return new ResponseEntity<List<Game>>(game, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getGamesByCourse( @PathVariable  String id){
        logger.info("requesting All Games");
        List<Game> game = (List<Game>) gameModel.findByCourseIdAndAvailable(id,true);
        return new ResponseEntity<List<Game>>(game, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/mygames/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getMyGamesByCourse( @PathVariable  String id){
        logger.info("requesting hidden Games");
        List<Game> game = (List<Game>) gameModel.findByCourseId(id);
        return new ResponseEntity<List<Game>>(game, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public ResponseEntity<Game> getGame(@PathVariable Integer id){
        logger.info("requesting Game : {}", id);
        Game game =gameModel.findOne(id);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/q/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> getQ(@PathVariable Integer id){
        logger.info("requesting Qs Of game : {}", id);
        List<Question> qs = questionModel.findByGameId(id);
        return new ResponseEntity<List<Question>>( qs ,HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/update/game", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGame(@RequestBody Game game){
        logger.info("Creating Game : {}", game.getName());
        gameModel.save(game);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/copy/{cId}/{gId}", method = RequestMethod.GET)
    public ResponseEntity<?> copyGame( @PathVariable  String cId, @PathVariable Integer gId){
        logger.info("requesting All Games");

        // Create a game with same attributes and let the ID be auto generated
        Game game = gameModel.findOne(gId);
        List<Game> games = (List<Game>)gameModel.findAll();
        Game game2 = new Game( games.size() +1 , game.getName(), game.getCourseId(), game.getCategory(), game.isAvailable());

        // Save game in DB
        gameModel.save(game2);
        int game2Id = games.size() +1;

        // Iterate through all questions and copy them
        List<Question> questions = questionModel.findByGameId(gId);
        List<Question> qs = (List<Question>)this.questionModel.findAll();
        Integer ids = qs.size()+1;
        for(int i = 0; i < questions.size(); i++){
            Question q = questions.get(i);
            Question q2 = new Question(ids++, q.getQ(), q.getA() , q.getRa(), game2Id);
            this.addQ(q2);
        }

        /* Meen de? :") */
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getcomments(@PathVariable Integer id){
        logger.info("requesting Game : {}", id);
        List<Comment> comments =commentModel.findByGameId(id);
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/comment/", method = RequestMethod.POST)
    public ResponseEntity<?> addcomment( @RequestBody Comment comment ){
        logger.info("add comment : {}");
        commentModel.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}