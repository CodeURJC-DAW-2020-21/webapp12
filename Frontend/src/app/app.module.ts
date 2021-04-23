import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Templates/home/home.component';
import { SignInComponent } from './Templates/sign-in/sign-in.component';
import { ForgotPassComponent } from './Templates/forgot-pass/forgot-pass.component';
import { AdminComponent } from './Templates/admin/admin.component';
import { CompaniesComponent } from './Templates/companies/companies.component';
import { MessagesComponent } from './Templates/messages/messages.component';
import { MyprofilefeedComponent } from './Templates/myprofilefeed/myprofilefeed.component';
import { ProfileaccountsettingsComponent } from './Templates/profileaccountsettings/profileaccountsettings.component';
import { ProfilesComponent } from './Templates/profiles/profiles.component';
import { StoreComponent } from './Templates/store/store.component';
import { UserpageComponent } from './Templates/userpage/userpage.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignInComponent,
    ForgotPassComponent,
    AdminComponent,
    CompaniesComponent,
    MessagesComponent,
    MyprofilefeedComponent,
    ProfileaccountsettingsComponent,
    ProfilesComponent,
    StoreComponent,
    UserpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
