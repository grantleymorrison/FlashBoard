package io.flashboard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.flashboard.dao.StudyGuideDao;
import io.flashboard.dao.StudyGuideDaoImpl;
import io.flashboard.jsonbeans.StudyGuideData;

public class StudyGuideService {

	public static boolean validate(StudyGuideData guideData) {
		StudyGuideDao sgdao = new StudyGuideDaoImpl();
		String title = guideData.getTitle();
		String[] body =guideData.getBody();
		String imgUrl = guideData.getImgUrl();
		String author = guideData.getAuthor();
		
		if(title.trim().isEmpty() || author.isEmpty() || body.length == 0) {
			return false;
		}

		return sgdao.addStudyGuide(title, body, imgUrl, author);
	}
	
}
