package com.hibernate.main;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int question_id;

	@Column(name = "question")
	private String question;
    
	@OneToMany
	private List<Answers> answers;

	public Question() {
		super();

	}

	public Question(int question_id, String question, List<Answers> answers) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.answers = answers;
	}

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
