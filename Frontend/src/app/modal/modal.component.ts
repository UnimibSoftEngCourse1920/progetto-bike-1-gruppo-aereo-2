import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  private message: string;
  constructor() {
   }

  ngOnInit() {
    this.message=localStorage.getItem("modalMessage");
  }

}
