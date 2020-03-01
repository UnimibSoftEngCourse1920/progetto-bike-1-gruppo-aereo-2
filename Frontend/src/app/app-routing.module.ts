import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserGuard } from './Guardie/user.guard';
import { AdminGuard } from './Guardie/admin.guard';
import { ModalComponent } from './modal/modal.component'
import { RegistrationComponent } from './registration/registration.component'
import { PrenotazioneComponent } from './prenotazione/prenotazione.component'
import { MiePrenotazioniComponent } from './mie-prenotazioni/mie-prenotazioni.component';
import { ContoComponent } from './conto/conto.component';
import { AdminComponent } from './admin/admin.component';




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
  path: 'admin',
  //canActivate: [AdminGuard],
  component: AdminComponent
},
{
  path: 'modal',
  component: ModalComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
