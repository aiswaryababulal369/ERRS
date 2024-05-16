import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';


@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private snackBar: MatSnackBar) {}

  openSnackBar(message: string, action:string): void {
    this.snackBar.open(message, action, {
      duration: 3000,  // Duration for which the snackbar will be displayed (in milliseconds)
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
    });
  }
}
