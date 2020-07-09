import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCarScheduleComponent } from './add-car-schedule.component';

describe('AddCarScheduleComponent', () => {
  let component: AddCarScheduleComponent;
  let fixture: ComponentFixture<AddCarScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCarScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCarScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
