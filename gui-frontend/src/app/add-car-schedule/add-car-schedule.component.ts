import { Component, OnInit } from "@angular/core";
import { DataServiceService } from "../Service/data-service.service";
import { HttpClient } from "@angular/common/http";

interface viewCarList {
  vPlateNo: String;
  vMake: String;
  vModel: String;
  vTransmission: String;
  vRatePerDay: number;
  cNoOfDoors: number;
  cNoOfSeats: number;
  cAirCondition: boolean;
}

export class Schedule {
  cusID: String;
  vPlateNo: String;
  sPickUpDate: Date;
  sDropOffDate: Date;
  constructor() {}
}

@Component({
  selector: "app-add-car-schedule",
  templateUrl: "./add-car-schedule.component.html",
  styleUrls: ["./add-car-schedule.component.css"],
})
export class AddCarScheduleComponent implements OnInit {
  schedule: Schedule;
  schedules: Schedule;
  cusID;
  vPlateNo;
  sDropOffDate;
  sPickUpDate;
  Data: Object;

  constructor(private service: DataServiceService, private http: HttpClient) {}

  viewCarLists: viewCarList[] = [];

  ngOnInit() {
    var carURL = "http://localhost:8080/vehicle-car/car";

    this.http.get<viewCarList[]>(carURL).subscribe((details) => {
      this.viewCarLists = details;
    });
  }

  AddCarSchedule() {
    this.schedule = new Schedule();
    this.schedule.cusID = this.cusID;
    this.schedule.vPlateNo = this.vPlateNo;
    this.schedule.sDropOffDate = this.sDropOffDate;
    this.schedule.sPickUpDate = this.sPickUpDate;

    var validForm = true;

    var cusIDForm = (<HTMLInputElement>(
      document.getElementById("cusID")
    )).value;

    var vPlateNoForm = (<HTMLInputElement>(
      document.getElementById("vPlateNo")
    )).value;

    var sDropOffDateForm = (<HTMLInputElement>(
      document.getElementById("sDropOffDate")
    )).value;

    var sPickUpDateForm = (<HTMLInputElement>(
      document.getElementById("sPickUpDate")
    )).value;

    if (cusIDForm.length <= 0) {
      alert("Customer ID is required!");
      validForm = false;
    } else if (vPlateNoForm.length <= 0) {
      alert("Vehicle Plate Number is required!");
      validForm = false;
    } else if (!sDropOffDateForm) {
      alert("Drop-off Date is required!");
      validForm = false;
    } else if (!sPickUpDateForm) {
      alert("Pick-up Date is required!");
      validForm = false;
    }

    if (validForm) {
      this.service.AddCarSchedule(this.schedule).subscribe(
        (Response) => {
          console.log(Response);
          alert("Schedule successfully created!");
        },
        (error) => {
          console.log(error);
          alert("Sorry! Schedule couldn't be created.");
        }
      );
    }
  }
}
