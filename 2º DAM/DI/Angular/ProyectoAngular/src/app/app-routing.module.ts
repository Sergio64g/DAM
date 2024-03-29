import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardCocheComponent } from './Components/card-coche/card-coche.component';
import { CardColorComponent } from './Components/card-color/card-color.component';
import { DetallesComponent } from './Components/detalles/detalles.component';


const routes: Routes = [
  {path: 'coches', component: CardCocheComponent}, 
  {path: 'coches/:parametro', component: CardCocheComponent}, 
  {path: 'detalles/:parametro', component: DetallesComponent}, 
  {path: 'colores', component: CardColorComponent},
  {path: '**', redirectTo: 'coches'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
