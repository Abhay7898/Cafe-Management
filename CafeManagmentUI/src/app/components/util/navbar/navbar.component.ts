import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  isHome=false;
  isAbout=false;
  isService=false;
  isMenu=false;
  isContact=false;
  isBooking=false;
  isTeam=false;
  isTestimonial=false;
  public constructor(){}
  ngOnInit(): void {
   this.isHome=false;
   this.isAbout=false;
   this.isService=false;
   this.isMenu=false;
   this.isContact=false;
   this.isBooking=false;
   this.isTeam=false;
   this.isTestimonial=false;
  }
  setPerametter(){
    if(localStorage.getItem("isAddminLogin")=="true"){
      this.isHome=true;
   this.isAbout=true;
   this.isService=true;
   this.isMenu=true;
   this.isContact=true;
   this.isBooking=true;
   this.isTeam=true;
   this.isTestimonial=true;
  }
}
}
