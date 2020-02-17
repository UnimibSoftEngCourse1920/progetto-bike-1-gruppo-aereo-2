import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../bike.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-mie-prenotazioni',
  templateUrl: './mie-prenotazioni.component.html',
  styleUrls: ['./mie-prenotazioni.component.css']
})
export class MiePrenotazioniComponent implements OnInit {

  constructor(private _router: Router,
    private _bikeService: BikeService) { }
  prenotazioni = [];

  ngOnInit() {
    this._bikeService.postPrenotazioni(localStorage.getItem("username"))
    .subscribe(
     res => this.prenotazioni = res,
     err => {
       if(err instanceof HttpErrorResponse) {
         if (err.status === 401) {
           this._router.navigate(['/login'])
         }
       }
     }
   ) 
  }

}
