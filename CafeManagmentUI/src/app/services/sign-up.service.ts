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
  
  addUser(signUp:SignUp):Observable<Object>{
    return this.http.post(`${this.url+'creatUser'}`,signUp)
  }
  addImage(id:any,formData:any){
    return this.http.post(`${this.url+`imageUpload/`+id}`,formData);
  }

  getAllUser():Observable<SignUp[]>{
    return this.http.get<SignUp[]>(`${this.url+`/getAllUser`}`)
  }

  getUserById(id:any):Observable<SignUp>{
    return this.http.get<SignUp>(`${this.url+`getUserById/`+id}`)
  }

  updateUser(signUp:SignUp):Observable<object>{
    return this.http.put(`${this.url+'updateUser'}`,signUp)
  }

  deleteUser(id:any):Observable<Object>{
    return this,this.http.delete(`${this.url+'deleteUser/'+id}`)
  } 
}
