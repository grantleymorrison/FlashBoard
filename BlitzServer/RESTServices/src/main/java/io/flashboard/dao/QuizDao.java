package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;

public interface QuizDao {
	
	public List<Quiz> getAllQuizzes();
	
	public Integer insertQuiz(Quiz quiz);
	public boolean addCommentByQuizId(int quizId, String username, String content);
	public int removeQuizByQuizId(int quizId); 
	public int removeQuizByTitle(String quizTitle); 
	public int addQuestionToQuizByQuizId(int quizId, QuizQuestion question);
	public int removeQuestionFromQuizByQuizId(int quizId, QuizQuestion question); 
	public int addQuestionToReserve(QuizQuestion question); 
	public int removeQuestionFromReseverById(int quizId); 
	public Quiz getQuizById(int quizId); 
	public Quiz getQuizByTitle(String quizTitle); 
	public List<Comment> getQuizComments(int quizId);
	public boolean addQuizComment(Comment comment, int quizId); 
	
}
