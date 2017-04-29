package com.restful.hello.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserModel userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHello() {
        return "Hello";
    }

        /////////////////////////////////////////////method//
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody Login login) {
        logger.info("api :" + login.getEmail() + "logging");
        ApiUser user = userService.findByEmail(login.getEmail());
        if ( user != null && user.getPw().equals(login.getPw()) )
            return new ResponseEntity<ApiUser>( user , HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //////////////////////////////////////////////

    	 //, UriComponentsBuilder ucBuilder

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/create/users/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody ApiUser users) {
        logger.info("Creating Api_user : {}", users.getEmail());
        if (userService.findByEmail(users.getEmail()) ==  null) {
            userService.save(users);
            return new ResponseEntity<ApiUser>(users, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
