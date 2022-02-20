import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/shared/order.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.scss']
})
export class OrderDetailsComponent implements OnInit {
  id: string;
  orders: Order;

  constructor(private route: ActivatedRoute, private ordService: OrderService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.orders = new Order();
    this.ordService.getOrderById(this.id).subscribe(data => {
      this.orders = data;
    })

  }

}
