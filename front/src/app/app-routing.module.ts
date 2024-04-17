import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/auth/login/login.component';
import { CadastrosComponent } from './component/cadastros/cadastros.component';
import { HomeComponent } from './layout/home/home.component';
import { CadastroRestauranteComponent } from './component/cadastro-restaurante/cadastro-restaurante.component';
import { ListarRestauranteComponent } from './component/listar-restaurante/listar-restaurante.component';
import { EditarUsuarioComponent } from './component/editar-usuario/editar-usuario.component';

const routes: Routes = [
  // {
  //   path: 'primiraParte',
  //   children: [
  //     { path: 'login', component: LoginComponent },
  //     { path: 'cadastros', component: CadastrosComponent },
  //     { path: 'cadastrar-restaurante', component: CadastroRestauranteComponent },
  //     { path: 'restaurantes', component: ListarRestauranteComponent },
  //     { path: 'editar-usuario/:id', component: EditarUsuarioComponent },
  //   ]
  // },
    { path: 'login', component: LoginComponent },
    { path: 'cadastros', component: CadastrosComponent },
    { path: 'cadastrar-restaurante', component: CadastroRestauranteComponent },
    { path: 'restaurantes', component: ListarRestauranteComponent },
    { path: 'editar-usuario/:id', component: EditarUsuarioComponent },
    { path: 'home', component: HomeComponent },
    { path: '**', redirectTo: '/home' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
