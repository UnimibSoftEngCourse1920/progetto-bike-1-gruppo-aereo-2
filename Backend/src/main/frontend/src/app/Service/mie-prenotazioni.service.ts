import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'

@Injectable({
  providedIn: 'root'
})
export class MiePrenotazioniService {
  private _miePrenotazioniAPI = "http://localhost:8080/prenotazioni/mie";
  private _terminaPrenotazioneAPI = "http://localhost:8080/finisci-corsa";
  private _iniziaPrenotazioneAPI = "http://localhost:8080/inizia-corsa";

  constructor(private http: HttpClient,
    private _loginService: LoginService) { }

  inizia(id) {
    return this.http.post<any>(this._iniziaPrenotazioneAPI, { id: id })
  }

  termina(id) {
    return this.http.put<any>(this._terminaPrenotazioneAPI, { id: id })
  }

  postMiePrenotazioni() {
    return this.http.post<any>(this._miePrenotazioniAPI, {username: this._loginService.getUser()})
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
  }

  daIniziare(stato, oraPrenotazione) {
    let dataCorrente = new Date()
    let oraInizio = + oraPrenotazione.substring(9, 11)
    let minutiInizio = + oraPrenotazione.substring(12, 14)
    let oraCorrente = + dataCorrente.getHours()
    let minutiCorrente = + dataCorrente.getMinutes()
    console.log(minutiInizio)

    if (stato == 'DA_INIZIARE' && ((oraInizio < oraCorrente) || (oraInizio == oraCorrente && minutiInizio <= minutiCorrente)))
      return true
    else
      return false
  }
}
