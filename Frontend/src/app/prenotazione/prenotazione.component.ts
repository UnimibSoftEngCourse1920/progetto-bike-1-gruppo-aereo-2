import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../bike.service';
import { HttpErrorResponse } from '@angular/common/http';
import { LoginService } from '../login.service'

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.css']
})
export class PrenotazioneComponent implements OnInit {
  
  filters:any={};
  prenotazioni=[];
  prezzo={};

  constructor(private _router: Router,
    private _bikeService: BikeService,
    private _service: LoginService) { }

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

  prenota(prenotazione){
    this._bikeService.prenota(prenotazione,this._service.getUser)
    .subscribe(
     res => this.prezzo = res,
     err => {
       if(err instanceof HttpErrorResponse) {
         if (err.status === 401) {
         }
       }
     }
   ) 
  }

}
