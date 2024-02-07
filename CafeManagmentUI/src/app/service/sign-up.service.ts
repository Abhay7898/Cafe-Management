import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUp } from '../classes/sign-up';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  private url="http://localhost:8080/";

  constructor(private http:HttpClient) { }
  
  signUp(signUp:SignUp):Observable<Object>{
    return this.http.post(`${this.url+'creatUser'}`,signUp)
  }
}
