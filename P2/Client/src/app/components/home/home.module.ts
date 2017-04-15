import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule ,JsonpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import 'hammerjs';
import { CourseCardComponent } from '../course-card/course-card.component';
import { GameCardComponent } from '../game-card/game-card.component';
import { HomeComponent } from './home.component';
/*
import { GameViewComponent } from './components/game-view/game-view.component';
import { HomeComponent } from './components/home/home.component'
*/

@NgModule({
  declarations: [
    HomeComponent,
    CourseCardComponent,
    GameCardComponent,
    
  ],
   exports: [
    HomeComponent,
    CourseCardComponent,
    GameCardComponent
     ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    [MaterialModule] ,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [HomeComponent],
  
})

export class HomeModule {}
