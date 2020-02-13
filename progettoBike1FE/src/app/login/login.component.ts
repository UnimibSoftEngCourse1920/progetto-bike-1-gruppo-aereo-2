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
  userLogin: IUser
  constructor(private _service: LoginService,
              private _router: Router) { }

  ngOnInit() {
    this.userLogin = { username: "", password: ""};
  }

  login() {
    this._service.login(this.userLogin)
    .subscribe(
      res => {
        localStorage.setItem('username', this.userLogin.username)
        localStorage.setItem('jwt', res.jwt)
        this._router.navigate(['/login'])
      },
      err => console.log(err)
    ) 
  }

}
