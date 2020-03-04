import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../Service/bike.service';
import { HttpErrorResponse } from '@angular/common/http';
import { LoginService } from '../Service/login.service';
import { IFilter } from '../Interface/IFilter';
import { ModalComponent } from '../modal/modal.component'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

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
    private _bikeService: BikeService,
    private matDialog: MatDialog,
    private _service: LoginService) { }
  ngOnInit() {
    this._bikeService.getRastrelliere()
      .subscribe(
        res => this.rastrelliere = res,
        err => {
        }
      )
  }

  postPrenotazioni() {
    if (this._bikeService.validaFiltri(this.filters.oraInizio)) {
      this._bikeService.postPrenotazioni({ruolo: localStorage.getItem('ruolo'),
      posizioneInizio: this.filters.rastrellieraInizio, oraInizio: this.filters.oraInizio, 
      oraFine: this.filters.oraFine })
        .subscribe(
          res => {
            console.log(res)
            this.bici = res.listaBici
            this.importo = res.importo
          },
          err => this._router.navigate(['/prenotazione'])
        )
    } else {
      localStorage.setItem("modalMessage", "Errore nell'inserimento dei filtri, seguire le istruzioni in calce")
      this.openModal()
    }
  }

  prenota(bici_id) {
    let prenotazione = {
      posizionePartenza: this.filters.rastrellieraInizio, posizioneArrivo: this.filters.rastrellieraInizio,
      username: localStorage.getItem("username"), idBici: bici_id, oraInizio: this.filters.oraInizio, oraFine: this.filters.oraFine, importo: this.importo
    }
    this._bikeService.prenota(prenotazione)
      .subscribe(
        res => {alert(res.message)
          this.postPrenotazioni()},
        err => this._router.navigate(['/prenotazione'])
      )
  }

  openModal() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.id = "modal-component";
    this.matDialog.open(ModalComponent, dialogConfig);
  }

}
