import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContoComponent } from './conto.component';

describe('ContoComponent', () => {
  let component: ContoComponent;
  let fixture: ComponentFixture<ContoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
