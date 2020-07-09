import { Component, OnInit } from "@angular/core";
import { DataServiceService } from "../Service/data-service.service";
import { HttpClient } from "@angular/common/http";

interface viewBikeList {
  vPlateNo: String;
  vMake: String;
  vModel: String;
  vTransmission: String;
  vRatePerDay: number;
  mPetrolCapaciy: number;
  mType: String;
  mModelYear : number;
}

export class Schedule {
  cusID: String;
  vPlateNo: String;
  sPickUpDate: Date;
  sDropOffDate: Date;
  constructor() {}
}

@Component({
  selector: "app-add-bike-schedule",
  templateUrl: "./add-bike-schedule.component.html",
  styleUrls: ["./add-bike-schedule.component.css"]
})
export class AddBikeScheduleComponent implements OnInit {
  schedule: Schedule;
  schedules: Schedule;
  cusID;
  vPlateNo;
  sDropOffDate;
  sPickUpDate;
  Data: Object;

  constructor(private service: DataServiceService, private http: HttpClient) {}

  viewBikeLists: viewBikeList[] = [];

  ngOnInit() {
    var carURL = "http://localhost:8080/vehicle-bike/motorbike";

    this.http.get<viewBikeList[]>(carURL).subscribe(details => {
      this.viewBikeLists = details;
    });
  }
  
  AddBikeSchedule() {
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
    this.service.AddBikeSchedule(this.schedule).subscribe(
      Response => {
        console.log(Response);
        alert("Schedule successfully created!");
      },
      error => {
        console.log(error);
        alert("Sorry! Schedule couldn't be created.");
      }
    );
    }
  }
}
