package com.gkopec.springprojectquiz.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;
    private String title;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Set<Question> questions;

    public Quiz() {
    }

    public Quiz(Long id, String title, Set<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }


}
