import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL_RL } from '../constants/url';
@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  private apiUrl = API_URL_RL+'/restaurant/fetchAllRestaurants'; // Replace with actual API

  constructor(private http: HttpClient) {}

  getAllRestaurants(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  getRestaurantById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  addRestaurant(restaurant: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, restaurant);
  }
}
