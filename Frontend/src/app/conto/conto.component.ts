import { Component, OnInit } from '@angular/core';
import { ContoService } from '../Service/conto.service'
import { Router } from '@angular/router';


@Component({
  selector: 'app-conto',
  templateUrl: './conto.component.html',
  styleUrls: ['./conto.component.css']
})
export class ContoComponent implements OnInit {

  constructor(private _conto: ContoService,
    private _router: Router) { }
  ngOnInit() {
  }
  importo=0

  ricarica() {
    this._conto.ricarica(this.importo)
      .subscribe(
        res => {
          this._router.navigate(['/conto'])
        },
        err => console.log(err)
      )
  }
}
