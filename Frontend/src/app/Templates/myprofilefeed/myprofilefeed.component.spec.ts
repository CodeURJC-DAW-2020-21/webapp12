import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyprofilefeedComponent } from './myprofilefeed.component';

describe('MyprofilefeedComponent', () => {
  let component: MyprofilefeedComponent;
  let fixture: ComponentFixture<MyprofilefeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyprofilefeedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyprofilefeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
