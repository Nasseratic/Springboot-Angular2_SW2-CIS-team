import { Injectable } from '@angular/core';
import {Http, Response, URLSearchParams, RequestOptions} from '@angular/http';
import * as Rx from "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';

@Injectable()
export class QServiceService {
constructor(private http : Http) { }

    getQs(id:string): Rx.Observable<any> {
        return this.http.get('/src/'+id+'.json').map(this.extractData).publish().refCount();
    }

     private extractData(res: Response) {
        let body = res.json();  
        return body || {};
    }

}
