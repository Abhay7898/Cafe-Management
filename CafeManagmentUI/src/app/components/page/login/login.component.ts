import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/classes/login';
import { LoginServiceService } from 'src/app/service/login-service.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userName:any;
  password:any;

  constructor (private loginService:LoginServiceService, private router:Router){}
  

  onSubmit(){
    
    if(!this.validation()){
      return;
    }
    this.loginService.login(this.userName,this.password).subscribe(
    (data: any) => {
      localStorage.setItem("userName",data.userName)
      this.userName=''
      this.password=''
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
    this.router.navigate(['booking'])
  }
}
