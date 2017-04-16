import { Component, OnInit } from '@angular/core';
import { Http } from "@angular/http";
import { GameServiceService } from "../../services/game-service.service"
import {ActivatedRoute} from '@angular/router'
import { Router } from '@angular/router'
@Component({
  selector: 'game-cards',
  templateUrl: './game-card.component.html',
  styleUrls: ['./game-card.component.css'],
  providers: [GameServiceService]
})
export class GameCardComponent implements OnInit {

  view_name = "Games";

  games = [];
  id : any;

  constructor(private http: Http, private gameServiceService: GameServiceService , private router:Router ,private aRouter: ActivatedRoute ) {

  }



  ngOnInit() {

    let id = this.aRouter.snapshot.params['id'];
    this.id = id;

    if (id){
      console.log("hey");
      
    }
    else{

    this.gameServiceService.getGames().subscribe(games => this.games = games);
        console.log(this.games);
        
    }
  }

  viewGame(id) {
      this.router.navigate(['/game',id]);
  }


}
