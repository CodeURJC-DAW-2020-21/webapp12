import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Templates/home/home.component';
import { AdminComponent } from './Templates/admin/admin.component';
import { CompaniesComponent } from './Templates/companies/companies.component';
import { MessagesComponent } from './Templates/messages/messages.component';
import { MyprofilefeedComponent } from './Templates/myprofilefeed/myprofilefeed.component';
import { ProfileaccountsettingsComponent } from './Templates/profileaccountsettings/profileaccountsettings.component';
import { ProfilesComponent } from './Templates/profiles/profiles.component';
import { StoreComponent } from './Templates/store/store.component';
import { UserpageComponent } from './Templates/userpage/userpage.component';
import { SignInComponent } from './Templates/sign-in/sign-in.component';
import { ForgotPassComponent } from './Templates/forgot-pass/forgot-pass.component';

const routes: Routes = [
  {path:'new/admin',component: AdminComponent},
  {path:'new/home',component: HomeComponent},
  {path:'new/companies',component: CompaniesComponent},
  {path:'new/messages',component: MessagesComponent},
  {path:'new/myprofilefeed',component: MyprofilefeedComponent},
  {path:'new/settings',component: ProfileaccountsettingsComponent},
  {path:'new/profiles',component: ProfilesComponent},
  {path:'new/store',component: StoreComponent},
  {path:'new/userpage',component: UserpageComponent},
  {path:'new/signIn',component: SignInComponent},
  {path:'new/forgotpass',component: ForgotPassComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
