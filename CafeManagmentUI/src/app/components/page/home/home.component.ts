import { Component, OnInit } from '@angular/core';
import { OnSameUrlNavigation } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  data:any;
  isCheck=false;
  isLogin=true;
  public constructor(){
   
  }
  ngOnInit(): void {
   this.data = JSON.parse(localStorage.getItem("loginData") || "[]");

   if(localStorage.getItem("isLogin")=="true"){
    this.isLogin=true;
  }else{
    this.isLogin = false;
  }
  }
}
