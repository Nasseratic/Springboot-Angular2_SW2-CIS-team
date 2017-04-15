import { Injectable } from '@angular/core';
import {Http, Response, URLSearchParams, RequestOptions} from '@angular/http';
import * as Rx from "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';

@Injectable()
export class CourseServiceService {

  constructor(private http : Http) { }

    getCourses(): Rx.Observable<any> {
        return this.http.get('http://localhost:8080/games/').map(this.extractData).publish().refCount();
    }

     private extractData(res: Response) {
        let body = res.json();  
        return body || {};
    }
}
