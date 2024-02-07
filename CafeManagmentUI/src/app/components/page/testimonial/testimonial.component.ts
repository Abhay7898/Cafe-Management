import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testimonial',
  templateUrl: './testimonial.component.html',
  styleUrls: ['./testimonial.component.css']
})
export class TestimonialComponent implements OnInit{
  userName:any;
  ngOnInit(): void {
    this.userName=localStorage.getItem("userName");
  }

}
