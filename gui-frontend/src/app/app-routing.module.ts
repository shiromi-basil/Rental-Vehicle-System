import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddCarScheduleComponent } from './add-car-schedule/add-car-schedule.component';
import { AddBikeScheduleComponent } from './add-bike-schedule/add-bike-schedule.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'car-schedule',
    component: AddCarScheduleComponent
  },
  {
    path: 'bike-schedule',
    component: AddBikeScheduleComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
