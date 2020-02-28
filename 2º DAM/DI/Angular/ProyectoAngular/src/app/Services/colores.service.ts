import { Injectable } from "@angular/core";
import { color } from "../Utils/color";

@Injectable({
  providedIn: "root"
})
export class ColoresService {
  rojo: color = { nombre: "Rojo", hex: "#DE0000", texto: "#FFFFFF" };
  azul: color = { nombre: "Azul", hex: "#3498DB", texto: "#FFFFFF" };
  verde: color = { nombre: "Verde", hex: "#229954", texto: "#000000" };
  negro: color = { nombre: "Negro", hex: "#000000", texto: "#FFFFFF" };
  blanco: color = { nombre: "Blanco", hex: "#FFFFFF", texto: "#000000" };
  morado: color = { nombre: "Morado", hex: "#8E44AD", texto: "#000000" };
  gris: color = { nombre: "Gris", hex: "#7F8C8D", texto: "#000000" };

  allColores: color[] = [
    this.rojo,
    this.azul,
    this.verde,
    this.negro,
    this.blanco,
    this.morado,
    this.gris
  ];
  constructor() {}
  color(color: string): color {
    return this.allColores.find(x => x.nombre === color);
  }
  getColores(): color[] {
    return this.allColores;
  }
}
