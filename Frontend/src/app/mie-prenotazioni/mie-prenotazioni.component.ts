import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../Service/bike.service';
import { HttpErrorResponse } from '@angular/common/http';
import { LoginService } from '../Service/login.service'

@Component({
  selector: 'app-mie-prenotazioni',
  templateUrl: './mie-prenotazioni.component.html',
  styleUrls: ['./mie-prenotazioni.component.css']
})
export class MiePrenotazioniComponent implements OnInit {

  constructor(private _router: Router,
    private _bikeService: BikeService,
    private _service: LoginService) { }
  prenotazioni = [];

  ngOnInit() {
    this._bikeService.postPrenotazioni(this._service.getUser())
      .subscribe(
        res => this.prenotazioni = res,
        err => {
          if (err instanceof HttpErrorResponse) {
            if (err.status === 401) {
              this._router.navigate(['/login'])
            }
          }
        }
      )
  }

  inizia(id) {
    this._bikeService.inizia(id)
      .subscribe(
        res => this._router.navigate(['/mie-prenotazioni']),
        err => this._router.navigate(['/mie-prenotazioni'])
      )
  }

  termina(id) {
    this._bikeService.termina(id)
      .subscribe(
        res => this._router.navigate(['/mie-prenotazioni']),
        err => this._router.navigate(['/mie-prenotazioni'])
      )
  }
}
