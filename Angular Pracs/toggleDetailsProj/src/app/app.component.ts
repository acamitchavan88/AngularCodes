import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common'; 
@Component({
  selector: 'app-root',
  imports: [FormsModule,CommonModule],

  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  isSubmitted: boolean = false;

toggleSubmit() {
this.isSubmitted!=this.isSubmitted;

}

  name!: string;
  email!: string;


  title = 'toggleDetailsProj';
}
