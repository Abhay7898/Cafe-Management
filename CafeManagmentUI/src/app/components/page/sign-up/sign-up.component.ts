import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { SignUp } from 'src/app/classes/sign-up';
import { SignUpService } from 'src/app/service/sign-up.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  formData = new FormData();
  files: any;

  signUp: SignUp = new SignUp();
  constructor(private signUpService: SignUpService, private router: Router) { }

  onSubmit() {
    if(!this.vlaidation()){
      return;
    }
    
  this.signUpService.signUp(this.signUp).subscribe((data:any)=>{
    Swal.fire('Success !!', 'User is added successfuly with user name ' + data.userName, 'success',);
    this.login();
  },
  (error) => {
   Swal.fire('Failed !!', error.error,'error');
  });
}



  public selectFile(event: any) {
    this.formData.append('file', event.target.files[0]);
    this.files = event.target.files[0];
  }


  vlaidation():boolean{
    if(this.signUp.userName==null||this.signUp.userName.trim==''){
      this.errorAlreat('Please Enter User Name..!!')
      return false;
    }
    if(this.signUp.password==null||this.signUp.password.trim==''){
      this.errorAlreat('Please Enter Password..!!')
      return false;
    }
    if(this.signUp.confrimPassword==null||this.signUp.confrimPassword.trim==''){
      this.errorAlreat('Please Enter Confrim Password..!!')
      return false;
    }
    if(this.signUp.password!=this.signUp.confrimPassword){
      this.errorAlreat('Both Password Not Match..!!')
      return false;
    }
    if(this.signUp.firstName==null||this.signUp.firstName.trim==''){
      this.errorAlreat('Please Enter First Name..!!')
      return false;
    }
    if(this.signUp.lastName==null||this.signUp.lastName.trim==''){
      this.errorAlreat('Please Enter Last Name..!!')
      return false;
    }
    if(this.signUp.mobileNumber==null||this.signUp.mobileNumber.trim==''){
      this.errorAlreat('Please Enter Mobile Number..!!')
      return false;
    }
    if(this.signUp.emailId==null||this.signUp.emailId.trim==''){
      this.errorAlreat('Please Enter EmailId..!!')
      return false;
    }
    if(this.signUp.city==null||this.signUp.city.trim==''){
      this.errorAlreat('Please Enter City..!!')
      return false;
    }
    if(this.signUp.address==null||this.signUp.address.trim==''){
      this.errorAlreat('Please Enter Address..!!')
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

  login(){
    this.router.navigate(['login'])
  }
}
