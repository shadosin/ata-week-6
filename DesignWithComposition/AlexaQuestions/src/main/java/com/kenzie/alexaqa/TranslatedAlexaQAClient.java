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
        AlexaAnswer bestAnswer = bestAnswerAlexaQAClient.findBestAnswer(question);
        if(bestAnswer != null){
            String content = bestAnswer.getContent();
            return translator.getTranslation(content);
        }
        return null;
    }
}
