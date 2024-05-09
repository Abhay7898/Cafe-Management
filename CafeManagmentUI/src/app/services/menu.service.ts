import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../classes/menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  
  private url='http://localhost:8080/';

  constructor(private http:HttpClient) { }

  addItem(menu:Menu):Observable<Object>{
    return this.http.post(`${this.url+'createItems'}`,menu);
  }
  
  addImage(id:any,formData:any){
    return this.http.post(`${this.url+`/imageUploaded/`+id}`,formData);
  }

  getAllItem():Observable<Menu[]>{
    return this.http.get<Menu[]>(`${this.url+'getAllItems'}`);
  }

  getItemById(id:any):Observable<Menu>{
    return this.http.get<Menu>(`${this.url+`getItemsById/`+id}`)
  }

  getAllItemsByCategory(catrgoryid:any):Observable<Menu[]>{
    return this.http.get<Menu[]>(`${this.url+`getAllItemsByCategory/`+catrgoryid}`)
  }

  updateItem(menu:Menu):Observable<object>{
    return this.http.put(`${this.url+'updateItems'}`,menu)
  }

  deleteUser(id:any):Observable<Object>{
    return this,this.http.delete(`${this.url+'deleteItemsById/'+id}`)
  } 
}
