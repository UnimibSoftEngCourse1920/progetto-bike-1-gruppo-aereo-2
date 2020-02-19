import { TestBed, async, inject } from '@angular/core/testing';

import { GenericGuard } from './generic.guard';

describe('GenericGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GenericGuard]
    });
  });

  it('should ...', inject([GenericGuard], (guard: GenericGuard) => {
    expect(guard).toBeTruthy();
  }));
});
