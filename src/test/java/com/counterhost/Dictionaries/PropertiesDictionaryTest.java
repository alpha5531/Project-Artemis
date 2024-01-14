package com.counterhost.Dictionaries;

import com.counterhost.ConfigOperator.PropertiesRead;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class PropertiesDictionaryTest {

    @org.junit.jupiter.api.Test
    void refreshPropertiesDictionary() {
        PropertiesRead original = PropertiesDictionary.properties;
        PropertiesDictionary.RefreshPropertiesDictionary();
        PropertiesRead refreshed = PropertiesDictionary.properties;
        assertNotSame(original, refreshed, "Metoda RefreshPropertiesDictionary nie utworzyła nowej instancji PropertiesRead.");
    }
}
