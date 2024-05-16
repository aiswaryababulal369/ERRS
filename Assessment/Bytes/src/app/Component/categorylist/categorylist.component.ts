import { Component } from '@angular/core';
import { CategoryService } from 'src/app/Service/category.service';
import { CommonService } from 'src/app/Service/common.service';
import { Category } from 'src/app/model/category.model';

@Component({
  selector: 'app-categorylist',
  templateUrl: './categorylist.component.html',
  styleUrls: ['./categorylist.component.css']
})
export class CategorylistComponent {
displayedColumns: string[]=['categoryId',
                            'categoryName',
                            'categoryDescription',
                            'update',
                            'delete'];
categoryDetails!: Category[];

constructor(private common:CommonService,
            private categoryService:CategoryService){}

ngOnInit(): void {
  this.getAllCategory();
}

public getAllCategory(){
  this.categoryService.getAllCategory().subscribe((Response: Category[])=>{
    console.log(Response);
    this.categoryDetails=Response;
  });
}

onDelete(categoryId: number) {
  this.categoryService.deleteCategory(categoryId).subscribe(() =>
      location.reload());
      this.common.openSnackBar("Category Deleted","hush");
  }

  onUpdate(arg0: any) {
  throw new Error('Method not implemented.');
  }

}
