import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testimonial',
  templateUrl: './testimonial.component.html',
  styleUrls: ['./testimonial.component.css']
})
export class TestimonialComponent implements OnInit{
  data:any;
  ngOnInit(): void {
   this.data = JSON.parse(localStorage.getItem("loginData") || "[]");
  }

}
