import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProductService } from 'src/app/Service/product.service';
import { RewardService } from 'src/app/Service/reward.service';
import { User } from 'src/app/model/employee.model';
import { Product } from 'src/app/model/product.model';
import { Reward } from 'src/app/model/reward.model';

@Component({
  selector: 'app-transdetails',
  templateUrl: './transdetails.component.html',
  styleUrls: ['./transdetails.component.css']
})
export class TransdetailsComponent implements OnInit {
  userDetails!:User;
  itemId!:number;
  transactionType!:string;
  productDetails!:Product;
  rewardDetails!:Reward;
  
  
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              private productService:ProductService,
              private rewardService:RewardService){}

  ngOnInit(): void {
    this.userDetails=this.data.user;
    this.itemId=this.data.itemId;
    this.transactionType=this.data.transactionType;

    if(this.transactionType=="Credit"){
      this.rewardService.getRewardById(this.itemId).subscribe((res:any)=>{
        this.rewardDetails=res;
        console.log(this.rewardDetails)
      })
    }
    else{
      this.productService.getProductById(this.itemId).subscribe((res:any) =>{
        this.productDetails=res;
      })
    }

  }


}
