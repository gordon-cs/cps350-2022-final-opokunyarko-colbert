package com.elijake.twentivia.model;

import java.util.*;


public class TriviaQuestion {

    // constructor

    public TriviaQuestion(String question, String correctAnswer, List<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**Get 4 possible answers to a trivia question in a random order
     *
     * @return List<String> answers - a list of possible answers
     */
    public List<String> getShuffledAnswers() {
        List<String> answers = new ArrayList<String>();
        answers.addAll(incorrectAnswers);
        answers.add(correctAnswer);

        Collections.shuffle(answers);

        return answers;
    }

    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;
}
