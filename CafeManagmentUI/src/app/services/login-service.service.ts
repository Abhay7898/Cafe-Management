import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private url='http://localhost:8080/';

  constructor(private http:HttpClient) { }

  login(userName:any,password:any):Observable<Object>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("userName",userName);
    queryParams = queryParams.append("password",password);
    const url = this.url+'login';
    return this.http.get<Object>(url,{params:queryParams});
  }
}
