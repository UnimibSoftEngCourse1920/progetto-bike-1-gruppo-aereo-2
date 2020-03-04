import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserGuard } from './Guardie/user.guard';
import { AdminGuard } from './Guardie/admin.guard';
import { LoginService } from './Service/login.service';
import { TokenService } from './Service/token.service';
import { BikeService } from './Service/bike.service';
import { ContoService } from './Service/conto.service';

import { RegistrationComponent } from './registration/registration.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PrenotazioneComponent } from './prenotazione/prenotazione.component';
import { MiePrenotazioniComponent } from './mie-prenotazioni/mie-prenotazioni.component';
import { ContoComponent } from './conto/conto.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManutenzioneComponent } from './manutenzione/manutenzione.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    PrenotazioneComponent,
    MiePrenotazioniComponent,
    ContoComponent,
    HomeComponent,
    DashboardComponent,
    ManutenzioneComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [LoginService, AdminGuard,
    BikeService, ContoService,
    UserGuard, {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenService,
      multi: true
    }], bootstrap: [AppComponent]
})
export class AppModule { }
