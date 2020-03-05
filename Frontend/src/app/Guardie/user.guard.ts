import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginService } from '../Service/login.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  constructor(private _service: LoginService,
    private _router: Router) { }

  canActivate(): boolean {
    if (this._service.isUser()) {
      return true
    } else {
      this._router.navigate(['/login'])
      return false
    }
  }

}
