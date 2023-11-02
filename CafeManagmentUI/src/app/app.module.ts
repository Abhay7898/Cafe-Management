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
import { LoginComponent } from './components/page/login/login.component';
import { SingupComponent } from './components/page/singup/singup.component';
import { FormsModule } from '@angular/forms';

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
    SingupComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
