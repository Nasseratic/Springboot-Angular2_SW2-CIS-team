import { Component, OnInit } from '@angular/core';
import { MdSnackBar } from '@angular/material';
import { Http } from "@angular/http";
import { GameServiceService } from "../../services/game-service.service"
import { CourseServiceService } from "../../services/course-service.service"
import { ActivatedRoute } from '@angular/router'
import { Router } from '@angular/router'
import {AuthService} from "../../services/auth.service"

@Component({
  selector: 'game-cards',
  templateUrl: './game-card.component.html',
  styleUrls: ['./game-card.component.css'],
  providers: [GameServiceService , CourseServiceService]
})
export class GameCardComponent implements OnInit {

  view_name = "ALL GAMES";
  games = [];
  id :  any ;
  isMyCourse = false;
  courses =[];
  constructor(private http: Http, private gameServiceService: GameServiceService, private courseServiceService: CourseServiceService , private router: Router, private aRouter: ActivatedRoute , public auth:AuthService , private snack:MdSnackBar) {

    let id = this.aRouter.snapshot.params['id'];
    this.id = id;
    if(id !== undefined)
    this.gameServiceService.isMyCourse( this.id , this.auth.getId()).subscribe( (res) => {
      console.log(res);
         this.isMyCourse = res ;
    });
    this.courseServiceService.getCoursesByTeacher(this.auth.getId()).subscribe(
      (res) => {
        this.courses = res;
      }
    );
     
  }



  ngOnInit() {

    let id = this.aRouter.snapshot.params['id'];
    this.id = id;
    if(id !== undefined)
    this.gameServiceService.isMyCourse( this.id , this.auth.getId() ).subscribe( (res) => {
        if(res == 1)
        this.isMyCourse = true ;
        
        this.gameServiceService.getGamesOfcourse(this.id , res).subscribe(
        (res) => {
          this.view_name = "Course Content";
        this.games=res;
        this.games.forEach(game => {
          game.img = "./assets/gamification-760.jpg"
          if(game.category == "Programming")
            game.icon = "memory";
          else if (game.category == "Math")
            game.icon = "widgets"
          else if (game.category == "Science")
            game.icon = "opacity"
          else game.icon = "translate"
        })
      });

    });
    else {
      
      this.gameServiceService.getGames().subscribe(games => {
      this.games = games
        this.games.forEach(game => {
          game.img = "./assets/gamification-760.jpg"
          if(game.category == "Programming")
            game.icon = "memory";
          else if (game.category == "Math")
            game.icon = "widgets"
          else if (game.category == "Science")
            game.icon = "opacity"
          else game.icon = "translate"
        })
      }
      );



    }

  }


  viewGame(id) {
    this.router.navigate(['/game', id]);
  }

  copyGame(courseId,gameId ) {
    this.gameServiceService.copyGame(courseId, gameId);
  }
  

addButton(){
  if( this.auth.getType() == 'Teacher' && this.isMyCourse === true )
  return true;
  else
  return false;
}


openSnackBar() {
    this.snack.openFromComponent(PizzaPartyComponent, {
      duration: 1000,
    });
  }

}

@Component({
  selector: 'snack-bar-component-example-snack',
  template: ' <p style="color:#fff; font-size:25px;"> game Copied 👍 </p> ',
})
export class PizzaPartyComponent {}