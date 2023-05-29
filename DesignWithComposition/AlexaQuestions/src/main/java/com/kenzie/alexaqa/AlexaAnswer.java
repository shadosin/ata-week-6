package com.kenzie.alexaqa;

/**
 * Class representing an answer provided by Alexa question answering service.
 * The answer comes with an answer quality measure which indicates how likely it is
 * that the provided answer will correct for the given question.
 */
public class AlexaAnswer {
    // Actual question
    private String content;
    // Indicator of answer quality, between 0 and 1,
    // where 0 indicates the worst quality and 1 indicates the best quality.
    private double answerQuality;

    /**
     * Construct AlexaAnswer instance.
     * @param content string content of the answer
     * @param answerQuality number indicating quality of the answer
     */
    public AlexaAnswer(String content, double answerQuality) {
        this.content = content;
        this.answerQuality = answerQuality;
    }

    public String getContent() {
        return content;
    }

    public double getAnswerQuality() {
        return answerQuality;
    }
}
