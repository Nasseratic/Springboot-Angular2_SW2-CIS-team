import { Injectable } from '@angular/core';
import {Http, Response, URLSearchParams, RequestOptions , Headers} from '@angular/http';
import * as Rx from "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';
import { AuthService } from '../services/auth.service'
@Injectable()
export class CourseServiceService {

  headers = new Headers({ 'Content-Type': 'application/json' });
  options = new RequestOptions({ headers: this.headers });

  constructor(private http : Http , private auth:AuthService) { }

    getCourses(): Rx.Observable<any> {
        return this.http.get('http://localhost:8080/api/courses/').map(this.extractData).publish().refCount();
    }
    
    getCoursesByTeacher(id): Rx.Observable<any> {
        return this.http.get('http://localhost:8080/api/courses/'+id).map(this.extractData).publish().refCount();
    }
    

createCourse(name,id): Rx.Observable<any> {

    let body = JSON.stringify({"name":name , "teacherId":id});
    console.log("creating:" +name);
    console.log(body);
    return this.http.post('http://localhost:8080/api/create/course/', body, this.options).map(this.extractData).publish().refCount();
  }


     private extractData(res: Response) {
        let body = res.json();  
        return body || {};
    }
}
