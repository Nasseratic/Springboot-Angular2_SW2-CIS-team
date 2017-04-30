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
    return this.http.get('http://localhost:8080/api/games/').map(this.extractData).publish().refCount();
  }


  getGamesOfcourse(id): Rx.Observable<any> {
    return this.http.get('http://localhost:8080/api/games/'+id).map(this.extractData).publish().refCount();
  }

  isMyCourse(courseId,teacherId): Rx.Observable<any>{
    return this.http.get('http://localhost:8080/api/ismycourse/'+courseId+"/"+teacherId).map(this.extractData).publish().refCount();
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  createGame(game): Rx.Observable<any> {

    let body = JSON.stringify({ 'id': "", 'name': game.name, 'courseId': game.courseId, 'category': game.category });
    console.log({ 'id': "", 'name': game.name, 'teacher': game.teacher, 'category': game.category });
    return this.http.post('http://localhost:8080/api/create/game/', body, this.options).map(this.extractData).publish().refCount();
  }


  getQs(id: string): Rx.Observable<any>{
    return  this.http.get('http://localhost:8080/api/q/'+id).map(this.extractData).publish().refCount() ;    
  }

  getGame(id: string): Rx.Observable<any>{
      return this.http.get('http://localhost:8080/api/game/'+id).map(this.extractData).publish().refCount();
  }

  addQ(id: string, q, a) {
    let body = JSON.stringify({ "q": q.q, "a": q.a, "ra": a , "gameId": id});
    this.http.post('http://localhost:8080/api/add/q/', body, this.options).publish().refCount().subscribe( 
      () => console.log(q + "added")
      
    );
  }

}
