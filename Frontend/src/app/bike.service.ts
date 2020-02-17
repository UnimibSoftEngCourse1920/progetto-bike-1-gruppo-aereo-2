import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class BikeService {
  private _prenotazioniAPI = "";
  private _miePrenotazioniAPI = "";
  constructor(private http: HttpClient) { }

  postPrenotazioni(prenotazioni){
      return this.http.post<any>(this._prenotazioniAPI, prenotazioni)
  }

  postMiePrenotazioni(username){
    return this.http.post<any>(this._miePrenotazioniAPI, username)
  }

}
