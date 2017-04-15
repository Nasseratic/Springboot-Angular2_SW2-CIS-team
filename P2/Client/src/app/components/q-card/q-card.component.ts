import { Component, OnInit , Input } from '@angular/core';
import {Http} from "@angular/http";
import {ActivatedRoute} from '@angular/router'
import {QServiceService} from '../../services/q-service.service'
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
providers : [QServiceService]

})
export class QCardComponent implements OnInit {
  gamme_name : string;
  qs=[];
  selected=[];
  id ;
  constructor(private http:Http, private router:ActivatedRoute, private qServiceService:QServiceService ) {

    
  }

  ngOnInit() {
    let id = this.router.snapshot.params['id'];
    this.id = id;

   this.qServiceService.getQs(id).subscribe(qs => this.qs = qs);
    /*
    let id = this.router.snapshot.params['id'];
    this.id = id;
    this.http.get('/src/'+id+'.json')
      .map(response => response.json())
      .subscribe( (res) => this.qs = (res)  );
    */

      }


    log(){
       console.log(this.selected);
          
       
     }
}
