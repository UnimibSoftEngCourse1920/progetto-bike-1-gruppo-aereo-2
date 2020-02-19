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

  openModal() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.id = "modal-component";
    dialogConfig.height = "350px";
    dialogConfig.width = "600px";
    this.matDialog.open(ModalComponent, dialogConfig);
  }

  registration() {
    window.sessionStorage.clear()
    this._service.registration(this.userRegistration)
    .subscribe(
      res => { 
      window.sessionStorage.setItem("modalMessage","registrazione avvenuta")
      this.openModal()
      this._router.navigate(['/login'])
      },
      err => {
        window.sessionStorage.setItem("modalMessage","registrazione non avvenuta")
        this.openModal()
        console.log(err)}
    )      
  }

}