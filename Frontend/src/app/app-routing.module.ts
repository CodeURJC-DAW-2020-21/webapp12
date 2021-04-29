import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Templates/home/home.component';
import { AdminComponent } from './Templates/admin/admin.component';
import { CompaniesComponent } from './Templates/companies/companies.component';
import { MessagesComponent } from './Templates/messages/messages.component';
import { ProfileaccountsettingsComponent } from './Templates/profileaccountsettings/profileaccountsettings.component';
import { ProfilesComponent } from './Templates/profiles/profiles.component';
import { StoreComponent } from './Templates/store/store.component';
import { UserpageComponent } from './Templates/userpage/userpage.component';
import { SignInComponent } from './Templates/sign-in/sign-in.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path:'admin',component: AdminComponent},
  {path:'home',component: HomeComponent},
  {path:'companies',component: CompaniesComponent},
  {path:'messages',component: MessagesComponent},
  {path:'settings',component: ProfileaccountsettingsComponent},
  {path:'profiles',component: ProfilesComponent},
  {path:'store',component: StoreComponent},
  {path:'userpage',component: UserpageComponent},
  {path:'signIn',component: SignInComponent},
  {path:'index',component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
