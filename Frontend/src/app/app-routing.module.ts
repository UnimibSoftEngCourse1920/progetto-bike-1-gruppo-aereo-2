import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { GuardiaGuard } from './guardia.guard';
import { ModalComponent } from './modal/modal.component'
import { RegistrationComponent } from './registration/registration.component'



const routes: Routes = [{
  path: 'login',
  component: LoginComponent
},
{
  path: 'registration',
  component: RegistrationComponent
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
