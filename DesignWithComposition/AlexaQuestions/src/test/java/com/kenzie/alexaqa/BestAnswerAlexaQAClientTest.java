package com.kenzie.alexaqa;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BestAnswerAlexaQAClientTest {

    // Introspective tests - YOU ARE NOT EXPECTED TO UNDERSTAND OR TOUCH THESE TESTS
    // AT THIS POINT, BUT THE OUTPUT PRODUCED WHEN RUNNING THESE TESTS CAN BE HELPFUL
    // TO UNDERSTAND IF THERE ARE ISSUES IN YOUR CODE.

    @Test
    public void introspection_bestAnswerAlexaQAClient_hasConstructorWithClient() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
                "com.kenzie.alexaqa.BestAnswerAlexaQAClient");

        // WHEN
        Constructor<?> findBestAnswerMethod = null;
        try {
            findBestAnswerMethod = bestAnswerAlexaQAClientClass.getDeclaredConstructor(AlexaQA.class);
        } catch (NoSuchMethodException e) {
            try {
                findBestAnswerMethod = bestAnswerAlexaQAClientClass.getDeclaredConstructor(AlexaQAClient.class);
            } catch (NoSuchMethodException ex) {
                fail("Expected BestAnswerAlexaQAClient to have a constructor that accepts an AlexaQA object as its " +
                        "parameter. This is our best practice for composition. You'll learn more in mocking.");
            }
        }
    }

    @Test
    public void introspection_bestAnswerAlexaQAClient_hasFindBestAnswerMethod() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.BestAnswerAlexaQAClient");

        // WHEN
        Method findBestAnswerMethod = null;
        try {
            findBestAnswerMethod = bestAnswerAlexaQAClientClass.getDeclaredMethod(
                "findBestAnswer", AlexaQuestion.class);
        } catch (NoSuchMethodException e) {
            fail("Expected findBestAnswer method to exist in the BestAnswerAlexaQAClient class!");
        }

        // THEN
        Class<?> returnType = findBestAnswerMethod.getReturnType();
        assertTrue(returnType == AlexaAnswer.class,
            "Expected BestAnswerAlexaQAClient findBestAnswer method to have AlexaAnswer as return type!");
    }

    @Test
    public void introspection_bestAnswerAlexaQAClient_hasSubmitQuestionAnswerSuggestions() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.BestAnswerAlexaQAClient");

        // WHEN
        Method submitQuestionAnswerSuggestionsMethod = null;
        try {
            submitQuestionAnswerSuggestionsMethod = bestAnswerAlexaQAClientClass.getDeclaredMethod(
                "submitQuestionAnswerSuggestions", AlexaQuestion.class, List.class);
        } catch (NoSuchMethodException e) {
            fail("Expected submitQuestionAnswerSuggestions method to exist in the BestAnswerAlexaQAClient class!");
        }

        // THEN
        Class<?> returnType = submitQuestionAnswerSuggestionsMethod.getReturnType();
        assertTrue(returnType == void.class,
            "Expected BestAnswerAlexaQAClient submitQuestionAnswerSuggestions method to have void return type!");
    }

    @Test
    public void introspection_readOnlyAlexaQAClient_isNotAlexaQAClient() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.BestAnswerAlexaQAClient");

        // WHEN
        boolean isAlexaQAClient = AlexaQAClient.class.isAssignableFrom(bestAnswerAlexaQAClientClass);

        // THEN
        assertFalse(isAlexaQAClient, "Expected BestAnswerAlexaQAClient to not implement AlexaQAClient!");
    }

    private static Class<?> getClassForName(String fullyQualifiedClassName) {
        Class<?> classToReturn = null;
        try {
            classToReturn = Class.forName(fullyQualifiedClassName);
        } catch (ClassNotFoundException e) {
            fail("Expected " + fullyQualifiedClassName + " to exist in the project!");
        }
        return classToReturn;
    }

    @Test
    public void findBestAnswer_anyQuestion_expectedAnswer() {
        // GIVEN
    AlexaQA alexaQa = new AlexaQAClient();
        BestAnswerAlexaQAClient client = new BestAnswerAlexaQAClient(alexaQa);

        // WHEN
        AlexaAnswer answer = client.findBestAnswer(new AlexaQuestion("random question", 1L));

        // THEN
        try {
            assertEquals(0.18, answer.getAnswerQuality());
            assertEquals("May the Force be with you.", answer.getContent());
        } catch(NullPointerException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void submitQuestionsAnswersSuggestion_singleAnswer_expectedAnswer() {
        // GIVEN
        AlexaQA alexaQa = new AlexaQAClient();
        BestAnswerAlexaQAClient client = new BestAnswerAlexaQAClient(alexaQa);

        String questionContent = "Why did the chicken cross the road?";
        String answerContent = "To get to the other side!";
        AlexaQuestion question = new AlexaQuestion(questionContent, 1L);
        AlexaAnswer answer = new AlexaAnswer(answerContent, 0.99);

        // WHEN
        client.submitQuestionAnswerSuggestion(question, answer);

        AlexaAnswer answerForNewQuestion = client.findAnswers(question).get(0);

        // THEN
        assertEquals(0.99, answerForNewQuestion.getAnswerQuality());
        assertEquals(answerContent, answerForNewQuestion.getContent());
    }

    @Test
    public void submitQuestionsAnswersSuggestions_multipleAnswers_containsCorrectInformation() {
        // GIVEN
        AlexaQA alexaQa = new AlexaQAClient();
        BestAnswerAlexaQAClient client = new BestAnswerAlexaQAClient(alexaQa);

        String questionContent = "Why did the chicken cross the road?";
        String answerContent1 = "To get to the other side!";
        String answerContent2 = "Because it was hungry!";
        String answerContent3 = "To meet a friend!";
        AlexaQuestion question = new AlexaQuestion(questionContent, 1L);
        AlexaAnswer answer1 = new AlexaAnswer(answerContent1, 0.99);
        AlexaAnswer answer2 = new AlexaAnswer(answerContent2, 0.15);
        AlexaAnswer answer3 = new AlexaAnswer(answerContent3, 0.50);
        List<AlexaAnswer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        // WHEN
        client.submitQuestionAnswerSuggestions(question, answerList);
        List<AlexaAnswer> answersForNewQuestion = client.findAnswers(question);

        // THEN
        assertEquals(3, answersForNewQuestion.size());
        assertTrue(answersForNewQuestion.contains(answer1));
        assertTrue(answersForNewQuestion.contains(answer2));
        assertTrue(answersForNewQuestion.contains(answer3));
    }

    @Test
    public void findBestAnswer_multipleAnswers_expectedAnswer() {
        // GIVEN
        AlexaQA alexaQa = new AlexaQAClient();
        BestAnswerAlexaQAClient client = new BestAnswerAlexaQAClient(alexaQa);

        String questionContent = "Why did the chicken cross the road?";
        String answerContent1 = "To get to the other side!";
        String answerContent2 = "Because it was hungry!";
        String answerContent3 = "To meet a friend!";
        AlexaQuestion question = new AlexaQuestion(questionContent, 1L);
        AlexaAnswer answer1 = new AlexaAnswer(answerContent1, 0.99);
        AlexaAnswer answer2 = new AlexaAnswer(answerContent2, 0.15);
        AlexaAnswer answer3 = new AlexaAnswer(answerContent3, 0.50);
        List<AlexaAnswer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);

        // WHEN
        client.submitQuestionAnswerSuggestions(question, answerList);
        AlexaAnswer bestAnswerForNewQuestion = client.findBestAnswer(question);

        // THEN
        assertEquals(0.99, bestAnswerForNewQuestion.getAnswerQuality());
        assertEquals(answerContent1, bestAnswerForNewQuestion.getContent());
    }
}
