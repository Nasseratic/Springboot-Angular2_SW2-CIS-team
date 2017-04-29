package com.restful.hello.YouAreWelcome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by LENOVO on 17/04/04.
 */
class game{
    String id;
    String name;
    String category;
    String img;
    String description;
    String type;
    String icon;


    game(String name , String category, String img, String description, String type, String icon , String id){
        this.name=name;
        this.category=category;
        this.img=img;
        this.description=description;
        this.type=type;
        this.icon=icon;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


@RestController
public class YouAreWelcomw {


    public List<game> thank() {
        return Arrays.asList(
                new game( "Game" , "Math", "./assets/gamification-760.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor ", "MCQ","bubble_chart" , "1")
                ,new game( "Game" , "Math", "./assets/gamification-760.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor ", "MCQ","bubble_chart","2")
                ,new game( "Game" , "Math", "./assets/gamification-760.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor ", "MCQ","bubble_chart","3")
                ,new game( "Game" , "Math", "./assets/gamification-760.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor ", "MCQ","bubble_chart","3")
                ,new game( "Game" , "Math", "./assets/gamification-760.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor ", "MCQ","bubble_chart","3")

        ) ;
    }
}