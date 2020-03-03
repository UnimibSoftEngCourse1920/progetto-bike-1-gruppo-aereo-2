import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../../assets/canvasjs.min';
import { DashboardService } from '../Service/dashboard.service'


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private graficoTorta = {};
  private graficoLinee = {};

  constructor(private _dahsboardService: DashboardService) { }

	ngOnInit() {
    
    this._dahsboardService.getGraficoTorta()
    .subscribe(
     res => this.graficoTorta = res,
     err => { }
   ) 
   this._dahsboardService.getGraficoLinee()
   .subscribe(
    res => this.graficoLinee = res,
    err => { }
  ) 
   let graficoTorta = new CanvasJS.Chart("chartContainer", {
      theme: "light2",
      animationEnabled: true,
      exportEnabled: true,
      title:{
        text: "Monthly Expense"
      },
      data: [{
        type: "pie",
        showInLegend: true,
        toolTipContent: "<b>{name}</b>: ${y} (#percent%)",
        indexLabel: "{name} - #percent%",
        dataPoints: this.graficoTorta
      }]
    });
    let graficoLinee = new CanvasJS.Chart("chartContainer2", {
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: "Basic Column Chart in Angular"
      },
      data: [{
        type: "column",
        dataPoints: [
          this.graficoLinee
        ]
      }]
    });
      
    graficoLinee.render();
    graficoTorta.render();

      }

}
