package io.flashboard.jsonbeans;

import java.util.Arrays;

public class StudyGuideData {
	private String title;
	private String[] body;
	private String imgUrl;
	private String author;
	
	public StudyGuideData() {
		super();
	}
		
	@Override
	public String toString() {
		return "StudyGuideData [title=" + title + ", body=" + Arrays.toString(body) + ", imgUrl=" + imgUrl + ", author="
				+ author + "]";
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String[] getBody() {
		return body;
	}
	
	public void setBody(String[] body) {
		this.body = body;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
