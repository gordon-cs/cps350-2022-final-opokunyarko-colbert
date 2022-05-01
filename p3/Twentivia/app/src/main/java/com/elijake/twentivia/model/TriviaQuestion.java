package com.elijake.twentivia.model;

import java.util.*;


public class TriviaQuestion {

    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    /**Get the question of a trivia question
     *
     * @return String question - the queston
     */
    public String getQuestion() {
        return question;
    }

    /**Get the correct answer of a trivia question
     *
     * @return String correctAnswer - the correct answer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**Get 4 possible answers to a trivia question in a random order
     *
     * @return List<String> answers - a list of possible answers
     */
    public List<String> getShuffledAnswers() {
        List<String> answers = null;
        answers.addAll(incorrectAnswers);
        answers.add(correctAnswer);

        Collections.shuffle(answers);

        return answers;
    }
}
