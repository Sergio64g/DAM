import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { CardCocheComponent } from './Components/card-coche/card-coche.component';
import { CardColorComponent } from './Components/card-color/card-color.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    CardCocheComponent,
    CardColorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
