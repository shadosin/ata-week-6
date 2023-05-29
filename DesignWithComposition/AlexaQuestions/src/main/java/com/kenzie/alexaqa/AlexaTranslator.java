package com.kenzie.alexaqa;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides fixed translations for the answers provided in the AlexaQAClient class.
 * The translations were created online with a free translator and shouldn't be considered as completely correct.
 */
public class AlexaTranslator {
    private final Map<String, String> translations;

    /**
     * Construct the translator instance and populate the translations map.
     */
    public AlexaTranslator() {
        translations = new HashMap<>();
        // NOTE: Translations taken from a free online translator - not a golden standard.
        translations.put("Sorry, I couldn't find an answer to that question.",
            "Lo siento, no pude encontrar una respuesta a esa pregunta.");
        translations.put("Frankly my dear, I don't give a damn.", "Francamente querida, me importa un comino.");
        translations.put("Are you talking to me?", "Estas hablando conmigo?");
        translations.put("Go ahead, make my day.", "Adelante, alegra mi día.");
        translations.put("42", "42");
        translations.put("May the Force be with you.", "Que la fuerza este con usted.");
        translations.put("You can't handle the truth!", "¡No puedes manejar la verdad!");
    }

    /**
     * Returns the translation for a given input or a default message if the given input is not found.
     * @param input the input string to translate
     * @return translation of the given input or a default message.
     */
    public String getTranslation(String input) {
        return translations.getOrDefault(input, "Sorry, I couldn't find the translation for the provided input!");
    }
}
