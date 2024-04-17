import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reserva } from '../Reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {
  private apiUrl = 'http://localhost:8080/user/reserva';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Reserva[]> {
    return this.http.get<Reserva[]>(this.apiUrl);
  }

  removeReserva(userId: number, restauranteId: number) {
    const url = `${this.apiUrl}`;
    // var formData = new FormData();
    // formData.append("userId", String(userId));
    // formData.append("restauranteId", String(restauranteId));
    let params = new HttpParams()
    params = params.set('userId', String(userId));
    params = params.set('restauranteId', String(restauranteId));
    return this.http.delete(url, {params});
  }

  createReserva(userId: number, restauranteId: number): Observable<Object> {
    var formData = new FormData();
    formData.append("restauranteId", String(restauranteId));
    const url = `${this.apiUrl}/${userId}`;
    return this.http.put<Object>(url, formData);
  }

  // getRestaurante(id: number): Observable<Reserva> {
  //   return this.http.get<Reserva>(`${this.apiUrl}/${id}`);
  // }

  getReservas(id: Number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
}
