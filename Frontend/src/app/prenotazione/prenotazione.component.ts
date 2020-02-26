import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BikeService } from '../bike.service';
import { HttpErrorResponse } from '@angular/common/http';
import { LoginService } from '../login.service';
import { IFilter } from '../Interface/IFilter';
import { ModalComponent } from '../modal/modal.component'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.css']
})
export class PrenotazioneComponent implements OnInit {
  
  rastrelliere=[];
  filters: IFilter={oraFine: '', oraInizio: '', rastrellieraFine: '', rastrellieraInizio: ''};
  prenotazioni=[];
  prezzo={};

  constructor(private _router: Router,
    private _bikeService: BikeService,
    private matDialog: MatDialog,
    private _service: LoginService) { }

  ngOnInit() {
    this._bikeService.getRastrelliere()
    .subscribe(
      res => console.log(res),
      err => {
      }
    )
  }

  postPrenotazioni(){
    if(this._bikeService.validaFiltri(this.filters.oraInizio)){
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
   ) }else{
    localStorage.setItem("modalMessage","Errore nell'inserimento dei filtri, seguire le istruzioni in calce")
    this.openModal()
   }
  }

  prenota(prenotazione){
    this._bikeService.prenota(prenotazione,this._service.getUser)
    .subscribe(
     res => this.prezzo = res.prezzo,
     err => {
       if(err instanceof HttpErrorResponse) {
         if (err.status === 401) {
         }
       }
     }
   ) 
  }

  openModal() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.id = "modal-component";  
    this.matDialog.open(ModalComponent, dialogConfig);
  }

}
