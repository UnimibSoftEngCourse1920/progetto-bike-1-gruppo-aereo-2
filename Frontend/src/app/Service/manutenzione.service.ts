import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ManutenzioneService {

  constructor(private http: HttpClient) { }

  private _riparaBiciAPI = '';
  private _riallocaAPI = '';
  private _getRastrelliereAPI = '';
  private _getBiciAPI = '';

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
