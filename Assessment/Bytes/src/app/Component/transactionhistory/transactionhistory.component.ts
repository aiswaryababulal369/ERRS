import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { UserService } from 'src/app/Service/user.service';
import { Transaction } from 'src/app/model/transaction.model';
import { TransdetailsComponent } from '../transdetails/transdetails.component';

@Component({
  selector: 'app-transactionhistory',
  templateUrl: './transactionhistory.component.html',
  styleUrls: ['./transactionhistory.component.css']
})
export class TransactionhistoryComponent implements OnInit {

  transactionDetails: Transaction[]=[];
  displayedColumns: String[] = ['transactionId',
                    'transactionType',
                    "date",
                    'prId',
                    'view'
                    ];

  

  constructor(private userService:UserService,
              public dialog: MatDialog,
              @Inject(MAT_DIALOG_DATA) public data: any){}

  ngOnInit(): void {
    this.userService.transactionshistory().subscribe((res:Transaction[])=>{
      this.transactionDetails=res;
      console.log(this.transactionDetails)
      });
  }

  onFullView(user:any,itemId:number,transactionType:string) {
    console.log(user)
    this.dialog.open(TransdetailsComponent, {
      height:'600px',
      width:'700px',
      data: 
      {user:user,itemId:itemId,transactionType:transactionType}
      
    });
   }


  
}
