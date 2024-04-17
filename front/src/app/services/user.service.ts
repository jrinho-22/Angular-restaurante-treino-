// src/app/user.service.ts
import { Injectable } from '@angular/core';
// import { BehaviorSubject } from 'rxjs';
import { User } from '../User';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private loggedInUserSubject: User | undefined;  

  constructor() {}

  login(user: User) {
    this.loggedInUserSubject = user;
  }

  logout() {
    this.loggedInUserSubject = undefined;
  }

  getUser(): User | undefined {
    return this.loggedInUserSubject;
  }
}
