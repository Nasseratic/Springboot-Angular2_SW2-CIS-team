import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule ,JsonpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import 'hammerjs';
import { myFooter } from './components/footer';
import { NavbarComponent,DialogResultExampleDialog1 } from './components/navbar/navbar.component';
import {AppRoutingModule} from './routers.module';
import { HomeModule }      from './components/home/home.module';
import {SignUp} from './components/signup';
import { QCardComponent } from './components/q-card/q-card.component';
import { CreateGameComponent } from './components/create-game/create-game.component';
import { CreateCourseComponent } from './components/create-course/create-course.component';
import { AuthService } from './services/auth.service';


@NgModule({
  declarations: [
    AppComponent,
    myFooter ,
    NavbarComponent,
    DialogResultExampleDialog1,
    SignUp,
    QCardComponent,
    CreateGameComponent,
    CreateCourseComponent
  ],
  entryComponents: [DialogResultExampleDialog1] ,
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    [MaterialModule] ,
    BrowserAnimationsModule,
    HomeModule,
    AppRoutingModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent],
  
})

export class AppModule {}
