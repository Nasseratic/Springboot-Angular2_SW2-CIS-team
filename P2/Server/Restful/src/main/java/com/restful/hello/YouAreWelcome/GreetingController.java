package com.restful.hello.YouAreWelcome;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value ="/greeting",produces = "application/json")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }


    @RequestMapping(value ="/create/greeting",produces = "application/json")
    public String newGreeting(@RequestBody Greeting greeting) {
        greetingService.save(greeting);
        return "nice";
    }
}
