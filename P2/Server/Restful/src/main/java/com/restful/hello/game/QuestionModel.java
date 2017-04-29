package com.restful.hello.game;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LENOVO on 17/04/27.
 */
public interface QuestionModel extends CrudRepository<Question,Integer>{
    public List<Question> findByGameId(Integer id);

}
