package com.gkopec.springprojectquiz.controlller;

import com.gkopec.springprojectquiz.model.Question;
import com.gkopec.springprojectquiz.model.Quiz;
import com.gkopec.springprojectquiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping(path = {"index.jsp", "index", "/"})
    String home(Model model) {
        model.addAttribute("quizList", quizService.findAll());

        return "index";
    }

    @GetMapping("/solveQuiz")
    String solveQuiz(@RequestParam("id") Long id, Model model) {
        model.addAttribute("quiz", quizService.findById(id));

        return "quiz";
    }

    @PostMapping("/result")
    String result(HttpServletRequest request, @RequestParam("quizId") Long id, Model model) {
        Quiz quiz = quizService.findById(id);
        int maxPoints = quiz.getQuestions().size();
        int points = 0;

        for (Question q : quiz.getQuestions()) {
            String answer = request.getParameter(String.valueOf(q.getId()));
            if (answer.equals(q.getCorrectAnswer())) {
                points++;
            }
        }

        model.addAttribute("max", maxPoints);
        model.addAttribute("points", points);

        return "result";
    }


}
