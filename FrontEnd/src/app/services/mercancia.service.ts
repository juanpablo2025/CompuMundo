import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MercanciaService {
  constructor(public servicio: HttpClient) {}

  public getMercancia(): Observable<any> {
    let url = 'http://localhost:8080/api/v1/mercancia';
    return this.servicio.get(url);
  }
}
