package com.restful.hello.score;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by LENOVO on 17/04/30.
 */
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String game;
    String score;
    int studentId;

    public Score(int id, String game, String score, int studentId) {
        this.id = id;
        this.game = game;
        this.score = score;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}

