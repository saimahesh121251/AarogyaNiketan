import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { UserComponent } from './components/user.component';
import { UserListComponent } from './components/userList.component';
import { HospitalComponent } from './components/hospital.component';
import { HospitalListComponent } from './components/hospitalList.component';
import { HomeComponent } from './components/home.component';
//import { UserListComponent } from './components/userList.component';
// import { HospitalListComponent } from './components/hospitalList.component';
// import { HospitalComponent } from './components/hospital.component';
// import { LoginComponent } from './components/login.component';

@NgModule({
  declarations: [
    NavbarComponent,
    AppComponent,
    UserComponent,
    UserListComponent,
    HospitalComponent,
    HospitalListComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}