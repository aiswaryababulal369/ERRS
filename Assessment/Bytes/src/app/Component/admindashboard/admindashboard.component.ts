import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent {
  constructor(private userService: UserService,
    private router: Router) { }
  userinfo!: User;

  ngOnInit(): void {
    this.userService.user$.subscribe(user => {
      console.log('User Information:', user);
      this.userinfo = user;
    });

    if (this.userinfo == null) {
      this.router.navigate(['/forbidden']);
    }
  }

  signOut() {
    // Clear user information when signing out
    this.userService.clearUser();
    // Redirect to the login page
    this.router.navigate(['/login']);
  }

}
