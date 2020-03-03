import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private tortaApi = '';
  private lineApi = '';

  constructor(private http: HttpClient) { }

  getGraficoLinee() {
    return this.http.get<any>(this.lineApi)
  }

  getGraficoTorta() {
    return this.http.get<any>(this.tortaApi)
  }

}
