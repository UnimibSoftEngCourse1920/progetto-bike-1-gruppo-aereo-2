import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../bike.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.css']
})
export class PrenotazioneComponent implements OnInit {
  
  filters:any={};
  prenotazioni=[];

  constructor(private _router: Router,
    private _bikeService: BikeService) { }

  ngOnInit() {
  }

  postPrenotazioni(){
    this._bikeService.postPrenotazioni(this.filters)
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
