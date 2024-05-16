import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from '../Environment/environment';
import { BehaviorSubject } from 'rxjs';
import { User } from '../model/employee.model';
import { UserRewards } from '../model/userrewards.model';
import { UserProduct } from '../model/userproduct.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { 
    const storedUser = localStorage.getItem(this.localStorageKey);
    if (storedUser) {
      this.userSubject.next(JSON.parse(storedUser));
    }
  }


  private userSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);
  public user$: Observable<any> = this.userSubject.asObservable();
  private localStorageKey = 'currentUser';

  setUser(user: User): void {
    this.userSubject.next(user);
    localStorage.setItem(this.localStorageKey, JSON.stringify(user));
  }
  clearUser(): void {
    // Clear the BehaviorSubject
    this.userSubject.next(null);
    // Clear user information from localStorage
    localStorage.removeItem(this.localStorageKey);
  }
  getAllUsers():Observable<any>{
    return this.httpClient.get(`${environment.apiUrl}/getAllUsers`)
  }

  deleteUser(userId:number):Observable<any>{
    return this.httpClient.delete(`${environment.apiUrl}/deleteUser/${userId}`)
  }

  
  postUserReward(reward:UserRewards){
    return this.httpClient.post(`${environment.apiUrl}/reward/add`,reward)
  }

  buyProduct(product:UserProduct){
    return this.httpClient.post(`${environment.apiUrl}/product/add`,product)
  }

  transactionshistory():Observable<any>{
    return this.httpClient.get(`${environment.apiUrl}/getalltransactions`)
  }

  orderhistory(userId:number):Observable<any>{
    return this.httpClient.get(`${environment.orderUrl}/user/${userId}`)
  }


  allocatePoints(employeeIds: number[], rewardId: number): Observable<any> {
    const rewardBody = {
      userIds: employeeIds,
      rewardId: rewardId
    };
    return this.httpClient.post<any>(`${environment.apiUrl}/reward/bulkadd`, rewardBody);
  }

}
