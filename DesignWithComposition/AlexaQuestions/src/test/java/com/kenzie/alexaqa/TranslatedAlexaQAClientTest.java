package com.kenzie.alexaqa;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class TranslatedAlexaQAClientTest {

    // Introspective tests - YOU ARE NOT EXPECTED TO UNDERSTAND OR TOUCH THESE TESTS
    // AT THIS POINT, BUT THE OUTPUT PRODUCED WHEN RUNNING THESE TESTS CAN BE HELPFUL
    // TO UNDERSTAND IF THERE ARE ISSUES IN YOUR CODE.

    @Test
    public void introspection_translatedAlexaQAClient_hasConstructorWithClient() {
        // GIVEN
        Class<?> translatedAlexaQAClientClass = getClassForName(
                "com.kenzie.alexaqa.TranslatedAlexaQAClient");

        // WHEN
        Constructor<?> findBestAnswerMethod = null;
        try {
            findBestAnswerMethod = translatedAlexaQAClientClass.getDeclaredConstructor(AlexaQA.class, AlexaTranslator.class);
        } catch (NoSuchMethodException e) {
            try {
                findBestAnswerMethod = translatedAlexaQAClientClass.getDeclaredConstructor(BestAnswerAlexaQAClient.class, AlexaTranslator.class);
            } catch (NoSuchMethodException e2) {
                try {
                    findBestAnswerMethod = translatedAlexaQAClientClass.getDeclaredConstructor(AlexaTranslator.class, BestAnswerAlexaQAClient.class);
                } catch (NoSuchMethodException e3) {
                    try {
                        findBestAnswerMethod = translatedAlexaQAClientClass.getDeclaredConstructor(AlexaQA.class, BestAnswerAlexaQAClient.class);
                    } catch (NoSuchMethodException e4) {
                        fail("Expected TranslatedAlexaQAClient to have a constructor that accepts a BesetAnswerAlexaQAClient object and an AlexaTranslator object as its " +
                                "parameters. This is our best practice for composition. You'll learn more in mocking.");
                    }
                }
            }
        }
    }

    @Test
    public void introspection_translatedAlexaQAClient_hasFindBestAnswerAndTranslate() {
        // GIVEN
        Class<?> extendedAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.TranslatedAlexaQAClient");

        // WHEN
        Method findBestAnswerAndTranslateMethod = null;
        try {
            findBestAnswerAndTranslateMethod = extendedAlexaQAClientClass.getDeclaredMethod(
                "findBestAnswerAndTranslate", AlexaQuestion.class);
        } catch (NoSuchMethodException e) {
            fail("Expected findBestAnswerAndTranslate to exist in the TranslatedAlexaQAClient class!");
        }

        // THEN
        Class<?> returnType = findBestAnswerAndTranslateMethod.getReturnType();
        assertTrue(returnType == String.class,
            "Expected TranslatedAlexaQAClient findBestAnswerAndTranslate method to have String as return type!");
    }

    @Test
    public void introspection_translatedAlexaQAClient_isNotAlexaQAClient() {
        // GIVEN
        Class<?> extendedAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.TranslatedAlexaQAClient");

        // WHEN
        boolean isAlexaQAClient = AlexaQAClient.class.isAssignableFrom(extendedAlexaQAClientClass);

        // THEN
        assertFalse(isAlexaQAClient, "Expected TranslatedAlexaQAClient to not implement AlexaQAClient!");
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
    public void findBestAnswer_anyQuestion_expectedTranslation() {
        // GIVEN
        TranslatedAlexaQAClient client = new TranslatedAlexaQAClient(new BestAnswerAlexaQAClient(new AlexaQAClient()), new AlexaTranslator());

        // WHEN
        String answer = client.findBestAnswerAndTranslate(new AlexaQuestion("random question", 1L));

        // THEN
        assertEquals("Que la fuerza este con usted.", answer);
    }

}
