import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../model/product.model';
import { environment } from '../Environment/environment';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl = environment.productUrl;
  constructor(private httpClient: HttpClient) {}

  

  postUser(product: FormData): Observable<any> {
    return this.httpClient.post(`${this.productUrl}/addNewProduct`,product);
  }


  getAllProducts():Observable<any>{
    return this.httpClient.get(`${this.productUrl}/getAllProducts`)
  }

  deleteProduct(productId:number):Observable<any>{
    return this.httpClient.delete(`${this.productUrl}/deleteProduct/${productId}`)
  }

  getProductById(productId:number){
    return this.httpClient.get(`${this.productUrl}/getProductById/${productId}`)
  }

  updateProduct(product: FormData): Observable<any> {
    return this.httpClient.post(`${this.productUrl}/updateproduct`,product);
  }

}
