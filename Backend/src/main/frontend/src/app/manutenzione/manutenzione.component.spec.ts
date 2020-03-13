import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManutenzioneComponent } from './manutenzione.component';

describe('ManutenzioneComponent', () => {
  let component: ManutenzioneComponent;
  let fixture: ComponentFixture<ManutenzioneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManutenzioneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManutenzioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
