import { Injectable } from '@angular/core';
import { environment } from '../Environment/environment';
import { HttpClient } from '@angular/common/http';
import { Reward } from '../model/reward.model';
import { Observable } from 'rxjs/internal/Observable';
import { UserRewards } from '../model/userrewards.model';

@Injectable({
  providedIn: 'root'
})
export class RewardService {
  
  private rewardUrl = environment.rewardUrl;
  constructor(private httpClient: HttpClient) {}

  postReward(reward:Reward){
    return this.httpClient.post(`${this.rewardUrl}/addNewReward`,reward);
  }

  getAllRewards():Observable<any> {
    return this.httpClient.get(`${this.rewardUrl}/getAllRewards`)
  }

  deleteReward(rewardId:number):Observable<any>{
    return this.httpClient.delete(`${this.rewardUrl}/deleteReward/${rewardId}`)
  }

  postUserReward(reward:UserRewards){
    return this.httpClient.post(`${this.rewardUrl}/reward/add`,reward);
  }

  getRewardById(rewardId:number){
    return this.httpClient.get(`${this.rewardUrl}/getRewardById/${rewardId}`);
  }

  

}



