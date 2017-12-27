package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.quiz.Quiz;
import io.flashboard.beans.quiz.QuizQuestion;

public interface TestDao {
	//TestQuestions
	public boolean createTestQuestion();
	
	//Tests
	public Quiz selectTestById(int testId);
	public void removeTestById(int testId);
	
	public boolean createComprehensionTest();
	public boolean createTrueFalseTestQuestion();
	public boolean createOneCorrectTestQuestion();
	public List<QuizQuestion> selectTestsMadeByUserId(int userId);

}
