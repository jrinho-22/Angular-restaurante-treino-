import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantesService } from 'src/app/services/restaurantes.service';
import { Restaurante } from 'src/app/Restaurante';
import { ReservaService } from 'src/app/services/reservas.service';
import { Reserva } from 'src/app/Reserva';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { User } from 'src/app/User';
import { UserService } from 'src/app/services/user.service';
import {MatGridListModule} from '@angular/material/grid-list';
import { Router, RouterModule } from '@angular/router';


@Component({
  selector: 'app-listar-restaurante',
  templateUrl: './listar-restaurante.component.html',
  styleUrls: ['./listar-restaurante.component.sass'],
  standalone: true,
  imports: [RouterModule, MatCardModule, MatButtonModule, CommonModule, MatGridListModule]
})

export class ListarRestauranteComponent {
  constructor(
    private router: Router,
    private restaurantesService: RestaurantesService,
    private reservaService: ReservaService,
    private userService: UserService
    ) {
    this.getUser();
    this.getRestaurantes();
    this.getReservas();
  }
  user!: User | undefined;
  restaurantes: Restaurante[] = [];
  reservas!: [];

  softReload() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigateByUrl(currentUrl);
    });
  }

  reservar(idRestaurante: number):void {
    if (this.user) {
      this.reservaService.createReserva(this.user.id, idRestaurante).subscribe() 
      alert("Reserva efetuada com sucesso") 
      this.softReload();   
    }
  }

  cancelarReservar(idRestaurante: number):void {
    if (this.user) {
      this.reservaService.removeReserva(this.user.id, idRestaurante).subscribe() 
      alert("Reserva cancelada")   
      this.softReload();  
    }
  }

  remover(idRestaurante: number):void {
    if (idRestaurante) {
      this.restaurantesService.removeRestaurante(idRestaurante).subscribe() 
      alert("Restaurante excluido com sucesso") 
      this.softReload();  
    }
  }

  getUser(): void {
    this.user = this.userService.getUser()
  }

  getRestaurantes(): void {
    this.restaurantesService.getAll().subscribe((v) => {
      console.log('restauraneee', v);
      this.restaurantes = v
    });
  }

  userPossuiReserva(resId: Number){
    var reserva = this.reservas.find((v) => v == resId);
    return reserva ? true : false 
  }
  
  getReservas(): void {
    if (this.user) {
      this.reservaService.getReservas(this.user.id).subscribe((v) => {
      this.reservas = v
    });
    }

  }
  
}
