package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.studyguide.StudyGuide;

public interface StudyGuideDao {
	public boolean addStudyGuide(String title, String[] body, String imgUrl, String author);
	public StudyGuide getStudyGuide(String title);
	public List<StudyGuide> getAllStudyGuides();
}
