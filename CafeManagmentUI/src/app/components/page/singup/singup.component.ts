import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SingupComponent implements OnInit {
  ngOnInit(): void {
    console.log('OnInit');
  }


  updateQuestionSubmit(){
    console.log("Hello A");
  }

}
