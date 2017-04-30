package com.restful.hello.score;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LENOVO on 17/04/30.
 */



@RestController
@RequestMapping("/api")
public class ScoreService {

    public static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

    @Autowired
    private ScoreModel scoreModel;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/add/score", method = RequestMethod.POST)
    public ResponseEntity<?> addScore(@RequestBody Score score){
        logger.info("Creating Game : {}", score.getGame());
        scoreModel.save(score);
        return new ResponseEntity<Score>(HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/myscores/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Score>> myScores(@PathVariable Integer id){
        logger.info("requesting Qs Of game : {}", id);
        List<Score> qs = scoreModel.findByStudentId(id);
        return new ResponseEntity<List<Score>>( qs ,HttpStatus.OK);
    }

}