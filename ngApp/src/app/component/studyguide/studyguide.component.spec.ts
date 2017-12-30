import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudyGuideComponent } from './studyguide.component';

describe('StudyGuideComponent', () => {
  let component: StudyGuideComponent;
  let fixture: ComponentFixture<StudyGuideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudyGuideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudyGuideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
