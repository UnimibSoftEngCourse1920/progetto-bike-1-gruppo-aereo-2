import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StudentGuard } from './Guardie/student.guard';
import { AdminGuard } from './Guardie/admin.guard';
import { GenericGuard } from './Guardie/generic.guard';
import { ModalComponent } from './modal/modal.component'
import { RegistrationComponent } from './registration/registration.component'
import { PrenotazioneComponent } from './prenotazione/prenotazione.component'
import { MiePrenotazioniComponent } from './mie-prenotazioni/mie-prenotazioni.component';



const routes: Routes = [{
  path: 'login',
  component: LoginComponent
},
{
  path: 'mie-prenotazioni',
  component: MiePrenotazioniComponent
},
{
  path: 'registration',
  component: RegistrationComponent
},
{
  path: 'prenotazione',
  canActivate: [StudentGuard],
  component: PrenotazioneComponent
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
