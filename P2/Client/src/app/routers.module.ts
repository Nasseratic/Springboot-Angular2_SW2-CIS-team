import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent }      from './components/home/home.component';
import { GameCardComponent }   from './components/game-card/game-card.component';
import { CourseCardComponent }   from './components/course-card/course-card.component';
import { QCardComponent }   from './components/q-card/q-card.component';
import { CreateCourseComponent }   from './components/create-course/create-course.component';
import { CreateGameComponent }   from './components/create-game/create-game.component';

import {SignUp} from './components/signup';
const routes: Routes = [
  //{ path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '',  component: HomeComponent },
  { path: 'game/:id', component: QCardComponent },
  { path: 'course/:id', component: GameCardComponent },  
  { path: 'courses/:id', component: CourseCardComponent },    
  { path: 'create/course', component: CreateCourseComponent },    
  { path: 'create/game/:id', component: CreateGameComponent },
  { path: 'create/game/:id/:edit', component: CreateGameComponent },              
  { path: 'signup', component: SignUp },  
  { path: '**', redirectTo: '/' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}