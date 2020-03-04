import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserGuard } from './Guardie/user.guard';
import { AdminGuard } from './Guardie/admin.guard';
import { RegistrationComponent } from './registration/registration.component'
import { PrenotazioneComponent } from './prenotazione/prenotazione.component'
import { MiePrenotazioniComponent } from './mie-prenotazioni/mie-prenotazioni.component';
import { ContoComponent } from './conto/conto.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManutenzioneComponent } from './manutenzione/manutenzione.component';
import { AbbonamentiComponent } from './abbonamenti/abbonamenti.component';




const routes: Routes = [{
  path: 'login',
  component: LoginComponent
},
{
  path: 'mie-prenotazioni',
    //canActivate: [UserGuard],
  component: MiePrenotazioniComponent
},
{
  path: 'registration',
  component: RegistrationComponent
},
{
  path: '',
  component: HomeComponent
},
{
  path: 'abbonamenti',
  //canActivate: [UserGuard],
  component: AbbonamentiComponent
},
{
  path: 'prenotazione',
  //canActivate: [UserGuard],
  component: PrenotazioneComponent
},
{
  path: 'conto',
  //canActivate: [UserGuard],
  component: ContoComponent
},
{
  path: 'manutenzione',
  //canActivate: [AdminGuard],
  component: ManutenzioneComponent
},
{
  path: 'dashboard',
  //canActivate: [AdminGuard],
  component: DashboardComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
