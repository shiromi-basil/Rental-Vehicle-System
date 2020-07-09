import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpHeaders
} from "@angular/common/http";
import { Schedule } from '../add-car-schedule/add-car-schedule.component';

@Injectable({
  providedIn: "root"
})
export class DataServiceService {
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
  };

  constructor(private http: HttpClient) {}

  AddCarSchedule(schedule: Schedule) {
    return this.http.post(
      "http://localhost:8080/vehicle-car/schedule", schedule
    );
  }

  AddBikeSchedule(schedule: Schedule) {
    return this.http.post(
      "http://localhost:8080/vehicle-bike/schedule", schedule
    );
  }
}
