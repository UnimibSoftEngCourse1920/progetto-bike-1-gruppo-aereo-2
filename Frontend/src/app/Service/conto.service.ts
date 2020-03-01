import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ContoService {
  private _ricaricaAPI = "http://localhost:8080/ricarica";

  constructor(private http: HttpClient) { }

  ricarica(importo) {
    console.log(importo)
    return this.http.post<any>(this._ricaricaAPI, importo)
  }
}
