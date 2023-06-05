package com.kenzie.alexaqa;

import java.util.List;

public class ReadOnlyAlexaQAClient {

    private AlexaQA alexaQA;

    //TODO: Finish implementing this constructor
    public ReadOnlyAlexaQAClient(AlexaQA alexaQA) {
        this.alexaQA = alexaQA;
    }

    //TODO: Finish implementing this method
    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        return alexaQA.findAnswers(question);
    }
}
