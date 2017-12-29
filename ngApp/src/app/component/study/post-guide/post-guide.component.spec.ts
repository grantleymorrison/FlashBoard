import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostGuideComponent } from './post-guide.component';

describe('PostGuideComponent', () => {
  let component: PostGuideComponent;
  let fixture: ComponentFixture<PostGuideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostGuideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostGuideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
