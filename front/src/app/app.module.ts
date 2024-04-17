import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './layout/menu/menu.component';
import { LoginComponent } from './component/auth/login/login.component';
import { CadastrosComponent } from './component/cadastros/cadastros.component';
import { HomeComponent } from './layout/home/home.component';
import { CadastroRestauranteComponent } from './component/cadastro-restaurante/cadastro-restaurante.component';
import { ListarRestauranteComponent } from './component/listar-restaurante/listar-restaurante.component';
import { RestaurantesComponent } from './pages/restaurantes/restaurantes.component';
import { EditarUsuarioComponent } from './component/editar-usuario/editar-usuario.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RestaurantesComponent,
    MenuComponent,
  ],
  imports: [
    EditarUsuarioComponent,
    ListarRestauranteComponent,
    LoginComponent,
    CadastroRestauranteComponent,
    CadastrosComponent,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
