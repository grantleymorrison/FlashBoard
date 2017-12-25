package io.flashboard.beans.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating {
	
	// Properties
	@Id
	@Column(name = "RATING_ID")
	@SequenceGenerator(sequenceName = "RATING_SEQ", name = "RATING_SEQ")
	@GeneratedValue(generator = "RATING_SEQ", strategy = GenerationType.SEQUENCE)
	private int ratingId;
	
	@Column(name="EASY_COUNT")
	private int easy;
	
	@Column(name="HARD_COUNT")
	private int hard;
	
	@Column(name="LIKE_COUNT")
	private int like;
	
	@Column(name="DISLIKE_COUNT")
	private int dislike;
	
	// Constructor using no fields;
	public Rating() {
		super();
	}

	// Constructor using no ratingId
	public Rating(int easy, int hard, int like, int dislike) {
		super();
		this.easy = easy;
		this.hard = hard;
		this.like = like;
		this.dislike = dislike;
	}

	// Constructor using all fields
	public Rating(int ratingId, int easy, int hard, int like, int dislike) {
		super();
		this.ratingId = ratingId;
		this.easy = easy;
		this.hard = hard;
		this.like = like;
		this.dislike = dislike;
	}

	// Override Methods
	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", easy=" + easy + ", hard=" + hard + ", like=" + like + ", dislike="
				+ dislike + "]";
	}
	
	// Getters and setters
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getEasy() {
		return easy;
	}
	public void setEasy(int easy) {
		this.easy = easy;
	}
	public int getHard() {
		return hard;
	}
	public void setHard(int hard) {
		this.hard = hard;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getDislike() {
		return dislike;
	}
	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	
}
