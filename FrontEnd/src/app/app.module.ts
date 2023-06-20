import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {ReactiveFormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './shared/menu/menu.component';
import { FooterComponent } from './shared/footer/footer.component';
import { AcerdadeComponent } from './acerdade/acerdade.component';
import { FormularioComponent } from './formulario/formulario.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    FooterComponent,
    AcerdadeComponent,
    FormularioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
