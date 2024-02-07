import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit{
  userName:any

  constructor(private router: Router) {
    localStorage.setItem("Login", "false");
  }
  ngOnInit(): void {
    this.userName=localStorage.getItem("userName")
  }
  login() {
    this.router.navigate(['login'])
  }
}
