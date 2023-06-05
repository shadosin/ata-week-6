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
    public AlexaAnswer findBestAnswer(AlexaQuestion question){
        List<AlexaAnswer> allAnswers = findAnswers(question);
        AlexaAnswer bestAnswer = null;
        double highestAnswerQuality = 0.0;

        for(AlexaAnswer answer: allAnswers){
            if(answer.getAnswerQuality() > highestAnswerQuality){
                highestAnswerQuality = answer.getAnswerQuality();
                bestAnswer = answer;
            }
        }
        return bestAnswer;
    }

    //TODO: Implement this method
    public void submitQuestionAnswerSuggestions(AlexaQuestion question, List<AlexaAnswer> answers){
        for(AlexaAnswer answer: answers){
            submitQuestionAnswerSuggestion(question, answer);
        }
    }
}
