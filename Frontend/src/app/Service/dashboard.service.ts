import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private tortaApi = '';
  private barApi = 'http://localhost:8080/dashboard/boh';

  constructor(private http: HttpClient) { }

  getGraficoLinee() {
    return this.http.get<any>(this.barApi)
  }

  getGraficoTorta() {
    return this.http.get<any>(this.tortaApi)
  }

}
