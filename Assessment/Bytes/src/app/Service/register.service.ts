import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/employee.model';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private url = 'http://localhost:8080/user';
  constructor(private httpClient: HttpClient) {}

  postUser(employee :User){
    return this.httpClient.post(this.url + '/registerNewUser', employee, {responseType:'text'});
  }
}
