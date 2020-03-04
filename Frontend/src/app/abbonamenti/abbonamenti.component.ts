import { Component, OnInit } from '@angular/core';
import { AbbonamentiService } from '../Service/abbonamenti.service'

@Component({
  selector: 'app-abbonamenti',
  templateUrl: './abbonamenti.component.html',
  styleUrls: ['./abbonamenti.component.css']
})
export class AbbonamentiComponent implements OnInit {

  constructor(private _abbonamenti: AbbonamentiService) { }

  ngOnInit() {
  }

  abbonati(tipoAbbonamento){
    this._abbonamenti.abbonati(tipoAbbonamento)
    .subscribe(
      res => alert(res.message),
      err => alert(err.message)
    )
  }
}
