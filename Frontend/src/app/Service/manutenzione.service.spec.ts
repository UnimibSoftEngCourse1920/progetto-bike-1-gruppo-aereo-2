import { TestBed } from '@angular/core/testing';

import { ManutenzioneService } from './manutenzione.service';

describe('ManutenzioneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManutenzioneService = TestBed.get(ManutenzioneService);
    expect(service).toBeTruthy();
  });
});
