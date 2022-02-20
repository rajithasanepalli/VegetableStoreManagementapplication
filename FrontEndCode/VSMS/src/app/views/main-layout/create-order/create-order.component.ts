import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/shared/order.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.scss']
})
export class CreateOrderComponent implements OnInit {
  orders: Order = new Order();

  constructor(private ordservice: OrderService,
    private router: Router) { }

  ngOnInit(): void {

  }
  saveOrders() {
    this.ordservice.createOrders(this.orders).subscribe(data => {
      console.log(data);
      this.goToOrderList();


    }, error => console.log(error));
  }
  goToOrderList() {
    this.router.navigate(['/order'])

  }

  onSubmit() {
    console.log(this.orders);
    this.saveOrders();

  }

}
