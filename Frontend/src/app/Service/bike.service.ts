import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'
import { getLocaleDateTimeFormat } from '@angular/common';
@Injectable({
  providedIn: 'root'
})
export class BikeService {
  private _prenotazioniAPI = "http://localhost:8080/prenotazioni/filtra";
  private _miePrenotazioniAPI = "http://localhost:8080/prenotazioni/mie";
  private _terminaPrenotazioneAPI = "http://localhost:8080/finisci-corsa";
  private _iniziaPrenotazioneAPI = "http://localhost:8080/inizia-corsa";
  private _prenotaAPI = "http://localhost:8080/prenotazioni/prenota";
  private _rastrelliereAPI = "http://localhost:8080/rastrelliere";

  constructor(private http: HttpClient,
    private _service: LoginService) { }

  postPrenotazioni(filtri) {
    return this.http.post<any>(this._prenotazioniAPI, filtri)
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
    return this.http.post<any>(this._miePrenotazioniAPI, { username: username })
  }

  termina(id) {
    return this.http.put<any>(this._terminaPrenotazioneAPI, { idPrenotazione: id })
  }

  inizia(id) {
    return this.http.post<any>(this._iniziaPrenotazioneAPI, { idPrenotazione: id })
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

  daIniziare(stato, oraPrenotazione) {
    let dataCorrente = new Date()
    let oraInizio= + oraPrenotazione.substring(11,13)
    let minutiInizio= + oraPrenotazione.substring(14,16)
    let oraCorrente= + dataCorrente.getHours()
    let minutiCorrente= + dataCorrente.getMinutes()

    if (stato == 'DA_INIZIARE' && ((oraInizio < oraCorrente) || (oraInizio==oraCorrente && minutiInizio <= minutiCorrente) ))
      return true
    else
      return false
  }
}
