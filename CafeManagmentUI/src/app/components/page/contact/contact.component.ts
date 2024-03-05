import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit{
  data:any;
  ngOnInit(): void {
   this.data = JSON.parse(localStorage.getItem("loginData") || "[]");
  }

}
