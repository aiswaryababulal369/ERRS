import { Component } from '@angular/core';
import { ProductService } from 'src/app/Service/product.service';
import { RewardService } from 'src/app/Service/reward.service';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';
import { Product } from 'src/app/model/product.model';
import { Reward } from 'src/app/model/reward.model';
import { Transaction } from 'src/app/model/transaction.model';

@Component({
  selector: 'app-orderhistroy',
  templateUrl: './orderhistroy.component.html',
  styleUrls: ['./orderhistroy.component.css']
})
export class OrderhistroyComponent {
  userId:any;
  rewardDetails!:Reward;
  productDetails!:Product;
  orderDetails: Transaction[]=[];
  userinfo!: User;
  displayedColumns: String[] = ['transactionId',
                    'transactionType',
                    "date",
                    'prId',
                    'pointsInBytes'

                    ];

  

  constructor(private userService:UserService,
              private rewardService :RewardService,
              private productService:ProductService){}

  ngOnInit(): void {
    this.userService.user$.subscribe(user => {
      console.log('User Information:', user);
      this.userinfo = user;
    });
    this.userService.orderhistory(this.userinfo.userId).subscribe((res:any) =>{
      this.orderDetails=res;
      console.log(this.orderDetails);
    });
  }
  
  // getProductNameOrRewardName(transaction: Transaction): string {
  //   if (transaction.transactionType === 'Credit') {
  //     this.rewardService.getRewardById(transaction.itemId).subscribe(
  //       (reward: any) => (this.rewardDetails = reward)
  //     );
  //     return this.rewardDetails.rewardName || 'Loading...';
  //   } else {
  //     this.productService.getProductById(transaction.itemId).subscribe(
  //       (product: any) => (this.productDetails = product)
  //     );
  //     return this.productDetails.productName || 'Loading...';
  //   }
  // }
}
