import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/Service/common.service';
import { ProductService } from 'src/app/Service/product.service';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';
import { Product } from 'src/app/model/product.model';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  productDetails:Product[]=[];
  image:string="";
  userId:User[]=[];
  productId:Product[]=[];
  userinfo!:User;
  constructor(private productService: ProductService,
              private userService:UserService,
              private common:CommonService){}

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe((Response) =>{
      this.productDetails=Response;
      this.productDetails.forEach((product:any) => {
      product.imageView='data:image/png;base64,' +product.productImages[0].imageByte  
      });
    });

    this.userService.user$.subscribe(user => {
      this.userinfo=user;
    });
  }

  buyProduct(productId: number) {
    if (!this.userinfo || !this.userinfo.userId) {
      this.common.openSnackBar("User information not available", "Error");
      return;
    }
  
    if (productId) {
      this.userService.buyProduct({ userId: this.userinfo.userId, productId: productId })
        .subscribe(
          (res: any) => { // Update the type of the parameter to 'any'
            
            // Check the status code of the response
            if (res && res.status === 200) {
              // Product purchased successfully
              this.common.openSnackBar("Product Purchased", "Success");
            } else if (res && res.status === 400 && res.error === "Insufficient bytes to buy the product") {
              // Insufficient bytes error
              this.common.openSnackBar("Insufficient bytes to buy the product", "Error");
            } else {
              // Other errors
              this.common.openSnackBar("Product Purchased", "Success");
              location.reload;
            }
          },
          (error) => {
            console.error(error);
            // Handle other errors
            this.common.openSnackBar("Insufficient bytes to buy the product", "Close");
          }
        );
    } else {
      this.common.openSnackBar("Failed to Buy", "Error");
    }
  }
  
  
  
  
  

}
