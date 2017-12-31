package io.flashboard.jsonbeans;

public class QuestionData {
	private String question;
	private String canswer;
	private String wanswer1;
	private String wanswer2;
	private String wanswer3;
	
	//All args
	public QuestionData(String question, String canswer, String wanswer1, String wanswer2, String wanswer3) {
		super();
		this.question = question;
		this.canswer = canswer;
		this.wanswer1 = wanswer1;
		this.wanswer2 = wanswer2;
		this.wanswer3 = wanswer3;
	}

	//no args
	public QuestionData() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCanswer() {
		return canswer;
	}

	public void setCanswer(String canswer) {
		this.canswer = canswer;
	}

	public String getWanswer1() {
		return wanswer1;
	}

	public void setWanswer1(String wanswer1) {
		this.wanswer1 = wanswer1;
	}

	public String getWanswer2() {
		return wanswer2;
	}

	public void setWanswer2(String wanswer2) {
		this.wanswer2 = wanswer2;
	}

	public String getWanswer3() {
		return wanswer3;
	}

	public void setWanswer3(String wanswer3) {
		this.wanswer3 = wanswer3;
	}

	@Override
	public String toString() {
		return "QuestionData [question=" + question + ", canswer=" + canswer + ", wanswer1=" + wanswer1 + ", wanswer2="
				+ wanswer2 + ", wanswer3=" + wanswer3 + "]";
	}
	
	
}
