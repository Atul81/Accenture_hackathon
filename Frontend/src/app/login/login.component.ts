import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { AppService } from '../app.services';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  templateUrl: './login.component.html'
})

export class LoginComponent {

  isAuthenticated: boolean = false;

  credentials = { username: '', password: '' };

  constructor(private app: AppService, private http: HttpClient, private router: Router) {
  }

  login() {
    this.app.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/');
    });
    if (this.app.authenticationError) { 
      console.log("Va;ue passed to Login");
      this.isAuthenticated = true;
    }
    return false;
  }
}