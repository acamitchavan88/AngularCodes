import {Injectable} from '@angular/core';
import { API_URL_FC } from '../../constants/url';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, ObservableInput } from 'rxjs';
@Injectable({
    providedIn:'root'
})
export class FoodItemService
{
    private apiUrl = API_URL_FC+'/foodCatalogue/fetchRestaurantById/{restaurantId}'; // Replace with actual API
    handleError: (err: any, caught: Observable<any>) => ObservableInput<any>;
    constructor(private http:HttpClient)
    {}

    fetchFoodDetails(restaurantId:number):Observable<any>
    {
        return this.http.post<any>(this.apiUrl,restaurantId);
    }
    getFoodItemsByRestaurant(id:number):Observable<any>
    {
        return this.http.get<any>('${this.apiUrl+id}')
        .pipe(catchError(this.handleError));
    }
   
   
}