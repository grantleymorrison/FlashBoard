package io.flashboard.dao;

import java.util.Set;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;


public interface QuizDao {
	
	public boolean createQuizMinArgs(String quizTitle, String topic, String description);
	public boolean createQuiz(String quizTitle, String topic, String description, Set<QuizQuestion> questions,
			String creatorId, int maxScore);
	
	public boolean insertQuiz(Quiz quiz);
		
	public boolean addCommentByQuizId(int quizId, String username, String content);
	
	public boolean removeQuizByQuizId(int quizId); 
	public boolean removeQuizByTitle(String quizTitle); 
	public int addQuestionToQuizByQuizId(int quizId, QuizQuestion question);
	public int removeQuestionFromQuizByQuizId(int quizId, QuizQuestion question); 
	public int addQuestionToReserve(QuizQuestion question); 
	public int removeQuestionFromReseverById(int quizId); 
	
	public Quiz getQuizById(int quizId); 
	public Quiz getQuizByTitle(String quizTitle); 
	
}
