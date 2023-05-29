package com.kenzie.alexaqa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlexaTranslatorTest {
    @Test
    public void getTranslation_existingTranslation_correctTranslationReturned() {
        // GIVEN
        AlexaTranslator translator = new AlexaTranslator();

        // WHEN
        String translation = translator.getTranslation("Sorry, I couldn't find an answer to that question.");

        // THEN
        assertEquals(translation, "Lo siento, no pude encontrar una respuesta a esa pregunta.");
    }

    @Test
    public void getTranslation_missingTranslation_defaultTranslationReturned() {
        // GIVEN
        AlexaTranslator translator = new AlexaTranslator();

        // WHEN
        String translation = translator.getTranslation("Random input...");

        // THEN
        assertEquals(translation, "Sorry, I couldn't find the translation for the provided input!");
    }
}
