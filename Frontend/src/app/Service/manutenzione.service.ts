import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ManutenzioneService {

  constructor(private http: HttpClient) { }

  private _riparaBiciAPI = 'http://localhost:8080/manutenzione/ripara';
  private _riallocaAPI = 'http://localhost:8080/manutenzione/rialloca';
  private _getRastrelliereAPI = 'http://localhost:8080/manutenzione/rastrelliere-bici';
  private _getBiciAPI = 'http://localhost:8080/manutenzione/bici';

  getBiciDaRiparare() {
    return this.http.get<any>(this._getBiciAPI)
  }

  getRastrelliere() {
    return this.http.get<any>(this._getRastrelliereAPI)
  }

  ripara(id) {
    return this.http.post<any>(this._riparaBiciAPI, {id: id})
  }

  rialloca() {
    return this.http.get<any>(this._riallocaAPI)
  }

  validaRialloca() {
    let data = new Date();
    return true
  }

}
