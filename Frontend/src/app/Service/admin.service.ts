import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private _API = "http://localhost:8080/ricarica";

  constructor(private http: HttpClient) { }

  ricarica(importo) {
    console.log(importo)
    return this.http.post<any>(this._API, importo)
  }
}
