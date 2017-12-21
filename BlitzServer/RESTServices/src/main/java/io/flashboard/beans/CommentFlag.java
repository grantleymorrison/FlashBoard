package io.flashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CommentFlag {
	
	@Id
	@SequenceGenerator(sequenceName="CF_SEQ", name="CF_SEQ")
	@GeneratedValue(generator="CF_SEQ", strategy=GenerationType.SEQUENCE)
	private int commentId;
	
	//TODO map this to ComprehensionTest
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private ComprehensionTest ct2;

	public CommentFlag() {
		super();
	}
	
}
