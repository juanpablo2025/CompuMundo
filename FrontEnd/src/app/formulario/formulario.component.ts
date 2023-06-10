import { Component } from '@angular/core';
import { FormGroup,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent {

  public formulario:FormGroup

  public constructor(public fabricaDatos:FormBuilder){
    this.formulario=this.inicializarFormulario()
  }

  public inicializarFormulario():FormGroup{
    return this.fabricaDatos.group({
     
        nombre:['Juan'],
        descripcion:[''],
        fecha_entrada:[''],
        motivo_devolucion:[''],
        volumen:['']

    })
  }

  public capturarDatos():void{}
  

}
