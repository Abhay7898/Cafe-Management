import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginComponent } from '../components/page/login/login.component';
import { LoginServiceService } from './login-service.service';

@Injectable({
  providedIn: 'root'
})
export class NormalGuardServi{
}
