import {Component} from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { User } from 'src/app/User';
import { ListService } from 'src/app/services/list.service';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';


@Component({
  selector: 'app-cadastros',
  templateUrl: './cadastros.component.html',
  styleUrls: ['./cadastros.component.scss'],
  // standalone: true,
  imports: [RouterModule, MatTableModule],
})

/**
 * @title Basic use of `<table mat-table>`
 */
export class CadastrosComponent {
  dataSource: User[] = [];
  displayedColumns: string[] = ['nome', 'endereco', 'email', 'senha', 'admin', 'acoes'];
  

  constructor(private listService: ListService, private router: Router) {
    this.getUsers();
  }

  removeUser(user: User): void {
    if (user.admin) {
      alert("Usuarios administradores não podem ser excluidos.");
      return 
    }
    this.listService.removeUser(user.id).subscribe();
    alert("Usuarios excluido");
    this.softReload()
  }
  

  getUsers(): void {
    this.listService.getAll().subscribe((user) => {
      this.dataSource = user;
    });
  }

  softReload() {
    const currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigateByUrl(currentUrl);
    });
  }

}
