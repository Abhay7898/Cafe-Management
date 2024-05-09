import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import Swal from 'sweetalert2';
import { FooterComponent } from '../../util/footer/footer.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userName: any;
  password: any;

  constructor(private loginService: LoginServiceService, private router: Router) {
    // localStorage.setItem("home","false");
    // localStorage.setItem("about","false");
    // localStorage.setItem("menu","false");
    // localStorage.setItem("service","false");
    // localStorage.setItem("contact","false");
    // localStorage.setItem("menu","false");
    // localStorage.setItem("booking","false");
    // localStorage.setItem("team","false");
    // localStorage.setItem("testimonial","false");
    // localStorage.setItem("deshboard","false");
  }
  onSubmit() {
    if (!this.validation()) {
      return;
    }
    this.loginService.login(this.userName, this.password).subscribe(
      (data: any) => {
        console.log(JSON.stringify(data));
        localStorage.setItem("loginData", JSON.stringify(data));
        this.userName = '';
        this.password = '';
        localStorage.setItem("isAdmin", data.addminLogin);
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Login Successfully",
          showConfirmButton: false,
          timer: 1000
        });
        localStorage.setItem("isLogin", "true");
        console.log(data.addminLogin);
        if (data.addminLogin==true) {
          this.dashboard();
        } else {
         this.home(); 
        }
      },
      (error) => {
        Swal.fire('Failed !!', error.error.msg, 'error');
        console.log(error.error);
      });
  }

  validation(): boolean {
    if (this.userName == null || this.userName.trim() == '') {
      this.errorAlreat('Please Enter userId....!!');
      return false;
    }
    if (this.password == null || this.userName.trim() == '') {
      this.errorAlreat('Please Enter Password....!!');
      return false;
    }
    return true;
  }
  errorAlreat(msg: any) {
    Swal.fire({
      position: 'center',
      icon: 'warning',
      title: msg,
      timer: 1000,
    });
  }

  home() {
    this.router.navigate(['/']);
  }
  dashboard() {
    this.router.navigate(['dashboard']);
  }
}
