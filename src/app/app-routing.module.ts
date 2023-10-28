import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/page/home/home.component';
import { AboutComponent } from './components/page/about/about.component';
import { ServiceComponent } from './components/page/service/service.component';
import { MenuComponent } from './components/page/menu/menu.component';
import { ContactComponent } from './components/page/contact/contact.component';
import { BookingComponent } from './components/page/booking/booking.component';
import { LoginComponent } from './components/page/login/login.component';
import { SingupComponent } from './components/page/singup/singup.component';

const routes: Routes = [
  {
    path:'',
    pathMatch:'full',
    component:LoginComponent
  },
  {
    path:'singup',
    pathMatch:'full',
    component:SingupComponent
  },
  {
    path:'home',
    pathMatch:'full',
    component:HomeComponent
  },
  {
    path:'about',
    pathMatch:'full',
    component:AboutComponent
  },
  {
    path:'service',
    pathMatch:'full',
    component:ServiceComponent
  },
  {
    path:'menu',
    pathMatch:'full',
    component:MenuComponent
  },
  {
    path:'pages',
    pathMatch:'full',
    component:HomeComponent
  },
  {
    path:'contact',
    pathMatch:'full',
    component:ContactComponent
  },
  {
    path:'booking',
    pathMatch:'full',
    component:BookingComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
