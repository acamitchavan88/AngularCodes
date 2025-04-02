import { CommonModule } from '@angular/common';
import { RestaurantService } from '../service/restaurant.service';
import { Restaurant } from '../Shared/models/Restaurant'; 
import { Router } from '@angular/router';
import { Component, importProvidersFrom,ChangeDetectorRef  } from '@angular/core';
@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class RestaurantListingComponent {


restaurantList: Restaurant[];
restaurantImages: string[] = [];

  constructor(private cdr: ChangeDetectorRef,private router:Router,private restaurantService: RestaurantService) {}

  ngOnInit(): void {
    // Using the service to fetch restaurants, which removes the unused warning.
    this.restaurantService.getAllRestaurants().subscribe(data => {
      this.restaurantList = data;
      console.log('Restaurants:', data);
      this.assignRandomImages();
    });
  
  }
   /**
   * Generates a random integer between min and max (inclusive).
   */
   getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  /**
   * Returns a random restaurant image path.
   * Update the path or image filenames to match your actual folder/filenames.
   */
 /* getRandomImage(): string {
    // For example, picks a random image from 1 to 5
    const randomIndex = this.getRandomNumber(1, 8);
    return `assets/img/restaurant-pics/${randomIndex}.jpg`;
  }*/
 
 /*   getRandomImage(): string {
      const images = ['1.jpg', '2.jpg', '3.jpg', '4.jpg', '5.jpg','6.jpg','7.jpg','8.jpg'];
      const randomImage = images[Math.floor(Math.random() * images.length)];
      
      // Ensure Angular detects this change
      this.cdr.detectChanges();  
      return `assets/img/restaurant-pics/${randomImage}`;
    }*/
      assignRandomImages() {
        if (!this.restaurantList || this.restaurantList.length === 0) {
          console.warn("Restaurant list is empty. Skipping image assignment.");
          return;
        }
      
        const images = ['1.jpg', '2.jpg', '3.jpg', '4.jpg', '5.jpg', '6.jpg', '7.jpg', '8.jpg'];
      
        this.restaurantList.forEach(() => {
          const randomImage = images[Math.floor(Math.random() * images.length)];
          this.restaurantImages.push(`assets/img/restaurant-pics/${randomImage}`);
        });
      
        // Trigger Angular change detection (useful if images are not updating)
        this.cdr.detectChanges();
      }

  /**
   * Called when "Order Now" button is clicked.
   */
  orderNow(restaurantId: number): void {
    //console.log(`Order now clicked for restaurant ID: ${restaurantId}`);
    // TODO: Implement your ordering logic here
    this.router.navigate(['/food-catalogue/fetchRestaurantById/',restaurantId]);
  }
}
