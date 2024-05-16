import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/Service/common.service';
import { RewardService } from 'src/app/Service/reward.service';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';
import { Reward } from 'src/app/model/reward.model';


@Component({
  selector: 'app-bulkpointallocater',
  templateUrl: './bulkpointallocater.component.html',
  styleUrls: ['./bulkpointallocater.component.css']
})
export class BulkpointallocaterComponent {
  allocationForm!: FormGroup;
  allocations: any[] = [];

  userName: User[] = [];
  rewardName: Reward[] = [];


  constructor(private userService: UserService,
    private rewardService: RewardService,
    private fb: FormBuilder,
    private common : CommonService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.allocationForm = this.fb.group({
      selectedEmployees: [null, Validators.required],
      rewardType: [null, Validators.required],
      otherReason: [''],
      awardedPoints: [null, Validators.required]
    });

    this.userService.getAllUsers().subscribe((Response) => {
      this.userName = Response;
    });
    this.rewardService.getAllRewards().subscribe((Response) => {
      console.log(Response);
      this.rewardName = Response;
      console.log(this.rewardName);
    });

  }


  addAllocation() {
    const selectedEmployees: number[] = this.allocationForm.value.selectedEmployees;
    const rewardId: number = this.allocationForm.get('rewardType')!.value;
console
    .log(selectedEmployees);
    

    // Call the service method to send data to the backend
    this.userService.allocatePoints(selectedEmployees, rewardId).subscribe(
      () => {
        this.common.openSnackBar('Points allocated successfully!', 'Close');
        this.router.navigate(['adminDashboard/employeelist'])
        // Optionally reset the form after successful allocation
        this.allocationForm.reset();
      },
      error => {
        console.error('Error allocating points:', error);
        this.common.openSnackBar('Error allocating points. Please try again.', 'Close')
      });


  }
}
