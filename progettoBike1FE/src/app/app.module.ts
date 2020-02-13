import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS  } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
  
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { GuardiaGuard } from './guardia.guard';
import { LoginService } from './login.service';
import { TokenService } from './token.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [LoginService, GuardiaGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenService,
    multi: true
  }],  bootstrap: [AppComponent]
})
export class AppModule { }
