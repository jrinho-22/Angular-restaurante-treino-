import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { Restaurante } from 'src/app/Restaurante';
import { RestaurantesService } from 'src/app/services/restaurantes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-restaurante',
  templateUrl: './cadastro-restaurante.component.html',
  styleUrls: ['./cadastro-restaurante.component.sass'],
  standalone: true,
  imports: [
    FormsModule, MatFormFieldModule, MatInputModule, MatIconModule// Add FormsModule to the imports array
  ],
})
export class CadastroRestauranteComponent {

  constructor(private restaurantesService: RestaurantesService, private router: Router) {
    // this.getRestaurantes();
  }
  formData = {
    bairro: '',
    localizacao: '',
    atendimentoPresencial: '',
    capacidade: '',
    email: '',
    telefone: '',
  };
  restaurantes: Restaurante[] = [];

  cadastrarRestaurante() {
    try {
      this.restaurantesService.createRestaurante(this.formData).subscribe()
      alert("Restaurante cadastrado com sucesso")
      this.router.navigateByUrl('/restaurantes')
    } catch (error) {
      console.log(error)
    }

  }
}
