import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BulkpointallocaterComponent } from './bulkpointallocater.component';

describe('BulkpointallocaterComponent', () => {
  let component: BulkpointallocaterComponent;
  let fixture: ComponentFixture<BulkpointallocaterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BulkpointallocaterComponent]
    });
    fixture = TestBed.createComponent(BulkpointallocaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
