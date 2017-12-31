package io.flashboard.service;

import io.flashboard.beans.studyguide.CommentSG;
import io.flashboard.dao.StudyGuideDaoImpl;
import io.flashboard.jsonbeans.CommentData;

public class CommentService {
	public static boolean addGuideComment(CommentData cd, int guideId) {
		StudyGuideDaoImpl sgdi = new StudyGuideDaoImpl();
		
		CommentSG comment = new CommentSG(cd.getUsername(), cd.getContent());
		
		if(sgdi.addGuideComment(comment, guideId)) {
			return true;
		}
		
		return false;
	}
}
