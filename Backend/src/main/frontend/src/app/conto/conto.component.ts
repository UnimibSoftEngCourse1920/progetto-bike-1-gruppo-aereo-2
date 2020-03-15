import { Component, OnInit } from '@angular/core';
import { ContoService } from '../Service/conto.service'
import { LoginService } from '../Service/login.service'


@Component({
  selector: 'app-conto',
  templateUrl: './conto.component.html',
  styleUrls: ['./conto.component.css']
})
export class ContoComponent implements OnInit {

  constructor(private _contoService: ContoService,
    private _loginService: LoginService) { }
  handler: any = null;
  conto = 0;
  scadenza = '/';

  ngOnInit() {
    this.loadStripe();
    this.getConto();
    this.getScadenza();
  }

  ricarica(importo) {

    var handler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_aeUUjYYcx4XNfKVW60pmHTtI',
      locale: 'auto',
      token: (token: any) => {
        this._contoService.ricarica(importo).subscribe(
          res => {alert(res.message)
            this.getConto()},
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
    this._contoService.getConto()
      .subscribe(
        res => this.conto = res,
        err => console.log(err)
      )
  }

  getScadenza() {
    this._contoService.getScadenza()
      .subscribe(
        res => this.scadenza = res.message,
        err => console.log(err)
      )
  }

  abbonati(tipoAbbonamento){
    this._contoService.abbonati(tipoAbbonamento)
    .subscribe(
      res => {alert(res.message) 
        this.getScadenza()
        this.getConto()},
      err => alert(err.message)
    )
  }
}