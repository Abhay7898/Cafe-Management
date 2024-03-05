import { Component } from '@angular/core';

@Component({
  selector: 'app-read-more',
  templateUrl: './read-more.component.html',
  styleUrls: ['./read-more.component.css']
})
export class ReadMoreComponent {
  data:any;
  ngOnInit(): void {
   this.data = JSON.parse(localStorage.getItem("loginData") || "[]");
  }
}
