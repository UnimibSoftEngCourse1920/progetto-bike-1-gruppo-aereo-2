import { TestBed } from '@angular/core/testing';

import { AbbonamentiService } from './abbonamenti.service';

describe('AbbonamentiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AbbonamentiService = TestBed.get(AbbonamentiService);
    expect(service).toBeTruthy();
  });
});
