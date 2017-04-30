package com.restful.hello.score;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LENOVO on 17/04/30.
 */
public interface ScoreModel extends CrudRepository<Score,Integer> {
    public List<Score> findByStudentId(Integer id);
}
