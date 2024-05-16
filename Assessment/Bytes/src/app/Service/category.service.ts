import { Injectable } from '@angular/core';
import { environment } from '../Environment/environment';
import { HttpClient } from '@angular/common/http';
import { Category } from '../model/category.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private categoryUrl = environment.categoryUrl;
  constructor(private httpClient: HttpClient) {}

  postCategory(category:Category){
    return this.httpClient.post(`${this.categoryUrl}/addNewCategory`,category);
  }

  getAllCategory():Observable<any> {
    return this.httpClient.get(`${this.categoryUrl}/getAllCategory`)
  }

  deleteCategory(categoryId:number):Observable<any>{
    return this.httpClient.delete(`${this.categoryUrl}/deleteCategory/${categoryId}`)
  }
}
