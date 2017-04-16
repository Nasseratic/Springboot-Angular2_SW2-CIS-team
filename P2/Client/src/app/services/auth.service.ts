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
export class AuthService {

  private userName = "";

  headers = new Headers({
    'Content-Type': 'application/json'
  });


  constructor(private http:Http) {}
//: Rx.Observable<Response>
  signUp( user ): Rx.Observable<any>{
    
    let body = JSON.stringify({ "name":user.name , "pw":user.pw , "id":user.id , "email":user.email});
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers});
    return this.http.post('http://localhost:8080/api/create/user/', body , options );
    
  }

  setUser(name:string , type:string , id:string){
      this.userName = name;
      localStorage.setItem('currentUser',name);
      localStorage.setItem('type', type);
      localStorage.setItem('id', id);
  }
  
  getUser(){
    return this.userName;
  }

  login(loginDeta):Rx.Observable<any>{
    let body = JSON.stringify({ "email":loginDeta.email , "pw":loginDeta.pw });
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers});
    return this.http.post('http://localhost:8080/api/login/', body , options );
  }

}
