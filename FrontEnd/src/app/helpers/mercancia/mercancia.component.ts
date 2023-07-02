import { Component } from '@angular/core';
import { Mercancia } from 'src/app/interfaces/mercancia';
import { MercanciaService } from 'src/app/services/mercancia.service';

@Component({
  selector: 'app-mercancia',
  templateUrl: './mercancia.component.html',
  styleUrls: ['./mercancia.component.css'],
})
export class MercanciaComponent {
  public mercancias: Mercancia[] = [];

  public constructor(public request: MercanciaService) {
    this.request.getMercancia().subscribe((res) => {
      console.log(res);
      this.mercancias = res;
    });
  }
}