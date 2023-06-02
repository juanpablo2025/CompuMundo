import { Component } from '@angular/core';
import { Mercancia } from '../interfaces/mercancia';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  public mercancias:Mercancia[]=[]

  public mercancias1:Mercancia={
    iup:1,
    nombre:"aaa",
    descripcion:"ddddddddd",
    fecha:"iii",
    motivo:"eee",
    volumen:"wewewe",
    almacenamiento:{
      iup:1,
      zona:"B",
      unidadescubicas:"234324"
    }
    



  } public mercancias2:Mercancia={
    iup:1,
    nombre:"aaa",
    descripcion:"ddddddddd",
    fecha:"iii",
    motivo:"eee",
    volumen:"wewewe",
    almacenamiento:{
      iup:1,
      zona:"B",
      unidadescubicas:"234324"
    }

}
public mercancias3:Mercancia={
  iup:1,
  nombre:"aaa",
  descripcion:"ddddddddd",
  fecha:"iii",
  motivo:"eee",
  volumen:"wewewe",
  almacenamiento:{
    iup:1,
    zona:"B",
    unidadescubicas:"234324"
  }}
public constructor(){
  this.mercancias.push(this.mercancias1)
    this.mercancias.push(this.mercancias2)
    this.mercancias.push(this.mercancias3)
    console.log(this.mercancias)
}
}
