package com.counterhost.Dictionaries;

import com.counterhost.ConfigOperator.PropertiesRead;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class PropertiesDictionaryTest {

    @org.junit.jupiter.api.Test
    void refreshPropertiesDictionary() {
        // Pobierz obecną instancję PropertiesRead
        PropertiesRead original = PropertiesDictionary.properties;

        // Odśwież słownik właściwości
        PropertiesDictionary.RefreshPropertiesDictionary();

        // Pobierz nową instancję PropertiesRead
        PropertiesRead refreshed = PropertiesDictionary.properties;

        // Sprawdź, czy obie instancje są różne
        assertNotSame(original, refreshed, "Metoda RefreshPropertiesDictionary nie utworzyła nowej instancji PropertiesRead.");
    }
}
