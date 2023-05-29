package com.kenzie.alexaqa;

public class TranslatedAlexaQAClient {
    private BestAnswerAlexaQAClient bestAnswerAlexaQAClient;
    private AlexaTranslator translator;

    public TranslatedAlexaQAClient(BestAnswerAlexaQAClient bestAnswerAlexaQAClient, AlexaTranslator translator) {
        this.bestAnswerAlexaQAClient = bestAnswerAlexaQAClient;
        this.translator = translator;
    }

    // TODO: Implement this method
    public String findBestAnswerAndTranslate(AlexaQuestion question) {
        return null;
    }
}
