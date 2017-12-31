package io.flashboard.jsonbeans;

import java.util.List;

public class QuizData {
	private String quizTitle;
	private String quizTopic;
	private String creator;
	private List<QuestionData> questions;
	
	//All args
	public QuizData(String quizTitle, String quizTopic, String creator, List<QuestionData> questions) {
		super();
		this.quizTitle = quizTitle;
		this.quizTopic = quizTopic;
		this.creator = creator;
		this.questions = questions;
	}

	//no args
	public QuizData() {
		super();
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public String getQuizTopic() {
		return quizTopic;
	}

	public void setQuizTopic(String quizTopic) {
		this.quizTopic = quizTopic;
	}

	public List<QuestionData> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionData> questions) {
		this.questions = questions;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "QuizData [quizTitle=" + quizTitle + ", quizTopic=" + quizTopic + ", creator=" + creator + ", questions="
				+ questions + "]";
	}
	
}
