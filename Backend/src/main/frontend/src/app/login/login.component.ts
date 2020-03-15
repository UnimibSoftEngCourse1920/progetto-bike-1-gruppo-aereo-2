import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../Service/login.service'
import { IUser } from '../Interface/IUser'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin: IUser = { username: "", password: "" };
  constructor(private _loginService: LoginService,
    private _router: Router) { }

  ngOnInit() {
  }

  login() {
    this._loginService.login(this.userLogin)
      .subscribe(
        res => {
          this._loginService.saveUser(res.username, res.ruolo)
          this._loginService.saveToken(res.jwt)
          this._router.navigate(['/'])
        },
        err => alert("username o password errati")
      )
  }

}
