package com.gkopec.springprojectquiz.service;


import com.gkopec.springprojectquiz.model.Quiz;
import com.gkopec.springprojectquiz.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Transactional
    public Quiz save (Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Transactional(readOnly = true)
    public List<Quiz> findAll() {
        return quizRepo.findAll();
    }

    @Transactional
    public Quiz findById(Long id) {
        Optional<Quiz> optionalQuiz = quizRepo.findById(id);
        Quiz quiz = optionalQuiz
                .orElseThrow(() ->new EntityNotFoundException("Quiz not found"));
        return quiz;
    }


}
