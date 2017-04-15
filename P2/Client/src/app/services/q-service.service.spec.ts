import { TestBed, inject } from '@angular/core/testing';

import { QServiceService } from './q-service.service';

describe('QServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QServiceService]
    });
  });

  it('should ...', inject([QServiceService], (service: QServiceService) => {
    expect(service).toBeTruthy();
  }));
});
