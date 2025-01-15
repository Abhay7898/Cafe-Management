import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './components/page/about/about.component';
import { BookingComponent } from './components/page/booking/booking.component';
import { ContactComponent } from './components/page/contact/contact.component';
import { MenuComponent } from './components/page/menu/menu.component';
import { ServiceComponent } from './components/page/service/service.component';
import { TeamComponent } from './components/page/team/team.component';
import { TestimonialComponent } from './components/page/testimonial/testimonial.component';
import { HomeComponent } from './components/page/home/home.component';
import { NavbarComponent } from './components/util/navbar/navbar.component';
import { FooterComponent } from './components/util/footer/footer.component';
import { HeaderComponent } from './components/util/header/header.component';
import { SpinnerComponent } from './components/util/spinner/spinner.component';
import { LoginComponent } from './components/page/login/LoginComponent';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignUpComponent } from './components/page/sign-up/sign-up.component';
import { ReadMoreComponent } from './components/page/read-more/read-more.component';
import { TermsConditionComponent } from './components/page/terms-condition/terms-condition.component';
import { OrderComponent } from './components/page/order/order.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { DashboardComponent } from './components/ADMIN/dashboard/dashboard.component';
import { SidebarComponent } from './components/ADMIN/sidebar/sidebar.component';
import { OrderviewComponent } from './components/ADMIN/orderview/orderview.component';
import {MatIconModule} from '@angular/material/icon';


@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    BookingComponent,
    ContactComponent,
    MenuComponent,
    ServiceComponent,
    TeamComponent,
    TestimonialComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    HeaderComponent,
    SpinnerComponent,
    LoginComponent,
    SignUpComponent,
    ReadMoreComponent,
    TermsConditionComponent,
    OrderComponent,
    DashboardComponent,
    SidebarComponent,
    OrderviewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule,
    MatIconModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
