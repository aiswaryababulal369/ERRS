import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProductService } from 'src/app/Service/product.service';
import { Product } from 'src/app/model/product.model';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  productDetails!:Product;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              private productService:ProductService){}

  
  ngOnInit(): void {
    const productId = this.data.product;
    this.productService.getProductById(productId).subscribe((res:any) =>{
      this.productDetails=res;
    })
  }

  

}
