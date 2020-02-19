import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router'
import { ModalComponent } from '../modal/modal.component'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['../app.component.css']
})
export class RegistrationComponent implements OnInit {

  userRegistration ={}
  constructor(private _service: LoginService,
              private _router: Router,
              private matDialog: MatDialog,
              ) { }

  ngOnInit() {
   
  }

  openModal(message) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "350px";
    dialogConfig.width = "600px";
    this.matDialog.open(ModalComponent, dialogConfig);
  }

  registration() {
    this._service.registration(this.userRegistration)
    .subscribe(
      res => {
        this.openModal("registrazione avvenuta")
        this._router.navigate(['/login'])
      },
      err => {this.openModal("registrazione non avvenuta correttamente")
        console.log(err)}
    )      
  }

}