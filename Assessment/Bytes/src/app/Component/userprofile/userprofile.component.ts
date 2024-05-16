import { Component } from '@angular/core';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';
import { Transaction } from 'src/app/model/transaction.model';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent {

  constructor(private userService: UserService) { }
  credits=0;
  debits=0;
  userinfo!:User;
  orderDetails!:Transaction[];

  ngOnInit(): void {
    this.userService.user$.subscribe(user => {
      this.userinfo=user;
      if (user) {
        this.userinfo.currentBytes=user.currentBytes;
      }
    });

    this.userService.orderhistory(this.userinfo.userId).subscribe((res:any)=>{
      this.orderDetails=res;
      this.credits = this.orderDetails.filter(transaction => transaction.transactionType === 'Credit').length;
      this.debits = this.orderDetails.filter(transaction => transaction.transactionType === 'Debit').length;
    });
  }

}
