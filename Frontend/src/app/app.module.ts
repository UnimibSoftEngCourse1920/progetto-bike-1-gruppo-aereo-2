import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS  } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
  
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserGuard } from './Guardie/user.guard';
import { AdminGuard } from './Guardie/admin.guard';
import { LoginService } from './login.service';
import { TokenService } from './token.service';
import { RegistrationComponent } from './registration/registration.component';
import { ModalComponent } from './modal/modal.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { PrenotazioneComponent } from './prenotazione/prenotazione.component';
import { MiePrenotazioniComponent } from './mie-prenotazioni/mie-prenotazioni.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ModalComponent,
    PrenotazioneComponent,
    MiePrenotazioniComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    MatButtonModule,
    MatDialogModule,
    BrowserAnimationsModule
  ],
  providers: [LoginService, AdminGuard, 
    UserGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenService,
    multi: true
  }],  bootstrap: [AppComponent],
  entryComponents: [ModalComponent]

})
export class AppModule { }
