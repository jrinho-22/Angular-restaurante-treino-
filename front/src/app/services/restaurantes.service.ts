import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurante } from '../Restaurante';

@Injectable({
  providedIn: 'root'
})
export class RestaurantesService {
  private apiUrl = 'http://localhost:8080/restaurante';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Restaurante[]> {
    return this.http.get<Restaurante[]>(this.apiUrl);
  }

  removeRestaurante(id: number) {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url);
  }

  // createMoment(formData: FormData): Observable<FormData> {
  //   return this.http.post<FormData>(this.apiUrl, formData);
  // }

  createRestaurante(formData: Object): Observable<Object> {
    const url = `${this.apiUrl}`;
    return this.http.post<Object>(url, formData);
  }

  getRestaurante(id: number): Observable<Restaurante> {
    return this.http.get<Restaurante>(`${this.apiUrl}/${id}`);
  }
}
