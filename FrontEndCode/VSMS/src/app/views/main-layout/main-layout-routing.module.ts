import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateOrderComponent } from './create-order/create-order.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { OrderListComponent } from './order-list/order-list.component';
import { UpdateOrderComponent } from './update-order/update-order.component';




export const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',

  },
  {
    path: 'dashboard',
    component: DashboardComponent




  },


  {
    path: 'order',
    component: OrderListComponent
  },
  // {
  //   path: 'create-order',
  //   component: CreateOrderComponent
  // },
  // {
  //   path: 'update-order/:id',
  //   component: UpdateOrderComponent
  // }
  // {
  //   path: 'order-details/:id',
  //   component:OrderDetailsComponent
  // }


  // {
  //   path: 'adduser',
  //   component: AddUserComponent,
  //   canActivate: [AdminTrainigAuthGuard]
  // }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainLayoutRoutingModule { }
