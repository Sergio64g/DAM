import { Component, OnInit } from "@angular/core";
import { CochesService } from "../../Services/coches.service";
import { coche } from "../../Utils/coche";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-card-coche",
  templateUrl: "./card-coche.component.html",
  styleUrls: ["./card-coche.component.css"]
})
export class CardCocheComponent implements OnInit {
  
  coches: coche[];
  parametro: string;

  constructor(
    private serviciosCoches: CochesService,
    private rutas: ActivatedRoute
  ) {
    this.coches = serviciosCoches.getCoches();
  }

  ngOnInit(): void {
    this.rutas.params.subscribe(element => {
      this.parametro = element.parametro;
    });
    if (this.parametro != null) {
      this.coches = this.serviciosCoches.getCocheMarca(this.parametro);
    }
  }
}
