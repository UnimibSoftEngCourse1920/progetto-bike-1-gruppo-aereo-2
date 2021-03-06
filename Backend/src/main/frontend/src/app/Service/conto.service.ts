import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'

@Injectable({
  providedIn: 'root'
})
export class ContoService {
  private _ricaricaAPI = "http://localhost:8080/conto/ricarica";
  private _contoAPI = "http://localhost:8080/conto/saldo";
  private _abbonamentiAPI='http://localhost:8080/abbonamento/ricarica';
  private _scadenzaAPI='http://localhost:8080/abbonamento/scadenza';
  
  constructor(private http: HttpClient,
    private _service: LoginService) { }

  ricarica(importo) {
    return this.http.post<any>(this._ricaricaAPI, {username: this._service.getUser(), importo: importo})
  }

  getConto(){
    return this.http.post<any>(this._contoAPI, {username: this._service.getUser()})
  }
  
  getScadenza(){
    return this.http.post<any>(this._scadenzaAPI, {username: this._service.getUser()})
  }

  abbonati(tipoAbbonamento){
    return this.http.post<any>(this._abbonamentiAPI, {username: this._service.getUser(), tipo: tipoAbbonamento})

  }
}
