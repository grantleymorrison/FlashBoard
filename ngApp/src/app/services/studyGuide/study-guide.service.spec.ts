import { TestBed, inject } from '@angular/core/testing';

import { StudyGuideService } from './study-guide.service';

describe('StudyGuideService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StudyGuideService]
    });
  });

  it('should be created', inject([StudyGuideService], (service: StudyGuideService) => {
    expect(service).toBeTruthy();
  }));
});
