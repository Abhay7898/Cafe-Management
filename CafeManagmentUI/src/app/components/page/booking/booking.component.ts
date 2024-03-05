import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit{
  data:any;
  ngOnInit(): void {
   this.data = JSON.parse(localStorage.getItem("loginData") || "[]");
  }

  constructor(private router: Router) {
    localStorage.setItem("Login", "false");
  }
  login() {
    this.router.navigate(['login'])
  }
}
