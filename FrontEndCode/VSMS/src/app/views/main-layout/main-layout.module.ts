import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutRoutingModule } from './main-layout-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OrderListComponent } from './order-list/order-list.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { OrderDetailsComponent } from './order-details/order-details.component';



@NgModule({
  declarations: [

    DashboardComponent,

    OrderListComponent,

    CreateOrderComponent,

    UpdateOrderComponent,

    OrderDetailsComponent,

  ],
  imports: [
    CommonModule,

    MainLayoutRoutingModule,

  ]
})
export class MainLayoutModule { }
