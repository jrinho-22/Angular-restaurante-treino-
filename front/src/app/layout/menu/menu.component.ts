import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { User } from 'src/app/User';

import { ListService } from 'src/app/services/list.service';
import { UserService } from 'src/app/services/user.service';

export interface DialogData {
  nome: string;
  endereco: string;
  email: string;
  senha: string;
}


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
  // standalone: true,
  // imports: [CommonModule, FormsModule, MatDialogModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatSelectModule],
})
export class MenuComponent {
  users: User[] = [];
  user: User | undefined;

  nome: string = '';
  endereco: string = '';
  email: string = '';
  senha: string = '';

  constructor(public dialog: MatDialog, private listService: ListService, private userService: UserService) {
    this.getUsers();
  }
  
  logOut(): void {
    this.userService.logout();
    this.user = this.userService.getUser();
    alert("Logout efetuado com sucesso");
  }

  getUsers(): void {
    this.listService.getAll().subscribe((user) => {
      console.log(user);
      return this.users = user
    });
  }

  openDialogCadastro() {
    const dialogRef = this.dialog.open(ModalCadastro, {
      data: {
        nome: this.nome, endereco: this.endereco, email: this.email, senha: this.senha
      },
    });

    dialogRef.afterClosed().subscribe(result => {
      const formData = {
        nome: result.nome,
        endereco: result.endereco,
        email: result.email,
        senha: result.senha,
        admin: false
      };
      this.listService.createMoment(formData).subscribe();
      alert("Cadastro efetuado com sucesso");
    });
  }

  openDialogLogin() {
    const dialogRef = this.dialog.open(ModalLogin, {
      data: {
        email: this.email, senha: this.senha
      },
    });

    dialogRef.afterClosed().subscribe(result => {

      console.log("resull", result, this.users);
      const user: User[] = this.users.filter((v) => {
        console.log('email', v.email, result.email, v.email == result.email)
        console.log('senah', v.email, result.email, v.senha == result.senha)
        return v.email == result.email && v.senha == result.senha 
      })
      if (user.length) {
        this.userService.login(user[0]);
        this.user = this.userService.getUser(); 
        alert("Login efetuado com sucesso");
      } else {
        alert("Email ou senha invalidos")
      }
      console.log(this.userService.getUser());
      // console.log(this.users, result);
    });
  }
}

@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: 'modalCadastro.html',
  styleUrls: ['./menu.component.scss'],
  standalone: true,
  imports: [FormsModule, MatDialogModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatSelectModule],
})
export class ModalCadastro {

  constructor(
    public dialogRef: MatDialogRef<ModalCadastro>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) {}
}

@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: 'modalLogin.html',
  styleUrls: ['./menu.component.scss'],
  standalone: true,
  imports: [FormsModule, MatDialogModule, MatButtonModule, MatFormFieldModule, MatInputModule, MatSelectModule],
})
export class ModalLogin {
  users: User[] = [];
  email!: string;
  senha!: string;

  animalDetails = '';

  constructor(
    public dialogRef: MatDialogRef<ModalLogin>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private listService: ListService
  ) {}

}
