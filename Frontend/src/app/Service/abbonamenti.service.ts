import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { LoginService } from './login.service'

@Injectable({
  providedIn: 'root'
})
export class AbbonamentiService {

  constructor(private http: HttpClient,
    private _service: LoginService) { }

  private _abbonamentiAPI='';

  abbonati(tipoAbbonamento){
    return this.http.put<any>(this._abbonamentiAPI, {username: this._service.getUser(), tipoAbbonamento: tipoAbbonamento})

  }
}
