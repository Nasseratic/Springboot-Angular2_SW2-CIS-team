import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule ,JsonpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import 'hammerjs';
import { myFooter } from './components/footer';
import { NavbarComponent,DialogResultExampleDialog2 } from './components/navbar/navbar.component';
import {AppRoutingModule} from './routers.module';
import { HomeModule }      from './components/home/home.module';
import {SignUp} from './components/signup';
import { QCardComponent ,DialogResultExampleDialog1 } from './components/q-card/q-card.component';
import { CreateGameComponent } from './components/create-game/create-game.component';
import { CreateCourseComponent } from './components/create-course/create-course.component';
import { AuthService } from './services/auth.service';
import {  PizzaPartyComponent } from './components/game-card/game-card.component';


@NgModule({
  declarations: [
    AppComponent,
    myFooter ,
    NavbarComponent,
    DialogResultExampleDialog2,
    DialogResultExampleDialog1,  
    SignUp,
    QCardComponent,
    CreateGameComponent,
    CreateCourseComponent,
    PizzaPartyComponent
  ],
  entryComponents: [DialogResultExampleDialog1,DialogResultExampleDialog2,PizzaPartyComponent] ,
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    [MaterialModule] ,
    BrowserAnimationsModule,
    HomeModule,
    AppRoutingModule,

  ],
  providers: [AuthService],
  bootstrap: [AppComponent],
  
})

export class AppModule {
  
}
/*
export function stormpathConfig(): StormpathConfiguration {
  let spConfig: StormpathConfiguration = new StormpathConfiguration();
  if (environment.production) {
    spConfig.endpointPrefix = 'https://pwa-server.cfapps.io';
  } else {
    spConfig.endpointPrefix = 'http://localhost:8080';
  }
  return spConfig;
}*/