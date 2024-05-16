import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from 'src/app/Service/category.service';
import { CommonService } from 'src/app/Service/common.service';
import { ProductService } from 'src/app/Service/product.service';
import { Category } from 'src/app/model/category.model';
import { FileHandle } from 'src/app/model/filehandle.model';
import { Product } from 'src/app/model/product.model';

@Component({
  selector: 'app-newproduct',
  templateUrl: './newproduct.component.html',
  styleUrls: ['./newproduct.component.css']
})
export class NewproductComponent {

  productForm!: FormGroup<any>;
  submitted = false;
  productImage!: File ; 
  isEditMode: boolean = false;
  categories: Category[] = []

  product: Product={
      productId:0,
      productName: '',
      productDescription: '',
      productCategory: '',
      manufacturer: '',
      expiryDate: new Date(),
      quantityAvailable: 0,
      termsAndConditions: '',
      featuredStatus: '',
      availabilityStatus: '',
      additionalMetadata: '',
      pointsInBytes: 0,
      productImage: []
  }
  image:string="";

  constructor(private fb: FormBuilder,
    private common: CommonService,
    private productService: ProductService,
    private sanitizer: DomSanitizer,
    private route: ActivatedRoute,
    private categoryService: CategoryService,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.productForm = this.fb.group({
      productName: ['', Validators.required],
      productDescription: ['', Validators.required],
      productCategory: ['', Validators.required],
      manufacturer: ['', Validators.required],
      expiryDate: ['', Validators.required],
      quantityAvailable: ['', Validators.required],
      termsandConditions: ['', Validators.required],
      featuredStatus: ['', Validators.required],
      availabilityStatus: ['', Validators.required],
      additionalMetadata: ['', Validators.required],
      pointsInBytes: ['', Validators.required],
      productImage:[[],Validators.required]
    });

    

    this.categoryService.getAllCategory().subscribe((Response)=>{
      this.categories=Response;
    });

    const isEditMode = this.data.isEditMode;

    if (isEditMode) {
      this.isEditMode = true;
      const product= this.data.product;

      this.productForm.patchValue({
        productName: product.productName,
        productDescription: product.productDescription,
        productCategory: product.productCategory,
        manufacturer:product.manufacturer,
        expiryDate:product.expiryDate,
        termsandConditions:product.termsandConditions,
        featuredStatus:product.featuredStatus,
        quantityAvailable:product.quantityAvailable,
        availabilityStatus:product.availabilityStatus,
        additionalMetadata:product.additionalMetadata,
        pointsInBytes:product.pointsInBytes,   
    });  
    console.log(this.data.product,"datalisy")
     this.image= 'data:image/png;base64,' + this.data.product.productImages[0].imageByte;
  }

  }

  onSubmit() {
    if(this.isEditMode){
      this.updateProduct();
    }
    else{
      this.addProduct();
    }
  }

  addProduct() {
    const prepareFormData = this.prepareFormData(this.product);
    if (this.productForm.valid) {
        this.productService.postUser(prepareFormData).subscribe((response) => {
            this.common.openSnackBar("Product Added", "Dismiss");
            this.productForm.reset();
        });
    } else {
        this.common.openSnackBar("Unable to Add Product", "Dismiss");
        this.productForm.markAllAsTouched();
    }
}

  prepareFormData(product:Product):FormData{
    const formData= new FormData();

    formData.append('product', 
    new Blob([JSON.stringify(this.productForm.value)] , {type:'application/json'}));

    for (const fileHandle of product.productImage) {
      formData.append('file', fileHandle.file, fileHandle.file.name);
    }
    return formData;
  }

  onFileSelected(event: any) {
    if(event.target.files){
      const file= event.target.files[0];
      console.log(file)

      const filehandle:FileHandle={
        file:file,
        url : this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file))
      }
      this.product.productImage.push(filehandle);
      console.log(this.productImage);
    }
  }

  updateProduct() {
    const prepareFormData = this.prepareFormData(this.product);
    if (this.productForm.valid) {
        this.productService.updateProduct(prepareFormData).subscribe((response) => {
            this.common.openSnackBar("Product Updated", "Dismiss");
            // Handle any additional logic for product update
        });
    } else {
        this.common.openSnackBar("Unable to Update Product", "Dismiss");
        this.productForm.markAllAsTouched();
    }
  }
  

}
