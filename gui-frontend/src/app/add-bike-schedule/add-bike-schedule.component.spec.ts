import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBikeScheduleComponent } from './add-bike-schedule.component';

describe('AddBikeScheduleComponent', () => {
  let component: AddBikeScheduleComponent;
  let fixture: ComponentFixture<AddBikeScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddBikeScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBikeScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
