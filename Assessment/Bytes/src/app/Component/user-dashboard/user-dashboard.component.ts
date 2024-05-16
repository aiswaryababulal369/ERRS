import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {
  
  constructor(private userService: UserService,
              private router: Router) {}
  userinfo!:User;

  // ngOnInit(): void {
  //   this.userService.user$.subscribe(user => {
  //     this.userinfo=user;
  //   });

  //   if(this.userinfo==null){
  //     this.router.navigate(['/forbidden']);
  //   }
  // }

  signOut() {
    // Clear user information when signing out
    this.userService.clearUser();
    // Redirect to the login page
    this.router.navigate(['/login']);
  }
}
