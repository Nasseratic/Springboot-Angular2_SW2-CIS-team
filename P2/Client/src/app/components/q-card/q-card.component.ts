import { Component, OnInit , Input } from '@angular/core';
import {Http} from "@angular/http";
import {ActivatedRoute ,Router } from '@angular/router'
import {GameServiceService} from '../../services/game-service.service'
import {MdDialog, MdDialogRef} from "@angular/material";
import {
  trigger,
  state,
  style,
  animate,
  transition,
  keyframes
} from '@angular/animations';

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
  decision :string;   
  constructor(private http:Http, private aRouter:ActivatedRoute, private gameServiceService:GameServiceService ,public dialog: MdDialog , private router:Router ) {

    
  }

    correctingDialog() {
       let dialogRef: MdDialogRef<DialogResultExampleDialog1>;

        dialogRef = this.dialog.open(DialogResultExampleDialog1);
        dialogRef.componentInstance.answers = this.answers;
        dialogRef.componentInstance.selected = this.selected;
        dialogRef.componentInstance.doNext();
        dialogRef.componentInstance.height = this.answers.length * 40; 
                
        dialogRef.afterClosed().subscribe( () =>  {

           if(dialogRef.componentInstance.decision == "back"){
                this.back();
            }
            else if(dialogRef.componentInstance.decision == "replay"){
              this.selected =[];
            }
        });
        
}

  ngOnInit() {
    let id = this.aRouter.snapshot.params['id'];
    this.id = id;

          this.gameServiceService.getQs(id).subscribe(qs => {this.qs = qs.qs
            this.game_name = qs.name;
            this.qs.forEach(q => {
            this.answers.push(q.ra)                                           
          });                       
        });

    }


    back(){
      this.router.navigate(['../']);
    }



}




@Component({
  selector: 'dialog-result-example-dialog',
  templateUrl: 'correcting.html'
  ,
  styles:[ `

.example-full-width {
  width: 100%;
  margin: 3px;
  min-width: 210px;
}

`] ,
animations: [
  trigger('flyInOut', [
    state('in', style({transform: 'translateX(0)'})),
    transition('void => *', [
      animate(700, keyframes([
        style({opacity: 0, transform: 'translateX(-100%)', offset: 0.3}),
        style({opacity: 1, transform: 'translateX(15px)',  offset: 0.5}),
        style({opacity: 1, transform: 'translateX(0)',     offset: 1.0})
      ]))
    ]),
    transition('* => void', [
      animate(700, keyframes([
        style({opacity: 1, transform: 'translateX(0)',     offset: 0}),
        style({opacity: 1, transform: 'translateX(-15px)', offset: 0.7}),
        style({opacity: 0, transform: 'translateX(100%)',  offset: 1.0})
      ]))
    ])
  ]),
  trigger('fly', [
    state('in', style({transform: 'translateX(0)'})),
    transition('void => *', [
      animate(500, keyframes([
        style({opacity: 0, offset: 0.3}),
        style({opacity: 0.5,offset: 0.5}),
        style({opacity: 1, offset: 1.0})
      ]))
    ])
  ]),
  
]
})

export class DialogResultExampleDialog1 {
  selected=[];
  answers=[];
  decision :string; 
  next : number = 0;
  correct: number = null;
  result: number = null;  
  corrected: any[] = [];
  height : number = 25;
    constructor(public dialog: MdDialog,public dialogRef: MdDialogRef<DialogResultExampleDialog1>) {
  }

 close() {
    this.dialog.closeAll();
      }


      doNext() {
      if(this.next < this.answers.length) {      
      if(this.selected[this.next] === this.answers[this.next]){
      this.corrected.push({"is":true ,"selected":this.selected[this.next++]}); this.correct++;
      }
      else
      this.corrected.push({"is":false ,"selected":this.selected[this.next++]});
    }
    else{
        this.result = this.correct;
    }

  }


}