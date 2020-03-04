import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../Service/bike.service';
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
    this._bikeService.postMiePrenotazioni(this._service.getUser())
      .subscribe(
        res => this.prenotazioni = res,
        err => this._router.navigate(['/login'])
      )
  }

  inizia(stato) {
    this._bikeService.inizia(stato)
      .subscribe(
        res => {
          alert(res.message)
           this._bikeService.postMiePrenotazioni(this._service.getUser())
            .subscribe(
              res => this.prenotazioni = res,
              err => alert(err.message)
            )
          },
        err => console.log(err)
      )
  }

  termina(stato) {
    this._bikeService.termina(stato)
      .subscribe(
        res => {
        alert(res.message)
         this._bikeService.postMiePrenotazioni(this._service.getUser())
          .subscribe(
            res => this.prenotazioni = res,
            err => alert(err.message)
          )
        },
        err => alert(err.message)
      )
  }
}
