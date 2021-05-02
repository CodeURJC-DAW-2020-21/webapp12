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
import { ProfileaccountsettingsComponent } from './Templates/profileaccountsettings/profileaccountsettings.component';
import { ProfilesComponent } from './Templates/profiles/profiles.component';
import { StoreComponent } from './Templates/store/store.component';
import { UserpageComponent } from './Templates/userpage/userpage.component';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './Templates/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChartModule } from 'primeng/chart';

import { MatTabsModule } from '@angular/material/tabs';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignInComponent,
    ForgotPassComponent,
    AdminComponent,
    CompaniesComponent,
    MessagesComponent,
    ProfileaccountsettingsComponent,
    ProfilesComponent,
    StoreComponent,
    UserpageComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    MatTabsModule,
    MatIconModule,
    ChartModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatSelectModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
