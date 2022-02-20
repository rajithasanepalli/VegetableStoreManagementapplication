import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { OrderListComponent } from './views/main-layout/order-list/order-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateOrderComponent } from './views/main-layout/create-order/create-order.component';
import { UpdateOrderComponent } from './views/main-layout/update-order/update-order.component';
import { OrderDetailsComponent } from './views/main-layout/order-details/order-details.component';

// import { adminTrainingUserCheck } from './shared/constants/utils';

@NgModule({
  declarations: [AppComponent,
    OrderListComponent,
    CreateOrderComponent,
    UpdateOrderComponent,
    OrderDetailsComponent
  ],
  imports: [
    MatMenuModule,
    MatButtonModule,
    MatButtonToggleModule,
    BrowserModule,
    MatCardModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    HttpClientModule



  ],
  providers: [

  ],

  bootstrap: [AppComponent],
})
export class AppModule { }
