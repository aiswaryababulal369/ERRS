import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Component/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatGridListModule} from '@angular/material/grid-list';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './Component/signup/signup.component';
import { LoginComponent } from './Component/login/login.component';
import { AboutComponent } from './Component/about/about.component';
import { TestimonialsComponent } from './Component/testimonials/testimonials.component';
import { ShopComponent } from './Component/shop/shop.component';
import { ContactComponent } from './Component/contact/contact.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from './Component/admindashboard/admindashboard.component';
import { UserDashboardComponent } from './Component/user-dashboard/user-dashboard.component';
import { NewproductComponent } from './Component/newproduct/newproduct.component';
import { AdminhomeComponent } from './Component/adminhome/adminhome.component';
import { ProductlistComponent } from './Component/productlist/productlist.component';
import {MatTableModule} from '@angular/material/table';
import { ImageviewComponent } from './Component/imageview/imageview.component';
import {MAT_DIALOG_DATA, MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import { EmployeelistComponent } from './Component/employeelist/employeelist.component';
import { NewrewardComponent } from './Component/newreward/newreward.component';
import { RewardlistComponent } from './Component/rewardlist/rewardlist.component';
import { NewcategoryComponent } from './Component/newcategory/newcategory.component';
import { CategorylistComponent } from './Component/categorylist/categorylist.component';
import { ForbiddenComponent } from './Component/forbidden/forbidden.component';
import { BytesallocaterComponent } from './Component/bytesallocater/bytesallocater.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatSelectModule} from '@angular/material/select';
import { UserprofileComponent } from './Component/userprofile/userprofile.component';
import { UserhomeComponent } from './Component/userhome/userhome.component';
import { RanklistComponent } from './Component/ranklist/ranklist.component';
import { BulkpointallocaterComponent } from './Component/bulkpointallocater/bulkpointallocater.component';
import { TransactionhistoryComponent } from './Component/transactionhistory/transactionhistory.component';
import { TransdetailsComponent } from './Component/transdetails/transdetails.component';
import { OrderhistroyComponent } from './Component/orderhistroy/orderhistroy.component';





@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    AboutComponent,
    TestimonialsComponent,
    ShopComponent,
    ContactComponent,
    AdmindashboardComponent,
    UserDashboardComponent,
    NewproductComponent,
    AdminhomeComponent,
    ProductlistComponent,
    ImageviewComponent,
    EmployeelistComponent,
    NewrewardComponent,
    RewardlistComponent,
    NewcategoryComponent,
    CategorylistComponent,
    ForbiddenComponent,
    BytesallocaterComponent,
    UserprofileComponent,
    UserhomeComponent,
    RanklistComponent,
    BulkpointallocaterComponent,
    TransactionhistoryComponent,
    TransdetailsComponent,
    OrderhistroyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatGridListModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule,
    RouterModule,
    MatTableModule,
    MatDialogModule,
    MatCheckboxModule,
    MatSelectModule
  ],
  providers: [{ provide: MatDialogRef, useValue: {} },
    { provide: MAT_DIALOG_DATA, useValue: [] }],
    bootstrap: [AppComponent]
})
  
export class AppModule { }
