import { Component } from '@angular/core';
import { CommonService } from 'src/app/Service/common.service';
import { RewardService } from 'src/app/Service/reward.service';
import { Reward } from 'src/app/model/reward.model';

@Component({
  selector: 'app-rewardlist',
  templateUrl: './rewardlist.component.html',
  styleUrls: ['./rewardlist.component.css']
})
export class RewardlistComponent {
displayedColumns: String[]=['rewardId',
                            'rewardName',
                            'rewardDescription',
                            'byteValue',
                            'update',
                            'delete'];

rewardDetails!: Reward[];


constructor(private rewardService:RewardService,
            private common:CommonService){}
ngOnInit(): void {
  this.getAllRewards();
}

public getAllRewards(){
  this.rewardService.getAllRewards().subscribe((Response: Reward[])=>{
    this.rewardDetails=Response;
  });
}


onDelete(rewardId:number) {
  this.rewardService.deleteReward(rewardId).subscribe(() =>
      location.reload());
      this.common.openSnackBar("Reward Deleted","hush");
  }
  
updateBytes(rewardId:number) {
  throw new Error('Method not implemented.');
  }

}
