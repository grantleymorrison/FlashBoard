package io.flashboard.dao;

import java.util.List;

import io.flashboard.beans.ComprehensionTest;
import io.flashboard.beans.TestQuestion;

public interface TestDao {
	//TestQuestions
	public boolean createTestQuestion();
	
	//Tests
	public ComprehensionTest selectTestById(int testId);
	public void removeTestById(int testId);
	
	public boolean createComprehensionTest();
	public boolean createTrueFalseTestQuestion();
	public boolean createOneCorrectTestQuestion();
	public List<TestQuestion> selectTestsMadeByUserId(int userId);

}
