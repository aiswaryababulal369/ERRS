import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { CommonService } from 'src/app/Service/common.service';
import { ProductService } from 'src/app/Service/product.service';
import { Product } from 'src/app/model/product.model';
import { ImageviewComponent } from '../imageview/imageview.component';
import { ActivatedRoute, Router } from '@angular/router';
import { AboutComponent } from '../about/about.component';
import { NewproductComponent } from '../newproduct/newproduct.component';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit{

  productDetails!: Product[];
  displayedColumns: String[] = ['productId',
                                'productName',
                                 'pointsInBytes',
                                 'view',
                                 'delete',
                                 'image',
                                //  'update'
                            ];
  

  constructor(private productService:ProductService,
              private common: CommonService,
              public dialog: MatDialog,
              private router:Router,
              private route:ActivatedRoute,
              @Inject(MAT_DIALOG_DATA) public data: any){}


  ngOnInit(): void {
    this.getAllProducts();
    
  }

  public getAllProducts(){
    this.productService.getAllProducts().subscribe((Response: Product[])=>{
      this.productDetails=Response;
    });
  }

  onFullView(productId:number) {
    this.dialog.open(AboutComponent, {
      height:'600px',
      width:'700px',
      data: 
      {product:productId }
    });
   }


  onDelete(productId:number) {
    console.log(productId);
    this.productService.deleteProduct(productId).subscribe(() =>
      location.reload());
      this.common.openSnackBar("Product Deletd","hush");
  } 

   onUpdate(product:object){
    this.dialog.open(NewproductComponent, {
      height:'600px',
      width:'700px',
      data: 
      { product:product,  
        isEditMode: true }
    });
    
    
   } 

   onImageView(product: any){
    this.dialog.open(ImageviewComponent, {
      height:'500px',
      width:'500px',
      data: 
      {product:product.productImages[0] }
    });
   }
}





