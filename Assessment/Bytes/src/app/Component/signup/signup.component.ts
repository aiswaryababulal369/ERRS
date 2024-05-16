import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegisterService } from 'src/app/Service/register.service';
import { CommonService } from 'src/app/Service/common.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  firstName: string = '';
  userName:string ='';
  userPassword:string='';
  submitted = false;
  isNewEmployee: boolean = false;
  loginForm!: FormGroup<any>;


  constructor(private fb: FormBuilder,
    private service: RegisterService,
    private common: CommonService,
    private router:Router,
    private route:ActivatedRoute ) { }

  ngOnInit(): void {
    this.initForm();
    this.route.queryParams.subscribe(params => {
      this.isNewEmployee = params['isNewEmployee'] === 'true';
    console.log('Is New Employee:', this.isNewEmployee);
    });
  }

  get f() {
    return this.loginForm.controls;
  }

  private initForm(): void {
    this.loginForm = this.fb.group({
      firstName: ['', [Validators.required]],
      userName: ['', [Validators.required]],
      userPassword: ['', [Validators.required]]
    });
  }

 


  onSubmit() {
    this.submitted = true;
    if (this.loginForm.valid) {
      const user = this.loginForm.value;
      user.role = [{ roleId: 2, roleName: 'User', roleDescription: 'Default role for newly created record' }];
      user.currentBytes = 0;
      user.totalBytes = 0;
      
      this.service.postUser(user).subscribe(
        {
        next:response => {
          console.log('Post request successful:', response);
          if (this.isNewEmployee) {
            this.common.openSnackBar("New Employee Added", "Dismiss");
            this.router.navigate(['/adminDashboard/employeelist']);
          } else {
            this.common.openSnackBar("Employee Registered", "Dismiss");
            this.router.navigate(['/login']);
          }
          console.log(response);
        },
        error: (error) => {
          console.error('Error occurred during post request:', error);
          if (error.error === "Username already exists") {
            this.common.openSnackBar("Username already exists", "Dismiss");
          } else {
            this.common.openSnackBar("Unable to Add Employee", "Dismiss");
          }
        }
      }
      );
    } 
    else {
      console.log('Form is invalid.');
      this.common.openSnackBar("Unable Add Employee.Please fill out all required fields.", "Dismiss");
      this.loginForm.markAllAsTouched();
    }
  }


}



