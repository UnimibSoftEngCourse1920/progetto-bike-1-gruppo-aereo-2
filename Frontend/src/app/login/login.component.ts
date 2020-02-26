import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service'
import { IUser } from '../Interface/IUser'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin: IUser = { username: "", password: ""};
  constructor(private _service: LoginService,
              private _router: Router) { }

  ngOnInit() {
  }

  login() {
    this._service.login(this.userLogin)
    .subscribe(
      res => {
        this._service.saveUser(res.username, res.ruolo)
        this._service.saveToken(res.jwt)
        this._router.navigate(['/prenotazione'])
      },
      err => console.log(err)
    ) 
  }

}
