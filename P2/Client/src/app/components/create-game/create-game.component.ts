import { Component, OnInit } from '@angular/core';
import { GameServiceService } from "../../services/game-service.service"
import {ActivatedRoute ,Router } from '@angular/router'
import './Game'

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styles: [`

.example-full-width {
  width: 100%;
  margin-top: 3px;
  font-size: 1em;

}
.example-radio-group {
  display: inline-flex;
  flex-direction: column;
}

.example-radio-button {
  margin: 5px;
}

.example-selected-value {
  margin: 15px 0;
}

`],
providers:[GameServiceService]
})
export class CreateGameComponent implements OnInit {
  categories = ["Math", "Science", "Programming" , "Languages"];
  game : Game;
  view = "Create New Game"
  qs = [{ "q": "", "a": [] }];
  answers = [];
  name: string;
  description: string;
  selectedtype: string;
  available= false;
  id : number;
  edit:number;
  qid = [];
  constructor(private gameService: GameServiceService , private router:Router , private aRouter : ActivatedRoute) { 
    
  }

  ngOnInit() {
    this.id = this.aRouter.snapshot.params['id'];
    this.edit = this.aRouter.snapshot.params['edit'];  
    //check if it is an edit 
    if(this.edit !== undefined){
        let game = this.gameService.getGame(String(this.edit));
        game.subscribe(
          (game)=>{
            this.name = game.name;
            this.view = "edit Game";
            this.selectedtype = game.category;
            this.available = game.available;
            this.qs.pop();  
            this.gameService.getQs(game.id).subscribe(
              (qs) => {
                qs.forEach( q => {
                    this.qid.push(q.id);
                    this.answers.push(q.ra);
                    this.qs.push({"q": q.q , "a":q.a});

                }); 
              }
            );
          }
        );
    }
}


  update(value: string, i: number) { if (value !== "") this.qs[i].a.push(value); value = ""; }

  updateQ(value: string, i: number) {  this.qs[i].q=value; }
  
  addQ() {
    this.qs.push({ "q": "", "a": [] })
    console.log(this.qs);
    console.log("this is " + this.available );

  }

  createGame() {

    let game = { 'id': this.edit , 'name': this.name, 'courseId': this.id , 'category': this.selectedtype , 'available' : this.available};
    this.gameService.createGame(game).subscribe( game => {
        this.qs.forEach((q,index)=>{ 
        this.gameService.addQ( game.id,q,this.answers[index] , this.qid[index]);
        this.router.navigate(['/game/'+game.id]);                      
        }); 
    });
    
   }

  delete(i: number) {
    if (i === 0) this.qs.splice(i, i + 1);
    else
      this.qs.splice(i, i);
    
  }

  deleteA(i: number, j: number) {
    if (j === 0) this.qs[i].a.splice(j, j + 1);
    else
      this.qs[i].a.splice(j, j);
  }
}
