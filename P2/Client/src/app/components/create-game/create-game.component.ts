import { Component, OnInit } from '@angular/core';
import { GameServiceService } from "../../services/game-service.service"

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
  categories = ["Math", "Science", "Programming"];
  qs = [{ "q": "", "a": [] }];
  answers = [];
  name: string;
  description: string;
  selectedtype: string;
  constructor(private gameService: GameServiceService) { }

  ngOnInit() {
  }


  update(value: string, i: number) { if (value !== "") this.qs[i].a.push(value); value = ""; }

  updateQ(value: string, i: number) {  this.qs[i].q=value; }
  
  addQ() {
    this.qs.push({ "q": "", "a": [] })
    console.log(this.qs);

  }

  createGame() {
    let game = { 'id': '', 'name': this.name, 'teacher': localStorage.getItem("currentUser"), 'category': this.selectedtype, 'qs': this.qs };
    this.gameService.createGame(game,this.answers);
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
