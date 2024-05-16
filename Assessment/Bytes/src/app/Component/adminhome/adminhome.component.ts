import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit{
  userDetails!: User[];
  sortedUserDetails!: User[];

  constructor(private userService: UserService){}

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((Response: User[]) => {
      this.userDetails = Response;
      this.sortedUserDetails = [...this.userDetails].sort((a, b) => b.totalBytes - a.totalBytes);
    });
  }  
}