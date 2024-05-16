import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/Service/common.service';
import { LoginService } from 'src/app/Service/login.service';
import { UserService } from 'src/app/Service/user.service';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: string = '';
  userPassword: string = '';
  loginForm!: FormGroup<any>;
  submitted = false;

  constructor(private common: CommonService,
    private login: LoginService,
    private route: Router,
    private fb: FormBuilder,
    private userService: UserService) { }

  ngOnInit(): void {
    this.initForm();
  }

  get f() {
    return this.loginForm.controls;
  }

  private initForm(): void {
    this.loginForm = this.fb.group({
      userName: ['', [Validators.required]],
      userPassword: ['', [Validators.required]]
    });
  }

  signOut() {
    // Clear user information when signing out
    this.userService.clearUser();
    // Redirect to the login page
    this.route.navigate(['/login']);
  }

  onLogin() { 
    this.submitted = true;  
    
    if (this.loginForm.invalid) {
      return;
    }

    
    this.login.login(this.loginForm.value.userName, this.loginForm.value.userPassword)
  .pipe(
    catchError(error => {
      let errorMessage = 'Invalid Credientials';
      if (error.error && error.error.message) {
        errorMessage = error.error.message;
      }
      this.common.openSnackBar(errorMessage, "Close");
      return throwError(error);
    })
  )
  .subscribe(response => {
    if (response) {
      if (response.role && response.role.length > 0 && response.role[0].roleId) {
        if (response.role[0].roleId == 1) {
          this.userService.setUser(response);
          this.common.openSnackBar("Admin Logged", "Hoohoo");
          this.route.navigate(['/adminDashboard']);
        } else if (response.role[0].roleId == 2) {
          console.log(response);
          this.userService.setUser(response);
          this.common.openSnackBar("User Logged", "Hoohoo");
          this.route.navigate(['/userDashboard']);
        } else {
          this.common.openSnackBar("Invalid Credentials", "Hum");
        }
      } else {
        this.common.openSnackBar("Invalid Response Format", "Hum");
      }
    } else {
      this.common.openSnackBar("Invalid Credentials", "Hum");
    }
  });

  }



}


