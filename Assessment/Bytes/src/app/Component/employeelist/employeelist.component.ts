import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';
import { UserService } from 'src/app/Service/user.service';
import { User } from 'src/app/model/employee.model';
import { BytesallocaterComponent } from '../bytesallocater/bytesallocater.component';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CommonService } from 'src/app/Service/common.service';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {



  userDetails!: User[];
  user: any;
  displayedColumns: String[] = ['userId',
    'userName',
    'firstName',
    'currentBytes',
    'totalBytes',
    'update']

  constructor(private userService: UserService,
    public dialog: MatDialog,
    private common: CommonService,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<BytesallocaterComponent>,
    private router: Router,
    private cdr: ChangeDetectorRef) { }
  ngOnInit(): void {
    this.getAllUsers();
  }
  getAllUsers() {
    this.userService.getAllUsers().subscribe((Response: User[]) => {
      this.userDetails = Response;
      this.cdr.detectChanges();
    });
  }

  addBytes(userId: number) {
    this.dialog.open(BytesallocaterComponent, {
      height: '550px',
      width: '500px',
      data:
      {
        userId: userId
      }
    });

    this.dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.getAllUsers(); // Refresh the table after closing the dialog
      }
    });
  }
  onDelete(userId: number) {
    this.userService.deleteUser(userId).subscribe(() =>
      location.reload());
    this.common.openSnackBar("User Deletd", "Close");
    // this.getAllUsers();
  }

  bulkallocate() {
    this.router.navigate(['adminDashboard/bulkpointallocater']);
  }



}
