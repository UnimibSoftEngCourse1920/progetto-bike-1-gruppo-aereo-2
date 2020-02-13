import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http'
import { LoginService } from './login.service';

@Injectable()
export class TokenService implements HttpInterceptor {

  constructor(private injector: Injector){}
  intercept(req, next) {
    let tokenizedReq = req;
    let login = this.injector.get(LoginService)
    const token = login.getToken();
    if (token != null) {
      tokenizedReq = req.clone({headers: req.headers.set("Authorization", 'Bearer ' + token)});    
    }
    console.log(req.headers.getToken)
    return next.handle(tokenizedReq)
  }

}