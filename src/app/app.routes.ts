import { Routes } from '@angular/router';

export const routes: Routes = [
    { path: '', redirectTo: 'restaurant-listing', pathMatch: 'full' },
   { 
        path: 'restaurant-listing', 
        loadComponent: () => import('./restaurant-listing/restaurant-listing.component').then(m => m.RestaurantListingComponent)
    }
];
