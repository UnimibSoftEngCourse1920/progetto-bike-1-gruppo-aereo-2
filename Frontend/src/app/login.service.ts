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
    return window.sessionStorage.getItem('jwt');
  }

  getUser() {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  logout() {
    localStorage.getItem('username')
    window.sessionStorage.clear();
    this._router.navigate(['/login'])
  }

  saveUser(user) {
    window.sessionStorage.removeItem('user');
    window.sessionStorage.setItem('user', JSON.stringify(user));
  }

  saveToken(token: string) {
    window.sessionStorage.removeItem('jwt');
    window.sessionStorage.setItem('jwt', token);
  }

   loggedIn() {
    return !!this.getToken()    
  }

  isAdmin(){
    return this.getUser().includes('ADMIN')
  }

  isStudent(){
    return this.getUser().includes('STUDENT')
  }

  isGeneric(){
    return this.getUser().includes('GENERIC')
  }
}
