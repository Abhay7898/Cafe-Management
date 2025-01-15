import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/page/home/home.component';
import { AboutComponent } from './components/page/about/about.component';
import { ServiceComponent } from './components/page/service/service.component';
import { MenuComponent } from './components/page/menu/menu.component';
import { ContactComponent } from './components/page/contact/contact.component';
import { BookingComponent } from './components/page/booking/booking.component';
import { LoginComponent } from './components/page/login/LoginComponent';
import { TestimonialComponent } from './components/page/testimonial/testimonial.component';
import { TeamComponent } from './components/page/team/team.component';
import { SignUpComponent } from './components/page/sign-up/sign-up.component';
import { ReadMoreComponent } from './components/page/read-more/read-more.component';
import { TermsConditionComponent } from './components/page/terms-condition/terms-condition.component';
import { OrderComponent } from './components/page/order/order.component';
import { DashboardComponent } from './components/ADMIN/dashboard/dashboard.component';
import { FooterComponent } from './components/util/footer/footer.component';
import { OrderviewComponent } from './components/ADMIN/orderview/orderview.component';

const routes: Routes = [
  
  {
    path:'',
    pathMatch:'full',
    component:HomeComponent
  },
  {
    path:'login',
    pathMatch:'full',
    component:LoginComponent
  },
  {
    path:'signUp',
    pathMatch:'full',
    component:SignUpComponent
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
  {
    path:'testimonial',
    pathMatch:'full',
    component:TestimonialComponent
  },
  {
    path:'team',
    pathMatch:'full',
    component:TeamComponent
  },
  {
    path:'read-more',
    pathMatch:'full',
    component:ReadMoreComponent
  },
  {
    path:'terms-condition',
    pathMatch:'full',
    component:TermsConditionComponent
  },
  {
    path:'order',
    pathMatch:'full',
    component:OrderComponent
  },
  {
    path:'dashboard',
    pathMatch:'full',
    component:DashboardComponent
  },
  {
    path:'footer',
    pathMatch:'full',
    component:FooterComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
