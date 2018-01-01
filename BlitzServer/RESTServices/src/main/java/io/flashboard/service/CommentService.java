package io.flashboard.service;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.studyguide.CommentSG;
import io.flashboard.dao.QuizDaoImpl;
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
	
	public static boolean addQuizComment(CommentData cd, int quizId) {
		QuizDaoImpl qdi = new QuizDaoImpl();
		
		Comment comment = new Comment(cd.getUsername(), cd.getContent());
		
		
		return qdi.addQuizComment(comment, quizId);
	}
}
