import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {
  private _prenotazioniAPI = "http://localhost:8080/prenotazioni/filtra";
  private _prenotaAPI = "http://localhost:8080/prenotazioni/prenota";
  private _rastrelliereAPI = "http://localhost:8080/rastrelliere";

  constructor(private http: HttpClient,
    private _loginService: LoginService) { }

  postPrenotazioni(filtri) {
    return this.http.post<any>(this._prenotazioniAPI, filtri)
  }

  getRastrelliere() {
    return this.http.get<any>(this._rastrelliereAPI)
  }

  validaPrenota(){
      let currentDate = new Date()
      let currentHours = + currentDate.getHours
      if (currentHours == 0) {
        return false
      }
      return true
  }

  confermaPrenota(oraInizio){ 
    let currentdate = new Date()
    let currentHours = +currentdate.getHours()
    let currentMinutes = +currentdate.getMinutes()
    let startHours = +oraInizio.substring(0, 2)
    let startMinutes = +oraInizio.substring(3, 5)
    if ((currentHours == startHours && currentMinutes < startMinutes) ||
    (startHours - currentHours == 1 && startMinutes < currentMinutes)) {
      return true
    }
    return false
  }

  validaFiltri(oraInizio, oraFine) {
    let currentdate = new Date()
    let currentHours = +currentdate.getHours()
    let currentMinutes = +currentdate.getMinutes()
    let startHours = +oraInizio.substring(0, 2)
    let startMinutes = +oraInizio.substring(3, 5)
    let endHours = +oraFine.substring(0, 2)
    let endMinutes = +oraFine.substring(3, 5)
    if ((currentHours == startHours && currentMinutes < startMinutes) ||
      (startHours - currentHours == 1 && startMinutes < currentMinutes)) {
      if ((endHours > startHours) || (endHours == startHours && endMinutes > startMinutes)) {
        return true
      }
    }
    return false

  }

  prenota(prenotazione) {
    return this.http.post<any>(this._prenotaAPI, prenotazione)
  }
}
