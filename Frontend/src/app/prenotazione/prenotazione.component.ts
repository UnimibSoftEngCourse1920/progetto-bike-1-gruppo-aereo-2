import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../Service/bike.service';
import { IFilter } from '../Interface/IFilter';

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.css']
})
export class PrenotazioneComponent implements OnInit {

  rastrelliere = [];
  filters: IFilter = { oraFine: '', oraInizio: '', rastrellieraFine: '', rastrellieraInizio: '' };
  bici = [];
  importo = {};

  constructor(private _router: Router,
    private _bikeService: BikeService) { }
  ngOnInit() {
    this._bikeService.getRastrelliere()
      .subscribe(
        res => this.rastrelliere = res
      )
  }

  postPrenotazioni() {
    if (this._bikeService.validaFiltri(this.filters.oraInizio, this.filters.oraFine)) {
      let filtri = {
        ruolo: localStorage.getItem('ruolo'),
        posizioneInizio: this.filters.rastrellieraInizio, oraInizio: this.filters.oraInizio,
        oraFine: this.filters.oraFine
      }
      this._bikeService.postPrenotazioni(filtri)
        .subscribe(
          res => {
            this.bici = res.listaBici
            this.importo = res.importo
          },
          err => this._router.navigate(['/prenotazione'])
        )
    } else {
      alert("Errore nell'inserimento dei filtri")
    }
  }

  prenota(bici_id) {
    let prenotazione = {
      posizionePartenza: this.filters.rastrellieraInizio, posizioneArrivo: this.filters.rastrellieraInizio,
      username: localStorage.getItem("username"), idBici: bici_id, oraInizio: this.filters.oraInizio,
      oraFine: this.filters.oraFine, importo: this.importo
    }
    this._bikeService.prenota(prenotazione)
      .subscribe(
        res => {
          alert(res.message)
          this.postPrenotazioni()
        },
        err => alert("Prenotazione non avvenuta")
      )
  }
}
