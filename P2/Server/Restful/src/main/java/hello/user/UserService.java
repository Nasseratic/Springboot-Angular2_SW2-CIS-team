package hello.user;


import com.fasterxml.jackson.annotation.JsonProperty;
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

@Component
class SimpleCORSFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

    public SimpleCORSFilter() {
        log.info("SimpleCORSFilter init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}

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
    public ResponseEntity<?> getUser(@RequestBody Login login) {
        logger.info("user :" + login.getEmail() + "logging");
        User user = userService.authUser(login.getEmail(), login.getPw());
        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    ////////////////////////////////////////////////

    //	 , UriComponentsBuilder ucBuilder

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/create/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        logger.info("Creating User : {}", user);
        user.setId(String.valueOf(userService.users.size()));
        logger.info(user.getName() + " ID:" + userService.users.size());
        if (userService.isValidNewEmail(user.getEmail())) {
            userService.addUser(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
