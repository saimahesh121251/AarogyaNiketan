import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  providers: [],
})
export class LoginComponent {
  constructor(private router: Router) {}

  userUi() {
    this.router.navigate(['/hospitalList']);
  }
}