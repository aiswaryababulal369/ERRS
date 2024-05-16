import { Injectable } from '@angular/core';
import { environment } from '../Environment/environment'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = environment.apiUrl;

  constructor(private http:HttpClient) {}

  login(userName: string, userPassword: string): Observable<any> {
    const body = { userName, userPassword };
    return this.http.post(`${this.apiUrl}/login`, body);
  }
}
