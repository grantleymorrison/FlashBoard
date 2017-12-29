package io.flashboard.beans.studyguide;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@ElementCollection
	@Column(name = "GUIDE_BODY")
	private String[] body;
	
	@Column(name="GUIDE_IMG")
	private String imgUrl;
	
	@Column(name="AUTHOR")
	private String author;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name="COMMENTS")
	private Comment[] comments;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name="RATINGS")
	private Rating ratings;
	
	@Column(name="CREATED_ON")
	private LocalDateTime createdDate;
	
	// no arg constructor
	public StudyGuide() {
		super();
	}
	
	// no id constructor
	public StudyGuide(String title, String[] body, String imgUrl, String author, Comment[] comments, Rating ratings,
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
	public StudyGuide(int studyGuideId, String title, String[] body, String imgUrl, String author, Comment[] comments,
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
		return "StudyGuide [studyGuideId=" + studyGuideId + ", title=" + title + ", body=" + Arrays.toString(body)
				+ ", imgUrl=" + imgUrl + ", author=" + author + ", comments=" + Arrays.toString(comments) + ", ratings="
				+ ratings + ", createdDate=" + createdDate + "]";
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
	public String[] getBody() {
		return body;
	}
	public void setBody(String[] body) {
		this.body = body;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Comment[] getComments() {
		return comments;
	}
	public void setComments(Comment[] comments) {
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
