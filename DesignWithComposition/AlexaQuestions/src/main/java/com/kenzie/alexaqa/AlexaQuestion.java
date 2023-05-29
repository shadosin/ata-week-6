package com.kenzie.alexaqa;

/**
 * Class representing a question to submit to Alexa question answering service.
 */
public class AlexaQuestion {
    // Actual question
    private String content;
    // User identifier which is relevant for getting the question context (e.g. user's location).
    private long userId;

    /**
     * Construct AlexaQuestion instance.
     * @param content string content of the question
     * @param userId user identifier
     */
    public AlexaQuestion(String content, long userId) {
        this.content = content;
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public long getUserId() {
        return userId;
    }
}
