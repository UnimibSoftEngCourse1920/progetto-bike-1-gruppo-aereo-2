import { TestBed } from '@angular/core/testing';

import { ContoService } from './conto.service';

describe('ContoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ContoService = TestBed.get(ContoService);
    expect(service).toBeTruthy();
  });
});
