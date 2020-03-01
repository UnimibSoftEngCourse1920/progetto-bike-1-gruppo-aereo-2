import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class BikeService {
  private _prenotazioniAPI = "http://localhost:8080/rastrelliere/bici";
  private _miePrenotazioniAPI = "http://localhost:8080/preno/prenotazioni/mie";
  private _terminaPrenotazioneAPI = "http://localhost:8080/preno/termina";
  private _iniziaPrenotazioneAPI = "http://localhost:8080/preno/inizia";
  private _prenotaAPI = "http://localhost:8080/preno/prenota";
  private _rastrelliereAPI = "http://localhost:8080/rastrelliere";

  constructor(private http: HttpClient) { }

  postPrenotazioni(rastrelliera) {
    return this.http.post<any>(this._prenotazioniAPI, JSON.stringify(rastrelliera))
  }

  getRastrelliere() {
    return this.http.get<any>(this._rastrelliereAPI)
  }

  validaFiltri(oraInizio) {
    let currentdate = new Date()
    let currentHours = +currentdate.getHours()
    let currentMinutes = +currentdate.getMinutes()
    let filterHours = +oraInizio.substring(0, 2)
    let filterMinutes = +oraInizio.substring(3, 5)
    if (currentHours == filterHours && currentMinutes < filterMinutes) {
      return true
    }
    if (filterHours - currentHours == 1 && filterMinutes < currentMinutes) {
      return true
    }
    return false
  }

  postMiePrenotazioni(username) {
    return this.http.post<any>(this._miePrenotazioniAPI, username)
  }

  termina(id) {
    return this.http.put<any>(this._terminaPrenotazioneAPI, id)
  }

  inizia(id) {
    return this.http.put<any>(this._iniziaPrenotazioneAPI, id)
  }

  prenota(prenotazione) {
    return this.http.post<any>(this._prenotaAPI, prenotazione)

  }

  inCorso(stato) {
    if (stato == 'IN_CORSO')
      return true
    else
      return false
  }

  passata(stato) {
    if (stato == 'PASSATA')
      return true
    else
      return false
  }

  daIniziare(stato) {
    if (stato == 'DA_INIZIARE')
      return true
    else
      return false
  }
}
