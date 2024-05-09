import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit{
   isDeshboard=false;
  
  constructor(private router:Router){
  } 
  ngOnInit(): void {
    if(localStorage.getItem("isAdmin")=="true"){
      this.isDeshboard=true;
    }
  }
deshboard(){
    this.router.navigate(['dashboard']);
}
}
