package com.hibernate.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answers {
    @Id
    @Column(name = "answers_id")
	private int answers_id;
    
    @Column(name = "answers")
	private String answers;
    
    @OneToOne(mappedBy = "answer")
    @JoinColumn(name="q_id")
    private Question question;
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answers() {
		super();
	}

	public Answers(int answers_id, String answers) {
		super();
		this.answers_id = answers_id;
		this.answers = answers ;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public int getAnswers_id() {
		return answers_id;
	}

	public void setAnswers_id(int answers_id) {
		this.answers_id = answers_id;
	}

	
}
