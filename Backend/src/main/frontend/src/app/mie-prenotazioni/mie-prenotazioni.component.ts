import { Component, OnInit } from '@angular/core';
import { MiePrenotazioniService } from '../Service/mie-prenotazioni.service';

@Component({
  selector: 'app-mie-prenotazioni',
  templateUrl: './mie-prenotazioni.component.html',
  styleUrls: ['./mie-prenotazioni.component.css']
})
export class MiePrenotazioniComponent implements OnInit {

  constructor(private _bikeService: MiePrenotazioniService) { }
  prenotazioni = [];

  ngOnInit() {
    this._bikeService.postMiePrenotazioni()
      .subscribe(
        res => this.prenotazioni = res,
        err => console.log(err)
      )
  }

  inizia(id) {
    this._bikeService.inizia(id)
      .subscribe(
        res => {
          this._bikeService.postMiePrenotazioni()
            .subscribe(
              res => this.prenotazioni = res,
              err => alert(err.message)
            )
        },
        err => console.log(err)
      )
  }

  termina(id) {
    this._bikeService.termina(id)
      .subscribe(
        res => {
          alert(res.message)
          this._bikeService.postMiePrenotazioni()
            .subscribe(
              res => this.prenotazioni = res,
              err => alert(err.message)
            )
        },
        err => alert(err.message)
      )
  }
}
