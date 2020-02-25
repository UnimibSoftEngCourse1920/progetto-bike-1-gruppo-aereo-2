import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private _loginAPI = "http://localhost:8080/auth/signin";
  private _registrationAPI= "http://localhost:8080/auth/signup";

  constructor(private _router: Router,
    private http: HttpClient) { }

  registration(user) {
      return this.http.post<any>(this._registrationAPI, user) 
  }
  
  login(user) {
    return this.http.post<any>(this._loginAPI, user)
  }

  getToken() {
    return localStorage.getItem('jwt');
  }

  getUser() {
    return localStorage.getItem('username');
  }

  getRuolo() {
    return localStorage.getItem('ruolo');
  }

  logout() {
    localStorage.clear();
    this._router.navigate(['/login'])
  }

  saveUser(username, ruolo) {
    localStorage.removeItem('ruolo');
    localStorage.removeItem('username');
    localStorage.setItem('ruolo', ruolo);
    localStorage.setItem('username', username);
  }

  saveToken(token: string) {
    localStorage.removeItem('jwt');
    localStorage.setItem('jwt', token);
  }

  loggedIn() {
    return !!this.getToken()    
  }

  isAdmin(){
    if(this.getRuolo()=='ADMIN')
        return true;
    return false
  }

  isUser(){
    if(this.getRuolo()=='PERSONALE' || this.getRuolo()=='GENERICO')
        return true;
    return false
  }
}
