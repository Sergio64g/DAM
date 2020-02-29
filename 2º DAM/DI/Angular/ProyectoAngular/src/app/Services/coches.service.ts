import { Injectable } from "@angular/core";
import { coche } from "../Utils/coche";
import { ColoresService } from "./colores.service";
import { color } from "../Utils/color";

@Injectable({
  providedIn: "root"
})
export class CochesService {
  allColores: color[];
    renaultMegane: coche = {
    nombre: "Megane",
    marca: "Renault",
    caballos: 150,
    detalles:
      "El Renault Mégane es un automóvil del segmento C producido por el fabricante francés Renault. El Mégane es el sustituto del Renault 19 y existen cuatro generaciones, lanzadas en los años 1995, 2002, 2008 y 2016 respectivamente.",
    imagen: "../assets/images/renaultMegane.png",
    colores: [this.coloresServicio.color("Azul"),this.coloresServicio.color("Blanco"), this.coloresServicio.color("Negro")]
  };
  renaultClio: coche = {
    nombre: "Clio",
    marca: "Renault",
    caballos: 120,
    detalles:
      "El Renault Clio es un automóvil perteneciente al segmento B producido por el fabricante francés de automóviles Renault. Se comenzó a comercializar en 1990 como sucesor del Renault Supercinco. El Clio no se comercializa con este nombre en todos los países. En Japón es conocido por el de Lutecia, nombre que alude al origen romano de la ciudad de París.",
    imagen: "../assets/images/renaultClio.png",
    colores: [this.coloresServicio.color("Verde"), this.coloresServicio.color("Blanco"), this.coloresServicio.color("Morado")]
  };
  renaultCaptur: coche = {
    nombre: "Captur",
    marca: "Renault",
    caballos: 160,
    detalles:
      "Nuevo Renault CAPTUR se reinventa con un diseño aún más moderno y dinámico que aporta una mayor sensación de conducción. Un diseño que reafirma todos los códigos del SUV con líneas más marcadas, calandra vertical, faros más expresivos, laterales esculpidos y una mayor distancia al suelo.",
    imagen: "../assets/images/renaultCaptur.png",
    colores: [this.coloresServicio.color("Rojo"), this.coloresServicio.color("Blanco"),this.coloresServicio.color("Negro")]
  };
  seatAteca: coche = {
    nombre: "Ateca",
    marca: "Seat",
    caballos: 100,
    detalles: "detalles SeatAteca",
    imagen: "../assets/images/seatAteca.png",
    colores: [this.coloresServicio.color("Azul"), this.coloresServicio.color("Rojo"), this.coloresServicio.color("Negro")]
  };
  seatIbiza: coche = {
    nombre: "Ibiza",
    marca: "Seat",
    caballos: 90,
    detalles: "detalles SeatIbiza",
    imagen: "../assets/images/seatIbiza.png",
    colores: [this.coloresServicio.color("Blanco"), this.coloresServicio.color("Verde"), this.coloresServicio.color("Rojo")]
  };
  seatLeon: coche = {
    nombre: "Leon",
    marca: "Seat",
    caballos: 150,
    detalles: "detalles SeatLeon",
    imagen: "../assets/images/seatLeon.png",
    colores: [this.coloresServicio.color("Blanco"), this.coloresServicio.color("Morado"), this.coloresServicio.color("Gris")]
  };
  teslaModelX: coche = {
    nombre: "ModelX",
    marca: "Tesla",
    caballos: 160,
    detalles: "detalles TeslaModelX",
    imagen: "../assets/images/teslaModelx.png",
    colores: [this.coloresServicio.color("Blanco"), this.coloresServicio.color("Negro")]
  };
  teslaModelS: coche = {
    nombre: "ModelS",
    marca: "Tesla",
    caballos: 190,
    detalles: "detalles TeslaModelS",
    imagen: "../assets/images/teslaModelS.png",
    colores: [this.coloresServicio.color("Rojo"),this.coloresServicio.color("Gris")]
  };
  teslaModel3: coche = {
    nombre: "Model3",
    marca: "Tesla",
    caballos: 210,
    detalles: "detalles TeslaModel3",
    imagen: "../assets/images/teslaModel3.png",
    colores: [this.coloresServicio.color("Negro"), this.coloresServicio.color("Verde")]
  };
  arrayCoches: coche[] = [
    this.renaultMegane,
    this.renaultClio,
    this.renaultCaptur,
    this.seatAteca,
    this.seatIbiza,
    this.seatLeon,
    this.teslaModelX,
    this.teslaModelS,
    this.teslaModel3
  ];

  constructor(private coloresServicio: ColoresService) {}


  getCoches(): coche[] {
    return this.arrayCoches;
  }
  getCocheMarca(marca: string): coche[] {
    let cochesFiltrados: coche[] = [];
    this.getCoches().forEach(element => {
      if (element.marca === marca) {
        cochesFiltrados.push(element);
      }
    });
    return cochesFiltrados;
  }

  getCocheModelo(modelo: string): coche[] {
    let cochesFiltrados: coche[] = [];
    this.getCoches().forEach(element => {
      if (element.nombre === modelo) {
        cochesFiltrados.push(element);
      }
    });
    return cochesFiltrados;
  }

 
}
