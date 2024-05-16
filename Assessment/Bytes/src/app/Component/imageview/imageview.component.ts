import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-imageview',
  templateUrl: './imageview.component.html',
  styleUrls: ['./imageview.component.css']
})
export class ImageviewComponent {
    constructor(@Inject(MAT_DIALOG_DATA) public data: any){}
    image:string="";

    ngOnInit(){ 
     console.log(this.data)
    this.image= 'data:image/png;base64,' + this.data.product.imageByte;
    }
}
