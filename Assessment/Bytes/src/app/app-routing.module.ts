import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Component/home/home.component';
import { SignupComponent } from './Component/signup/signup.component';
import { LoginComponent } from './Component/login/login.component';
import { AdmindashboardComponent } from './Component/admindashboard/admindashboard.component';
import { UserDashboardComponent } from './Component/user-dashboard/user-dashboard.component';
import { NewproductComponent } from './Component/newproduct/newproduct.component';
import { AdminhomeComponent } from './Component/adminhome/adminhome.component';
import { ProductlistComponent } from './Component/productlist/productlist.component';
import { EmployeelistComponent } from './Component/employeelist/employeelist.component';
import { NewrewardComponent } from './Component/newreward/newreward.component';
import { RewardlistComponent } from './Component/rewardlist/rewardlist.component';
import { NewcategoryComponent } from './Component/newcategory/newcategory.component';
import { CategorylistComponent } from './Component/categorylist/categorylist.component';
import { BytesallocaterComponent } from './Component/bytesallocater/bytesallocater.component';
import { UserhomeComponent } from './Component/userhome/userhome.component';
import { UserprofileComponent } from './Component/userprofile/userprofile.component';
import { RanklistComponent } from './Component/ranklist/ranklist.component';
import { ForbiddenComponent } from './Component/forbidden/forbidden.component';
import { TransactionhistoryComponent } from './Component/transactionhistory/transactionhistory.component';
import { OrderhistroyComponent } from './Component/orderhistroy/orderhistroy.component';
import { BulkpointallocaterComponent } from './Component/bulkpointallocater/bulkpointallocater.component';


const routes: Routes = [
  { path: '', component : HomeComponent },
  { path: "login", component: LoginComponent},
  { path: "signup", component:SignupComponent},
  { path: "adminDashboard", component:AdmindashboardComponent,
    children: [
      { path: "" , component:AdminhomeComponent},
      { path: "newProduct", component:NewproductComponent,},
      { path: "productlist", component:ProductlistComponent,},
      { path: "employeelist", component:EmployeelistComponent,},
      { path: "bulkpointallocater", component:BulkpointallocaterComponent,},
      { path: "newreward", component:NewrewardComponent,},
      { path: "rewardlist", component:RewardlistComponent,},
      { path: "signup", component:SignupComponent, },
      { path: "newCategory", component:NewcategoryComponent, },
      { path: "categorylist", component:CategorylistComponent,},
      { path: "bytesallocate", component:BytesallocaterComponent,},
      { path: "transactionhistory", component:TransactionhistoryComponent,}
    ]},
  { path: "userDashboard", component:UserDashboardComponent,
  children: [
    { path:"userhome", component:UserhomeComponent,},
    { path:"", component:UserprofileComponent,},
    {path:"orders", component:OrderhistroyComponent,},

  ]},
  { path: "ranklist", component:RanklistComponent},
  {path: "forbidden" , component:ForbiddenComponent},
  // { path: "bulkpointallocater", component:BulkpointallocaterComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
