import { Injectable } from '@angular/core';
import { User } from '../User';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ListService {
  private apiUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }

  removeUser(id: number) {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url);
  }

  // createMoment(formData: FormData): Observable<FormData> {
  //   return this.http.post<FormData>(this.apiUrl, formData);
  // }

  createMoment(formData: Object): Observable<Object> {
    const url = `${this.apiUrl}`;
    return this.http.post<Object>(url, formData);
  }

  saveUser(dto: User, id: Number): Observable<Object> {
    var formData = new FormData();
    formData.append("nome", String(dto.nome))
    formData.append("endereco", String(dto.endereco))
    formData.append("email", String(dto.email))
    formData.append("senha", String(dto.senha))

    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Object>(url, formData);
  }

  getItem(id: Number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

}
