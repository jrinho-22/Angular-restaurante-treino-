import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { User } from 'src/app/User';
import { ListService } from 'src/app/services/list.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.sass'],
  standalone: true,
  imports: [
    FormsModule, MatFormFieldModule, MatInputModule, MatIconModule// Add FormsModule to the imports array
  ],
})
export class EditarUsuarioComponent {
  constructor(private listService: ListService,
    private route: ActivatedRoute,
    private router: Router
    ) {
    this.id = this.route.snapshot.paramMap.get('id') || "1"
    this.getUsers();
  //   this.route.queryParams.subscribe(params => {
  //     const id = params['id'];
  //     const name = params['name'];
  //     console.log('ID:', id); // Output: 123
  //     console.log('Name:', name); // Output: example
  //     // Use the retrieved parameters as needed
  //   });
  }

  id: string
  formData!: User;

  getUsers(): void {
    this.listService.getItem(Number(this.id)).subscribe((user) => {
      this.formData = user;
    });
  }

  saveUser() {
    this.listService.saveUser(this.formData, Number(this.id)).subscribe();
    alert("Usuario alterado com sucesso");
    this.router.navigateByUrl('/cadastros')
  }
}
