package io.flashboard.dao;

import io.flashboard.beans.ComprehensionTest;

public interface TestDao {
	//Tests
	public ComprehensionTest selectTestById(int testId);
	public void removeTestById(int testId);
}
