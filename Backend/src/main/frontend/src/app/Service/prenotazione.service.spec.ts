import { TestBed } from '@angular/core/testing';

import { PrenotazioneService } from './prenotazione.service';

describe('PrenotazioneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PrenotazioneService = TestBed.get(PrenotazioneService);
    expect(service).toBeTruthy();
  });
});
