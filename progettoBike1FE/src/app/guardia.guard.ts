import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginService } from './login.service';

@Injectable()
export class GuardiaGuard implements CanActivate {
  constructor(private _login: LoginService,
    private _router: Router) { }

  canActivate(): boolean {
    if (this._login.loggedIn()) {
      console.log('true')
      return true
    } else {
      console.log('false')            
      this._router.navigate(['/login'])
      return false
    }
  }
}