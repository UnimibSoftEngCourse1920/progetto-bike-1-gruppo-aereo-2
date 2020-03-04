import { Component, OnInit } from '@angular/core';
import { LoginService } from '../Service/login.service';
import { Router } from '@angular/router'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  userRegistration = {}
  constructor(private _service: LoginService,
    private _router: Router
  ) { }

  ngOnInit() {

  }

  registration() {
    window.sessionStorage.clear()
    this._service.registration(this.userRegistration)
      .subscribe(
        res => {
          alert("Registrazione avvenuta con successo")
          this._router.navigate(['/login'])
        },
        err => alert("Registrazione non avvenuta con successo")
      )
  }

}