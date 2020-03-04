import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../../assets/canvasjs.min';
import { DashboardService } from '../Service/dashboard.service'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private _dahsboardService: DashboardService) { }

  ngOnInit() {
    this._dahsboardService.getGraficoLinee()
      .subscribe(
        res => { this.creaGraficoLinee(res) },
        err => { }
      )
     this._dahsboardService.getGraficoTorta()
      .subscribe(
        res => { this.creaGraficoTorta(res) },
        err => { }
      )
  }

  creaGraficoLinee(dati) {
    let chart = new CanvasJS.Chart("chartContainer", {
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: "Utilizzo bici per rastrelliera"
      },
      data: [{
        type: "column",
        dataPoints: dati
      }]
    });
    chart.render();
  }
  creaGraficoTorta(dati){
    let chart = new CanvasJS.Chart("chartContainer2", {
      theme: "light2",
      animationEnabled: true,
      exportEnabled: true,
      title:{
        text: "Utilizzo bici per fascia oraria"
      },
      data: [{
        type: "pie",
        showInLegend: true,
        toolTipContent: "<b>{name}</b>: ${y} (#percent%)",
        indexLabel: "{name} - #percent%",
        dataPoints: dati
      }]
    });
      console.log(dati)
    chart.render();
  }
}
