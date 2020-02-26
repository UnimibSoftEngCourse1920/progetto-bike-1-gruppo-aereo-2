import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { IfStmt } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class BikeService {
  private _prenotazioniAPI = "http://localhost:8080/rastrelliere/bici";
  private _miePrenotazioniAPI = "";
  private _terminaPrenotazioneAPI = "";
  private _prenotaAPI = "";
  private _rastrelliereAPI = "http://localhost:8080/rastrelliere";

  constructor(private http: HttpClient) { }

  postPrenotazioni(rastrelliera){
      return this.http.post<any>(this._prenotazioniAPI, JSON.stringify(rastrelliera))
  }

  getRastrelliere(){
    return this.http.get<any>(this._rastrelliereAPI)
  }

  validaFiltri(oraInizio){
    let currentdate=new Date()
    let currentHours =  +currentdate.getHours()
    let currentMinutes = +currentdate.getMinutes()
    let filterHours = +oraInizio.substring(0, 2)
    let filterMinutes= +oraInizio.substring(3, 5) 
    if(currentHours==filterHours && currentMinutes<filterMinutes){
      return true
    }
    if(filterHours-currentHours==1 && filterMinutes<currentMinutes){
      return true
    }
    return false
  }

  postMiePrenotazioni(username){
    return this.http.post<any>(this._miePrenotazioniAPI, username)
  }

  termina(prenotazione){
    return this.http.post<any>(this._terminaPrenotazioneAPI, prenotazione)
  }
  
  prenota(prenotazione){
    return this.http.post<any>(this._prenotaAPI, JSON.stringify(prenotazione))

  }
}
