package com.restful.hello.YouAreWelcome;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * Created by LENOVO on 17/04/27.
 */

@Service
public interface GreetingService extends CrudRepository<Greeting,String> {
}
