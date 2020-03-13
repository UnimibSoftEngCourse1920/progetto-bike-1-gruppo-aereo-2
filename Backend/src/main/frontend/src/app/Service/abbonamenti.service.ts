import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'

@Injectable({
  providedIn: 'root'
})
export class AbbonamentiService {

  constructor(private http: HttpClient,
    private _service: LoginService) { }

  private _abbonamentiAPI='http://localhost:8080/abbonamento/ricarica';

  abbonati(tipoAbbonamento){
    return this.http.post<any>(this._abbonamentiAPI, {username: this._service.getUser(), tipo: tipoAbbonamento})

  }
}
