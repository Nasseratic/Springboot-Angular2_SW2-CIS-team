package com.restful.hello.game;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by LENOVO on 17/05/14.
 */
public interface CommentModel extends CrudRepository<Comment , Integer> {
    public List<Comment> findByGameId(Integer id );

}
