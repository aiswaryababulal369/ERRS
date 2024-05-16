import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewrewardComponent } from './newreward.component';

describe('NewrewardComponent', () => {
  let component: NewrewardComponent;
  let fixture: ComponentFixture<NewrewardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NewrewardComponent]
    });
    fixture = TestBed.createComponent(NewrewardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
