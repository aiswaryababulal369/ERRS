import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BytesallocaterComponent } from './bytesallocater.component';

describe('BytesallocaterComponent', () => {
  let component: BytesallocaterComponent;
  let fixture: ComponentFixture<BytesallocaterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BytesallocaterComponent]
    });
    fixture = TestBed.createComponent(BytesallocaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
