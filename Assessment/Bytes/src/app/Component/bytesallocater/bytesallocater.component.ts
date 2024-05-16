import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import {  FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { CommonService } from 'src/app/Service/common.service';
import { RewardService } from 'src/app/Service/reward.service';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';
import { Reward } from 'src/app/model/reward.model';

@Component({
  selector: 'app-bytesallocater',
  templateUrl: './bytesallocater.component.html',
  styleUrls: ['./bytesallocater.component.css']
})
export class BytesallocaterComponent implements OnInit{

  bytesForm!: FormGroup<any>;
  userName: User[]=[];
  rewardName:Reward[]=[];

  constructor(private userService:UserService,
              private rewardService:RewardService,
              private fb:FormBuilder,
              private common:CommonService,
              public dialogRef: MatDialogRef<BytesallocaterComponent>,
              public dialog: MatDialog,
              @Inject(MAT_DIALOG_DATA) public data: any
              ){
                this.bytesForm = this.fb.group({ 
                  rewardName: ['']
                });
              }

  @Output() bytesAllocated: EventEmitter<boolean> = new EventEmitter<boolean>();

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((Response) =>{
      this.userName=Response;
    });
    console.log(this.data);
    this.rewardService.getAllRewards().subscribe((Response)=>{
      this.rewardName=Response;
    });
  }


onSubmit() {
  this.userName=this.data.userId ;
  const formData = Number(this.bytesForm.value.rewardName);
  if (this.bytesForm.valid) {
    this.userService.postUserReward({rewardId:formData,userId:this.data.userId}).subscribe((res =>{
      console.log(res);
      this.common.openSnackBar("Rewards Added Successfully","Close");
      this.dialogRef.close(true);
      this.bytesAllocated.emit(true);
      this.dialog.closeAll();
    }));
  }
  else{
    this.common.openSnackBar("Failed to point Allocate","Close");
  }
}


clear() {
  this.bytesForm.reset();
  }

}
