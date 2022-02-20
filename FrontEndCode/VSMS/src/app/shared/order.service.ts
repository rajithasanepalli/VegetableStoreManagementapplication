import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseURL = "http://localhost:8083/vegetable/api/v1//orders";

  constructor(private httpClient: HttpClient) { }
  getOrdersList(): Observable<Order[]> {
    return this.httpClient.get<Order[]>(`${this.baseURL}`);

  }

  createOrders(orders: Order): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, orders);

  }
  getOrderById(id: string): Observable<Order> {
    return this.httpClient.get<Order>(`${this.baseURL}/${id}`);

  }
  updateOrder(id: string, orders: Order): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, orders);


  }
  deleteOrder(id: string): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);

  }
}
