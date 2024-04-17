import { Component, Inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { ListService } from 'src/app/services/list.service';
import { User } from 'src/app/User';

export interface DialogData {
  nome: string;
  endereco: string;
  email: string;
  senha: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass'],
  standalone: true,
  imports: [FormsModule, MatDialogModule, MatButtonModule, MatInputModule],

})
export class LoginComponent {

  constructor(public dialog: MatDialog, private listService: ListService) {}


}

export class Modal {
  users: User[] = [];

  animalDetails = '';

  constructor(
    public dialogRef: MatDialogRef<Modal>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) {}
}
