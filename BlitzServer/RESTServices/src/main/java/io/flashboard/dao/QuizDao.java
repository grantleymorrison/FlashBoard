package io.flashboard.dao;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;

public interface QuizDao {
	
	public int insertQuiz(Quiz quiz);
	
	public boolean addCommentByQuizId(int quizId, String username, String content);
	
	public int removeQuizByQuizId(int quizId); 
	public int removeQuizByTitle(String quizTitle); 
	public int addQuestionToQuizByQuizId(int quizId, QuizQuestion question);
	public int removeQuestionFromQuizByQuizId(int quizId, QuizQuestion question); 
	public int addQuestionToReserve(QuizQuestion question); 
	public int removeQuestionFromReseverById(int quizId); 
	
	public Quiz getQuizById(int quizId); 
	public Quiz getQuizByTitle(String quizTitle); 
	
}
