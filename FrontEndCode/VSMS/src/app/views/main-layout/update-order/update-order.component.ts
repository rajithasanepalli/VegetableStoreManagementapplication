import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/order';
import { OrderService } from 'src/app/shared/order.service';

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.scss']
})
export class UpdateOrderComponent implements OnInit {
  orders: Order = new Order();
  id: string;

  constructor(private ordService: OrderService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.ordService.getOrderById(this.id).subscribe(data => {
      this.orders = data;
    }, error => console.log(error))
  }
  onSubmit() {
    this.ordService.updateOrder(this.id, this.orders).subscribe(data => {

      this.goToOrderList();
    }, error => console.log(error));


  }

  goToOrderList() {
    this.router.navigate(['/order'])

  }

}
