package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Your start-up's BA has told marketing that your website has a large audience
in Scandinavia and surrounding countries. Marketing thinks it would be great
to welcome visitors to the site in their own language.
Luckily you already use an API that detects the user's location, so this is an easy win.
The Task

    Think of a way to store the languages as a database (eg an object).
    The languages are listed below so you can copy and paste!
    Write a 'welcome' function that takes a parameter 'language' (always a string),
    and returns a greeting - if you have it in your database.
    It should default to English if the language is not in the database, or in the event of an invalid input.

The Database

english: "Welcome", czech: "Vitejte", danish: "Velkomst",
dutch: "Welkom", estonian: "Tere tulemast", finnish: "Tervetuloa",
flemish: "Welgekomen", french: "Bienvenue", german: "Willkommen",
irish: "Failte", italian: "Benvenuto", latvian: "Gaidits",
lithuanian: "Laukiamas", polish: "Witamy", spanish: "Bienvenido",
swedish: "Valkommen", welsh: "Croeso"

Possible invalid inputs include:

IP_ADDRESS_INVALID - not a valid ipv4 or ipv6 ip address
IP_ADDRESS_NOT_FOUND - ip address not in the database
IP_ADDRESS_REQUIRED - no ip address was supplied

Categories : Fundamentals, Hashes, Data Structures, Objects
 */
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