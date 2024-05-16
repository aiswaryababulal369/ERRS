import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonService } from 'src/app/Service/common.service';
import { RewardService } from 'src/app/Service/reward.service';

@Component({
  selector: 'app-newreward',
  templateUrl: './newreward.component.html',
  styleUrls: ['./newreward.component.css']
})
export class NewrewardComponent {


rewardForm!: FormGroup<any>;
constructor(private fb: FormBuilder,
            private rewardService : RewardService,
            private common:CommonService){}
submitted = false;



ngOnInit(): void {
  this.initForm();
}

get f() {
  return this.rewardForm.controls;
}

private initForm(): void {
  this.rewardForm = this.fb.group({
    rewardName: ['', [Validators.required]],
    rewardDescription: ['', [Validators.required]],
    byteValue: ['', [Validators.required]]
  });
}
onSubmit() {
  this.submitted = true;
  const reward =this.rewardForm.value;
    if (this.rewardForm.valid) {
      this.rewardService.postReward(reward).subscribe((res)=>{
        this.common.openSnackBar("Reward Added", "Dismiss");
        this.rewardForm.reset();
      });
    }
    else{
      this.common.openSnackBar("Reward Added Failed", "Dismiss");

    }
  }

  clear() {
    this.submitted = false;
    this.rewardForm.reset();
    }

}
