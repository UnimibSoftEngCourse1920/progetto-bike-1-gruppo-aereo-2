import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'
@Injectable({
  providedIn: 'root'
})
export class BikeService {
  private _prenotazioniAPI = "http://localhost:8080/rastrelliere/bici";
  private _miePrenotazioniAPI = "http://localhost:8080/prenotazioni/mie";
  private _terminaPrenotazioneAPI = "http://localhost:8080/finisci-corsa";
  private _iniziaPrenotazioneAPI = "http://localhost:8080/inizia-corsa";
  private _prenotaAPI = "http://localhost:8080/prenotazioni/prenota";
  private _rastrelliereAPI = "http://localhost:8080/rastrelliere";

  constructor(private http: HttpClient,
    private _service: LoginService) { }

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

  calcolaImporto(inizio, fine) {
    if (this._service.getRuolo() == 'ROLE_GENERICO') {
      let inzioOra = +inizio.substring(0, 2)
      let inzioMinuti = +inizio.substring(3, 5)
      let fineOra = +fine.substring(0, 2)
      let fineMinuti = +fine.substring(3, 5)
      return (((fineOra - inzioOra) * 60 + fineMinuti - inzioMinuti) * 0.1).toFixed(2)
    }
    return 0.0.toFixed(2);
  }

  inCorso(stato) {
    if (stato == 'IN_CORSO')
      return true
    else
      return false
  }

  daIniziare(stato, oraInizio) {
    console.log(oraInizio)
    if (stato == 'DA_INIZIARE'  )
      return true
    else
      return false
  }
}
