import { Injectable} from '@angular/core';
import {Http, Response, URLSearchParams, RequestOptions} from '@angular/http';
import * as Rx from "rxjs/Rx";
import {Observable}     from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';
import {Headers} from '@angular/http';

@Injectable()
export class GameServiceService {

  constructor(private http : Http) { }

    getGames(): Rx.Observable<any> {
        return this.http.get('http://localhost:8080/games/').map(this.extractData).publish().refCount();
    }

     private extractData(res: Response) {
        let body = res.json();  
        return body || {};
    }

    createGame( game ): Rx.Observable<Response>{
    
    let body = JSON.stringify( {'id':"", 'name': game.name, 'teacher': game.teacher , 'category': game.category } );
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers});
    console.log({'id':"", 'name': game.name, 'teacher': game.teacher , 'category': game.category , "qs": [ game.qs ]  });    
    return this.http.post('http://localhost:8080/create/game/', body , options ).publish().refCount();
  }

    
}
