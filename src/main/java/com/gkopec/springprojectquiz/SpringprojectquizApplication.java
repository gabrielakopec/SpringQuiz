package com.gkopec.springprojectquiz;

import com.gkopec.springprojectquiz.model.Question;
import com.gkopec.springprojectquiz.model.Quiz;
import com.gkopec.springprojectquiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringprojectquizApplication implements CommandLineRunner {

    @Autowired
    private QuizService quizService;

    public static void main(String[] args) {
        SpringApplication.run(SpringprojectquizApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        addHorsesQuiz();
        addKamienieSzlachetneQuiz();
    }


    public void addHorsesQuiz() {
        Quiz quiz = new Quiz();
        quiz.setTitle("Konie");

        Question question1 = new Question();
        question1.setContent("W jaki sposób koń porusza się najszybciej?");
        question1.setAnswer1("kłusem");
        question1.setAnswer2("galopem");
        question1.setAnswer3("stępem");
        question1.setCorrectAnswer("cwałem");

        Question question2 = new Question();
        question2.setContent("Czarny koń to inaczej:");
        question2.setAnswer1("bułany");
        question2.setAnswer2("gniady");
        question2.setAnswer3("dereszowaty");
        question2.setCorrectAnswer("kary");

        Question question3 = new Question();
        question3.setContent("Jak nazywał się koń Piłsudskiego?");
        question3.setAnswer1("Baśka");
        question3.setAnswer2("Tornado");
        question3.setAnswer3("Siwa");
        question3.setCorrectAnswer("Kasztanka");

        Set<Question> questions = new HashSet<>(Arrays.asList(question1, question2, question3));
        quiz.setQuestions(questions);
        quizService.save(quiz);
    }

    public void addKamienieSzlachetneQuiz() {
        Quiz quiz = new Quiz();
        quiz.setTitle("Kamienie szlachetne");

        Question question1 = new Question();
        question1.setContent("Jak nazywał się diament wspomniany w filmie pt. Titanic");
        question1.setAnswer1("Głębia serca");
        question1.setAnswer2("Niebieski cud morski");
        question1.setAnswer3("Szafirowe spojrzenie");
        question1.setCorrectAnswer("Serce oceanu");

        Question question2 = new Question();
        question2.setContent("Brylant zdobiący brytyjskie berło królewskie to: ");
        question2.setAnswer1("Mała Gwiazda Afryki");
        question2.setAnswer2("Druga Gwiazda Afryki");
        question2.setAnswer3("Piękna Gwiazda Afryki");
        question2.setCorrectAnswer("Wielka Gwiazda Afryki");

        Question question3 = new Question();
        question3.setContent("Blue Belle of Asia to:");
        question3.setAnswer1("diament");
        question3.setAnswer2("rubin");
        question3.setAnswer3("szmaragd");
        question3.setCorrectAnswer("szafir");

        Set<Question> questions = new HashSet<>(Arrays.asList(question1, question2, question3));
        quiz.setQuestions(questions);
        quizService.save(quiz);
    }


}
