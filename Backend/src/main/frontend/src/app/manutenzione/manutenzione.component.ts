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

  rastrelliere = [];
  biciDaRiparare = []

  ngOnInit() {

    this._manutenzioneService.getRastrelliere()
      .subscribe(
        res => this.rastrelliere = res,
      )
    this._manutenzioneService.getBiciDaRiparare()
      .subscribe(
        res => this.biciDaRiparare = res,
      )
  }

  ripara(idBici) {
    this._manutenzioneService.ripara(idBici)
      .subscribe(
        res => { alert(res.message)
          this._manutenzioneService.getBiciDaRiparare()
          .subscribe(
            res2 => this.biciDaRiparare = res2,
          )
        },
        err => alert(err.message)
      )
  }

  rialloca() {
    if(!this._manutenzioneService.validaRialloca()){
      alert("Non è possibile riallocare le bici, potrai farlo dalle 00:00h alle 01:00h")
    }else{
    this._manutenzioneService.rialloca()
      .subscribe(
        res => { 
          this._manutenzioneService.getRastrelliere()
          .subscribe(
            res2 => this.rastrelliere = res2,
          )
          alert("Le bici sono state riallocate correttamente")
        }
              )
  }
}

}
