package io.flashboard.beans.studyguide;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.flashboard.beans.quiz.Comment;
import io.flashboard.beans.quiz.Rating;

@Entity
@Table(name="STUDY_GUIDE")
public class StudyGuide {
	@Id
	@Column(name="GUIDE_ID")
	@SequenceGenerator(sequenceName="GUIDE_SEQ", name="GUIDE_SEQ") //seqe for incrementing id 
	@GeneratedValue(generator="GUIDE_SEQ", strategy=GenerationType.SEQUENCE)
	private int studyGuideId;
	
	@Column(name="GUIDE_TITLE")
	private String title;
	
	@OrderColumn(name="GUIDE_BODY")
	private ArrayList<String> body;
	
	@Column(name="GUIDE_IMG")
	private String imgUrl;
	
	@Column(name="AUTHOR")
	private String author;
	
	@OrderColumn(name="COMMENTS")
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment>comments;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RATING_ID")
	private Rating ratings;
	
	@Column(name="CREATED_ON")
	private LocalDateTime createdDate;
	
	// no arg constructor
	public StudyGuide() {
		super();
	}
	
	// constructor for new post
	// contains title, body, imgUrl, author, time
	public StudyGuide(String title, ArrayList<String> body, String imgUrl, String author, LocalDateTime createdDate ) {
		super();
		this.title = title;
		this.body = body;
		this.imgUrl = imgUrl;
		this.author = author;
		this.createdDate = createdDate;
	}
	
	// no id constructor
	public StudyGuide(String title, ArrayList<String> body, String imgUrl, String author, List<Comment> comments, Rating ratings,
			LocalDateTime createdDate) {
		super();
		this.title = title;
		this.body = body;
		this.imgUrl = imgUrl;
		this.author = author;
		this.comments = comments;
		this.ratings = ratings;
		this.createdDate = createdDate;
	}
	
	// all field constructor
	public StudyGuide(int studyGuideId, String title, ArrayList<String> body, String imgUrl, String author, List<Comment> comments,
			Rating ratings, LocalDateTime createdDate) {
		super();
		this.studyGuideId = studyGuideId;
		this.title = title;
		this.body = body;
		this.imgUrl = imgUrl;
		this.author = author;
		this.comments = comments;
		this.ratings = ratings;
		this.createdDate = createdDate;
	}
	

	@Override
	public String toString() {
		return "StudyGuide [studyGuideId=" + studyGuideId + ", title=" + title + ", body=" + body + ", imgUrl=" + imgUrl
				+ ", author=" + author + ", comments=" + comments + ", ratings=" + ratings + ", createdDate="
				+ createdDate + "]";
	}

	public int getStudyGuideId() {
		return studyGuideId;
	}
	public void setStudyGuideId(int studyGuideId) {
		this.studyGuideId = studyGuideId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<String> getBody() {
		return body;
	}
	public void setBody(ArrayList<String> body) {
		this.body = body;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Rating getRatings() {
		return ratings;
	}
	public void setRatings(Rating ratings) {
		this.ratings = ratings;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
