import { Component, OnInit } from '@angular/core';
import { ContoService } from '../Service/conto.service'


@Component({
  selector: 'app-conto',
  templateUrl: './conto.component.html',
  styleUrls: ['./conto.component.css']
})
export class ContoComponent implements OnInit {

  constructor(private _conto: ContoService) { }
  handler: any = null;
  conto = 0;

  ngOnInit() {
    this.loadStripe();
    this.getConto();
  }

  ricarica(importo) {

    var handler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_aeUUjYYcx4XNfKVW60pmHTtI',
      locale: 'auto',
      token: (token: any) => {
        this._conto.ricarica(importo).subscribe(
          res => {alert(res.message),this.getConto()},
          err => alert(err.message)
        )
      }
    });

    handler.open({
      name: 'Ricarica ' + importo + '.00 €'
    });

  }

  loadStripe() {

    if (!window.document.getElementById('stripe-script')) {
      var s = window.document.createElement("script");
      s.id = "stripe-script";
      s.type = "text/javascript";
      s.src = "https://checkout.stripe.com/checkout.js";
      s.onload = () => {
        this.handler = (<any>window).StripeCheckout.configure({
          key: 'pk_test_aeUUjYYcx4XNfKVW60pmHTtI',
          locale: 'auto',
          token: function (token: any) {
          }
        });
      }
      window.document.body.appendChild(s);
    }
  }

  getConto() {
    this._conto.getConto()
      .subscribe(
        res => this.conto = res,
        err => console.log(err)
      )
  }

  abbonati(tipoAbbonamento){
    this._conto.abbonati(tipoAbbonamento)
    .subscribe(
      res => alert(res.message),
      err => alert(err.message)
    )
  }
}