package com.restful.hello.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LENOVO on 17/04/27.
 */

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String q ;
    @ElementCollection
    @Basic
    private List<String> a ;
    private String ra ; //right answer
    int  gameId;

    public Question(
            @JsonProperty("id") Integer id,
            @JsonProperty("q") String q,
            @JsonProperty("a") List<String> a,
            @JsonProperty("ra") String ra,
            @JsonProperty("gameId") int gameId) {
        this.id = id;
        this.q = q;
        this.a = a;
        this.ra = ra;
        this.gameId = gameId;
    }

    public Question(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }


    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }


    public List<String> getA() {
        return a;
    }

    public void setA(List<String> a) {
        this.a = a;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }


}
