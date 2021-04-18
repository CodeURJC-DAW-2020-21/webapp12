import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileaccountsettingsComponent } from './profileaccountsettings.component';

describe('ProfileaccountsettingsComponent', () => {
  let component: ProfileaccountsettingsComponent;
  let fixture: ComponentFixture<ProfileaccountsettingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileaccountsettingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileaccountsettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
