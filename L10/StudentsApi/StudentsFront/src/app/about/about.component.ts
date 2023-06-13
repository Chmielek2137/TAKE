import { Component } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {
  date!: Date;

  ngOnInit(): void {
    this.getDate();
  }

  getDate(): void {
    this.date = new Date();
  }
}
