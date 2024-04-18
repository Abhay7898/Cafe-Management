import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/classes/login';
import { LoginServiceService } from 'src/app/services/login-service.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userName:any;
  password:any;

  constructor (private loginService:LoginServiceService, private router:Router){
    localStorage.setItem("Home","false");
    localStorage.setItem("About","false");
    localStorage.setItem("Service","false");
    localStorage.setItem("Menu","false");
    localStorage.setItem("Contact","false");
    localStorage.setItem("DeshBoard","false");
    localStorage.setItem("SignUp","false");
  }
  

  onSubmit(){
    
    if(!this.validation()){
      return;
    }
    this.loginService.login(this.userName,this.password).subscribe(
    (data: any) => {
      console.log(JSON.stringify(data));
      localStorage.setItem("loginData",JSON.stringify(data))
      this.userName=''
      this.password=''
      localStorage.setItem("isAddminLogin", data.isAddminLogin);
      Swal.fire('Success !!',data.msg, 'success');
      this.booking();
    },
    (error) => {
      Swal.fire('Failed !!', error.error, 'error');
      console.log(error.error)
    }); 
}

  validation():boolean{
    if(this.userName==null || this.userName.trim()==''){
      this.errorAlreat('Please Enter userId....!!');  
      return false;
    }
    if(this.password==null|| this.userName.trim()==''){
      this.errorAlreat('Please Enter Password....!!')
      return false;
    }
    return true;
  }

  errorAlreat(msg:any){
    Swal.fire({
        position: 'center',
        icon: 'warning',
        title: msg,
        timer: 1000,
        showConfirmButton: false,
    })
  }
  
  booking(){
    this.router.navigate(['booking']);
  }
}
