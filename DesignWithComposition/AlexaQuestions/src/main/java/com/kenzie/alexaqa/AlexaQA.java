package com.kenzie.alexaqa;

import java.util.List;

/** Alexa question answering (QA) interface provides a method to retrieve answers for
 * a provided question and a method to submit an answer suggestion for a given question.
 */
public interface AlexaQA {
    /**
     * Returns all answers related to the given Alexa question.
     * @param question Alexa question containing the question content and user id.
     * @return returns all possible answers for the provided question.
     */
    List<AlexaAnswer> findAnswers(AlexaQuestion question);

    /**
     * This method allows submission of a proposed answer for a given question.
     * @param question Question for which we're suggesting the answer.
     * @param answer The suggested answer.
     */
    void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer);
}
