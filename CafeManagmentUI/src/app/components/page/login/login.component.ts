import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/classes/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  login:Login=new Login(); 
  
  onSubmit(){
    console.log(this.login.userName)
  }

}
