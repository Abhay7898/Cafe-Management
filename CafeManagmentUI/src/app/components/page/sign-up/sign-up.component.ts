import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SignUp } from 'src/app/classes/sign-up';
import { SignUpService } from 'src/app/services/sign-up.service';
import Swal from 'sweetalert2';
import swal from 'sweetalert';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
   idvalue : any;
  formData = new FormData();
  files: any;

  signUp: SignUp = new SignUp();
 
  constructor(private signUpService: SignUpService, private router: Router) { }

  onSubmit() {
    if(!this.vlaidation()){
      return;
    }
    
  this.signUpService.addUser(this.signUp).subscribe((data:any)=>{
    this.uploadImage(data.id,data);
  },
  (error) => {
   Swal.fire('Failed !!', error.error.msg,'error');
  });
}
  public selectFile(event: any) {
    this.formData.append('file', event.target.files[0]);
    this.files = event.target.files[0];
  }

  public uploadImage(userId: any, data: any) {
    this.signUpService.addImage(userId, this.formData).subscribe((data1: any) => {
      Swal.fire('Success !!', 'User is added successfuly with user name ' + '<b>'+data.userName+'</b>','success',);
      this.login();
    },
      (error) => {
        console.log(error);
      }
    );

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
    if(this.files==null||this.files==''){
      this.errorAlreat("Please Select Image..!!")
      return false;
    }
    var ext = this.files.name.substring(this.files.name.lastIndexOf('.') + 1);
    if (ext.toLowerCase() != 'png' && ext.toLowerCase() != 'jpg') {
      this.errorAlreat("Selected file format is not supported..!!")
      return false;
    }

    if (this.files.size > 2000000) {
      this.errorAlreat("Selected Image < 2 MB")
      return false ;
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
