package com.kenzie.alexaqa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Our implementation of Alexa question answering client. Instead of implementing the complex
 * process described in the Readme we keep a finite set of answers that are provided regardless
 * of the question (movies inspired). Question and answer suggestion are stored in separate lists,
 * but are not processed (added to the "Alexa knowledge base").
 */
public class AlexaQAClient implements AlexaQA {

    // List of default answers to provide to the customer
    private final List<AlexaAnswer> answers = Arrays.asList(
        new AlexaAnswer("Sorry, I couldn't find an answer to that question.", 0.0),
        new AlexaAnswer("Frankly my dear, I don't give a damn.", 0.11),
        new AlexaAnswer("Are you talking to me?", 0.12),
        new AlexaAnswer("Go ahead, make my day.", 0.15),
        new AlexaAnswer("May the Force be with you.", 0.18),
        new AlexaAnswer("You can't handle the truth!", 0.17)
    );

    // Stores the questions
    private final List<AlexaQuestion> suggestedQuestions = new ArrayList<>();

    // Stores the suggested answers for the provided questions
    private final List<AlexaAnswer> suggestedAnswers = new ArrayList<>();

    @Override
    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        System.out.println("Searching an answer for the question: " + question.getContent());

        //check to see if answers are empty - if so, load the default answers
        if(suggestedAnswers == null || suggestedAnswers.isEmpty()){
            List<AlexaAnswer> alexaAnswers = new ArrayList<>();
            for (AlexaAnswer answer : answers) {
                alexaAnswers.add(answer);
            }
            return alexaAnswers;
        }

        return suggestedAnswers;
    }

    @Override
    public void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer) {
        System.out.println(
            "Thanks for your submission! " +
            "We will consider adding the suggested question and answer pair " +
            "to our knowledge base!");
        suggestedQuestions.add(question);
        suggestedAnswers.add(answer);
    }
}
