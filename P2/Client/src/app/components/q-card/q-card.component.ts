import { Component, OnInit , Input } from '@angular/core';
import {Http} from "@angular/http";
import {ActivatedRoute} from '@angular/router'
import {GameServiceService} from '../../services/game-service.service'
@Component({
  selector: 'app-q-card',
  templateUrl: './q-card.component.html',
   styles:[ `

.example-full-width {
  width: 100%;
  margin-top: 3px;
  font-size: 1.2em;

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

`] ,
providers : [GameServiceService]

})
export class QCardComponent implements OnInit {
  game_name : string;
  qs=[];
  selected=[];
  answers=[];
  id ;
  constructor(private http:Http, private router:ActivatedRoute, private gameServiceService:GameServiceService ) {

    
  }

  ngOnInit() {
    let id = this.router.snapshot.params['id'];
    this.id = id;

          this.gameServiceService.getQs(id).subscribe(qs => {this.qs = qs.qs
            this.game_name = qs.name;
            console.log(this.qs);
            
        });

    }


    log(){
       console.log(this.selected);
     }
}
