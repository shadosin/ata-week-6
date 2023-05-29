package com.kenzie.alexaqa;

import java.util.List;

public class BestAnswerAlexaQAClient {
    private AlexaQA alexaQA;

    public BestAnswerAlexaQAClient(AlexaQA alexaQA) {
        this.alexaQA = alexaQA;
    }

    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        return alexaQA.findAnswers(question);
    }

    public void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer) {
        alexaQA.submitQuestionAnswerSuggestion(question, answer);
    }

    //TODO: Implement this method
    public AlexaAnswer findBestAnswer(AlexaQuestion question) {
        return new AlexaAnswer("", 0.0);
    }

    //TODO: Implement this method
    public void submitQuestionAnswerSuggestions(AlexaQuestion question, List<AlexaAnswer> answers) {

    }
}
