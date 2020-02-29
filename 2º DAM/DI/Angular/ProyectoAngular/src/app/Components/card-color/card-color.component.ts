import { Component, OnInit } from '@angular/core';
import { ColoresService } from '../../Services/colores.service';
import { color } from '../../Utils/color';

@Component({
  selector: 'app-card-color',
  templateUrl: './card-color.component.html',
  styleUrls: ['./card-color.component.css']
})
export class CardColorComponent implements OnInit {

  colores: color[];
  
  constructor(private servicioColores: ColoresService) { 
    this.colores = servicioColores.getColores();
  }

  ngOnInit(): void {
  }

  contador(){
    let cont = 0;// iniciamos el contador en 0
    this.colores.forEach(element => {
      cont++;
    });
    return cont; // retornamos el valor de contador(cuantas butacas tienen estado 1)
}

}
