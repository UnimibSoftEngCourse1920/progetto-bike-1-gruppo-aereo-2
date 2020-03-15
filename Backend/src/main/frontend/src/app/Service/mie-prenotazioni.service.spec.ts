import { TestBed } from '@angular/core/testing';

import { MiePrenotazioniService } from './mie-prenotazioni.service';

describe('MiePrenotazioniService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MiePrenotazioniService = TestBed.get(MiePrenotazioniService);
    expect(service).toBeTruthy();
  });
});
