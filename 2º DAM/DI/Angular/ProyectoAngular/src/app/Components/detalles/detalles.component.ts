import { Component, OnInit } from '@angular/core';
import { CochesService } from '../../Services/coches.service';
import { coche } from '../../Utils/coche';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css']
})
export class DetallesComponent implements OnInit {

  coches: coche[];
  parametro: string;

  constructor(
    private serviciosCoches: CochesService,
    private rutas: ActivatedRoute) {
      
      this.rutas.params.subscribe(element => {
        this.parametro = element.parametro;
      });
      if (this.parametro != null) {
        this.coches = this.serviciosCoches.getCocheModelo(this.parametro);
      }
  }

  ngOnInit(): void {
    
  }
}
