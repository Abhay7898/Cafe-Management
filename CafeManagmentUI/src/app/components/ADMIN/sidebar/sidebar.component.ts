import { Component } from '@angular/core';
import { Router } from '@angular/router';

import Swal from 'sweetalert2';


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  isBooking=false;
  isLogin=true;
  isDeshboard=false;
  isLogout=false;
  isSignup=true;
  constructor(private router:Router){ 
  this.isLogin=true;
  this.isDeshboard=false;
  this.isLogout=false;
  this.isSignup=true;
  }
  
  
  ngOnInit(): void {
    if(localStorage.getItem("isAdmin")=="true"){
      this.isDeshboard=true;
    }
    if(localStorage.getItem("isLogin")=="true"){
      this.isLogin=false;
      this.isSignup=false;
      this.isBooking=true;
      this.isLogout=true;
    }
  }
  logout(){
    this.isLogin=true;
    this.isLogout=false;
    localStorage.clear();
    this.router.navigate(['/'])
    Swal.fire({
      position: "center",
      icon: "success",
      title: "Logout Successfully",
      showConfirmButton: false,
      timer: 1000
    });
    this.router.navigate(['/']); 
  }
}
