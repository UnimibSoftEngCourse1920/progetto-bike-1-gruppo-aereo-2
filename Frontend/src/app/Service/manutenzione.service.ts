import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ManutenzioneService {

  constructor(private http: HttpClient) { }
  
  private _contoAPI='';

  getBiciDaRiparare(){
    return this.http.get<any>(this._contoAPI)

  }

  getRastrelliere(){
    return this.http.get<any>(this._contoAPI)

  }

}
