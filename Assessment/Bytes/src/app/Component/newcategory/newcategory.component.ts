import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CategoryService } from 'src/app/Service/category.service';
import { CommonService } from 'src/app/Service/common.service';

@Component({
  selector: 'app-newcategory',
  templateUrl: './newcategory.component.html',
  styleUrls: ['./newcategory.component.css']
})
export class NewcategoryComponent {
  categoryForm!: FormGroup<any>;
  constructor(private fb: FormBuilder,
    private categoryService: CategoryService,
    private common: CommonService) { }
  submitted = false;



  ngOnInit(): void {
    this.initForm();
  }

  get f() {
    return this.categoryForm.controls;
  }

  private initForm(): void {
    this.categoryForm = this.fb.group({
      categoryName: ['', [Validators.required]],
      categoryDescription: ['', [Validators.required]]
    });
  }
  onSubmit() {
    this.submitted = true;
    const category = this.categoryForm.value;
    if (this.categoryForm.valid) {
      this.categoryService.postCategory(category).subscribe((res) => {
        this.categoryForm.reset();
        this.common.openSnackBar("Category Added", "Dismiss");
      });
    }
    else {
      this.common.openSnackBar("Category Adding Failed", "Dismiss");

    }
  }

  clear() {
    this.submitted = false;
    this.categoryForm.reset();
  }

}
