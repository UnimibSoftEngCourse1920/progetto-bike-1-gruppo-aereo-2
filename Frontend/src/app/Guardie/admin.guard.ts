import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginService } from '../Service/login.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  constructor(private _service: LoginService,
    private _router: Router) { }

  canActivate(): boolean {
    if (this._service.isAdmin()) {
      console.log('true')
      return true
    } else {
      console.log('false')
      this._router.navigate(['/login'])
      return false
    }
  }

}