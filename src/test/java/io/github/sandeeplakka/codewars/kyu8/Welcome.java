package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Welcome {

    @Test
    public void exampleTest() {
        assertEquals("Welcome", greet("english"), "Your function should have returned 'Welcome'. Try again.");
        assertEquals("Welkom", greet("dutch"), "Your function should have returned 'Welkom'. Try again.");
        assertEquals("Welcome", greet("IP_ADDRESS_INVALID"), "Your function should have returned 'Welcome'. Try again.");
    }

    public Welcome() {
        load();
    }

    private static Map<String, Map<String, String>> translations = new HashMap<>();

    private static void load() {
        Map<String, String> welcomeTranslations = new HashMap<>();
        welcomeTranslations.put("english", "Welcome");
        welcomeTranslations.put("czech", "Vitejte");
        welcomeTranslations.put("danish", "Velkomst");
        welcomeTranslations.put("dutch", "Welkom");
        welcomeTranslations.put("estonian", "Tere tulemast");
        welcomeTranslations.put("finnish", "Tervetuloa");
        welcomeTranslations.put("flemish", "Welgekomen");
        welcomeTranslations.put("french", "Bienvenue");
        welcomeTranslations.put("german", "Willkommen");
        welcomeTranslations.put("irish", "Failte");
        welcomeTranslations.put("italian", "Benvenuto");
        welcomeTranslations.put("latvian", "Gaidits");
        welcomeTranslations.put("lithuanian", "Laukiamas");
        welcomeTranslations.put("polish", "Witamy");
        welcomeTranslations.put("spanish", "Bienvenido");
        welcomeTranslations.put("swedish", "Valkommen");
        welcomeTranslations.put("welsh", "Croeso");
        translations.put("Welcome", welcomeTranslations);
    }

    public static String greet(String language) {
        // your code
        return translations.get("Welcome").getOrDefault(language, translations.get("Welcome").get("english"));
    }
}