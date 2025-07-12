import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common'; 
@Component({
  selector: 'app-root',
  imports: [CommonModule,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'charCounter';
  counterValue:string='';


  getCharacterCount() {
alert('Character count entered in text area is::'+this.counterValue.length);
  }
 

}
