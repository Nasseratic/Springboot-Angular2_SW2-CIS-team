package hello.gameService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@RestController
@RequestMapping("/")
public class GameService {

    public static final Logger logger = LoggerFactory.getLogger(GameModel.class);

    @Autowired
    private GameModel gameServise;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHello() {
        return "Hello";
    }

    @RequestMapping(value ="/games")
    public ResponseEntity<?> getAllGames() {
        logger.info("getting games");
        return new ResponseEntity<ArrayList<Game>>(gameServise.games, HttpStatus.OK);
    }
        /////////////////////////////////////////////method//
    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String id) {
        logger.info("getting hello.user with id {}", id);
        Game game = gameServise.getGame(id);

        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }

    ////////////////////////////////////////////////

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/create/game/", method = RequestMethod.POST)
    public ResponseEntity<?> createGame(@RequestBody Game game ){
        logger.info("Creating User : {}", game);
        this.gameServise.addGame(game);
    logger.info(game.getTeacher() + " ID:" + gameServise.games.size());

    ResponseEntity<Integer> responseEntity = new ResponseEntity<>(gameServise.games.size()-1,
            HttpStatus.OK);
        return responseEntity ;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/add/q/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> createGame(@RequestBody Q q , @PathVariable int id){
        logger.info("Creating User : {}", q);
        logger.info( q.getQ() + " ID:" + id );
        gameServise.games.get(id).addQ(q);
        logger.info(q.getQ()+ " ID:" + gameServise.games.size());
        logger.info(q.getRa()+ " ID:" + gameServise.games.size());

        ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        return responseEntity ;

    }

}
