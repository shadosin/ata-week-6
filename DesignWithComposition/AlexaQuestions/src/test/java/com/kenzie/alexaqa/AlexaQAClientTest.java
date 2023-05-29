package com.kenzie.alexaqa;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlexaQAClientTest {
    @Test
    public void findAnswers_anyQuestion_expectedNumberOfAnswers() {
        // GIVEN
        AlexaQAClient client = new AlexaQAClient();

        // WHEN
        List<AlexaAnswer> answers = client.findAnswers(new AlexaQuestion("random question", 1L));

        // THEN
        assertEquals(answers.size(), 6);
    }

    @Test
    public void submitQuestionAnswerSuggestion_anyPair_succeeds() {
        // GIVEN
        AlexaQAClient client = new AlexaQAClient();

        // WHEN & THEN
        client.submitQuestionAnswerSuggestion(
            new AlexaQuestion("random question", 1L),
            new AlexaAnswer("random answer", 0.5)
            );
    }
}
