import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _loginAPI = "http://localhost:8080/authenticate";


  constructor(private _router: Router,
    private http: HttpClient) { }

  login(user) {
    return this.http.post<any>(this._loginAPI, user)
  }
  getToken() {
    return localStorage.getItem('jwt')
   }
   
   loggedIn() {
    return !!localStorage.getItem('jwt')    
  }
}
