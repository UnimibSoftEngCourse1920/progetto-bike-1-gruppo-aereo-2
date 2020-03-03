import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ManutenzioneService } from '../Service/manutenzione.service';

@Component({
  selector: 'app-manutenzione',
  templateUrl: './manutenzione.component.html',
  styleUrls: ['./manutenzione.component.css']
})
export class ManutenzioneComponent implements OnInit {

  constructor(private _router: Router,
    private _manutenzioneService: ManutenzioneService) { }

  prenotazioni = [];

  ngOnInit() {
    this._manutenzioneService.getRastrelliere()
      .subscribe(
        res => this.prenotazioni = res,
        err => { }
      )
      this._manutenzioneService.getBiciDaRiparare()
      .subscribe(
        res => this.prenotazioni = res,
        err => { }
      )
  }
/*
  inizia(stato) {
    this._bikeService.inizia(stato)
      .subscribe(
        res => this._router.navigate(['/mie-prenotazioni']),
        err => this._router.navigate(['/mie-prenotazioni'])
      )
  }

  termina(stato) {
    this._bikeService.termina(stato)
      .subscribe(
        res => this._router.navigate(['/mie-prenotazioni']),
        err => this._router.navigate(['/mie-prenotazioni'])
      )
  }*/

}
