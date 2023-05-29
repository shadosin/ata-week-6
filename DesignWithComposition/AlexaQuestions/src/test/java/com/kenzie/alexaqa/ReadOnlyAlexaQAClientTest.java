package com.kenzie.alexaqa;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadOnlyAlexaQAClientTest {

    // Introspective tests - YOU ARE NOT EXPECTED TO UNDERSTAND OR TOUCH THESE TESTS
    // AT THIS POINT, BUT THE OUTPUT PRODUCED WHEN RUNNING THESE TESTS CAN BE HELPFUL
    // TO UNDERSTAND IF THERE ARE ISSUES IN YOUR CODE.
    @Test
    public void introspection_readOnlyAlexaQAClient_hasConstructorWithClient() {
        // GIVEN
        Class<?> readOnlyAlexaQAClientClass = getClassForName(
                "com.kenzie.alexaqa.ReadOnlyAlexaQAClient");

        // WHEN
        Constructor<?> findBestAnswerMethod = null;
        try {
            findBestAnswerMethod = readOnlyAlexaQAClientClass.getDeclaredConstructor(AlexaQA.class);
        } catch (NoSuchMethodException e) {
            try {
                findBestAnswerMethod = readOnlyAlexaQAClientClass.getDeclaredConstructor(AlexaQAClient.class);
            } catch (NoSuchMethodException ex) {
                fail("Expected BestAnswerAlexaQAClient to have a constructor that accepts an AlexaQA object as its " +
                        "parameter. This is our best practice for composition. You'll learn more in mocking.");
            }
        }
    }

    @Test
    public void introspection_readOnlyAlexaQAClient_hasASinglePublicMethod() {
        // GIVEN
        Class<?> readOnlyAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.ReadOnlyAlexaQAClient");

        // WHEN
        Method[] publicMethods = Arrays.stream(readOnlyAlexaQAClientClass.getDeclaredMethods())
            .filter(method -> Modifier.isPublic(method.getModifiers()))
            .toArray(Method[]::new);

        // THEN
        assertTrue(1 == publicMethods.length, "Expected ReadOnlyAlexaQAClient to have a single public method!");

        Class<?> returnType = publicMethods[0].getReturnType();
        assertTrue(returnType == List.class,
            "Expected ReadOnlyAlexaQAClient public method to have List as return type!");

        Class<?>[] parameterTypes = publicMethods[0].getParameterTypes();
        assertTrue(1 == parameterTypes.length && parameterTypes[0] == AlexaQuestion.class,
            "Expected ReadOnlyAlexaQAClient public method to take single parameter of AlexaQuestion type!");
    }

    @Test
    public void introspection_readOnlyAlexaQAClient_isNotAlexaQAClient() {
        // GIVEN
        Class<?> readOnlyAlexaQAClientClass = getClassForName(
            "com.kenzie.alexaqa.ReadOnlyAlexaQAClient");

        // WHEN
        boolean isAlexaQAClient = AlexaQAClient.class.isAssignableFrom(readOnlyAlexaQAClientClass);

        // THEN
        assertFalse(isAlexaQAClient, "Expected ReadOnlyAlexaQAClient to not implement AlexaQAClient!");
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
    public void findAnswers_anyQuestion_expectedNumberOfAnswers() {
        // GIVEN
        ReadOnlyAlexaQAClient client = new ReadOnlyAlexaQAClient(new AlexaQAClient());

        // WHEN
        List<AlexaAnswer> answers = client.findAnswers(new AlexaQuestion("random question", 1L));

        // THEN
        try {
            assertEquals(6, answers.size());
        } catch(NullPointerException e){
            fail(e.getMessage());
        }
    }
}
