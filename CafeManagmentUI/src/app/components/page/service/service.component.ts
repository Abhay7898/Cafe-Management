import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit{
  data:any;
  ngOnInit(): void {
   this.data = JSON.parse(localStorage.getItem("loginData") || "[]");
  }
}
