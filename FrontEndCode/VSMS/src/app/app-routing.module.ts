import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateOrderComponent } from './views/main-layout/create-order/create-order.component';
import { DashboardComponent } from './views/main-layout/dashboard/dashboard.component';
import { OrderDetailsComponent } from './views/main-layout/order-details/order-details.component';
import { OrderListComponent } from './views/main-layout/order-list/order-list.component';
import { UpdateOrderComponent } from './views/main-layout/update-order/update-order.component';



const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },

  {
    path: 'login',
    loadChildren: () =>
      import('./views/login-layout/login-layout.module').then(
        (m) => m.LoginLayoutModule
      )
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'order',
    component: OrderListComponent
  },
  {
    path: 'create-order',
    component: CreateOrderComponent
  },
  {
    path: 'update-order/:id',

    component: UpdateOrderComponent
  },
  {
    path: 'update-order',
    component: UpdateOrderComponent
  },
  {
    path: 'order-details/:id',
    component: OrderDetailsComponent
  },
  {
    path: 'order-details',
    component: UpdateOrderComponent
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
