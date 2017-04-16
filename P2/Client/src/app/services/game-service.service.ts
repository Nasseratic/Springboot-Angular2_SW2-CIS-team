import { Injectable } from '@angular/core';
import { Http, Response, URLSearchParams, RequestOptions } from '@angular/http';
import * as Rx from "rxjs/Rx";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';
import { Headers } from '@angular/http';

@Injectable()
export class GameServiceService {

  headers = new Headers({ 'Content-Type': 'application/json' });
  options = new RequestOptions({ headers: this.headers });

  constructor(private http: Http) { }

  getGames(): Rx.Observable<any> {
    return this.http.get('http://localhost:8080/games/').map(this.extractData).publish().refCount();
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  createGame(game, answers) {

    let body = JSON.stringify({ 'id': "", 'name': game.name, 'teacher': game.teacher, 'category': game.category });
    console.log({ 'id': "", 'name': game.name, 'teacher': game.teacher, 'category': game.category });
    this.http.post('http://localhost:8080/create/game/', body, this.options).publish().refCount().subscribe(
      (res) => {
        console.log(game.name + " created!");
        let gameid = res['_body'];
        game.qs.forEach((q, index) => {
          this.addQ(gameid, q, answers[index]);
          console.log(q);
          console.log(answers[index]);

        });

      });
  }


  getQs(id: string): Rx.Observable<any> {
    return this.http.get('http://localhost:8080/game/'+id).map(this.extractData).publish().refCount();    
  }

  addQ(id: string, q, a) {
    let body = JSON.stringify({ "q": q.q, "a": q.a, "ra": a });
    this.http.post('http://localhost:8080/add/q/' + id, body, this.options).publish().refCount().subscribe( 
      () => console.log(q + "added")
      
    );
  }

}
