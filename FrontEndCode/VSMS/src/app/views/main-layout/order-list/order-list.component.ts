import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/shared/order.service';



@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.scss']
})
export class OrderListComponent implements OnInit {

  orders: Order[];

  constructor(private ordservice: OrderService, private router: Router) { }

  ngOnInit(): void {
    this.getOrders();
  }
  private getOrders() {
    this.ordservice.getOrdersList().subscribe(data => {
      console.log(data);
      this.orders = data;
    })

  }
  updateOrder(id: string) {
    this.ordservice.getOrdersList().subscribe(data => {
      console.log(data);
      this.orders = data;
    })
    this.router.navigate(['update-order', id]);

  }
  deleteOrder(id: string) {
    this.ordservice.deleteOrder(id).subscribe(data => {
      this.getOrders();
    })


  }
  viewOrder(id: string) {
    this.router.navigate(['order-details', id]);

  }


}
