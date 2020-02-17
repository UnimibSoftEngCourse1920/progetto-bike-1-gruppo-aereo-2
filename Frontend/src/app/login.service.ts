import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _loginAPI = "http://localhost:8080/authenticate";
  private _registrationAPI= "http://localhost:8080/registration";

  constructor(private _router: Router,
    private http: HttpClient) { }

  registration(user) {
      return this.http.post<any>(this._registrationAPI, user) 
  }
  
  login(user) {
    return this.http.post<any>(this._loginAPI, user)
  }
  getToken() {
    return localStorage.getItem('jwt')
   }

   logout() {
    localStorage.removeItem('jwt')
    localStorage.removeItem('username')
    localStorage.removeItem('role')
    this._router.navigate(['/login'])
  }
   loggedIn() {
    return !!localStorage.getItem('jwt')    
  }
}
