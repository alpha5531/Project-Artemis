package com.counterhost.Dictionaries;

import com.counterhost.ConfigOperator.PropertiesRead;

public class PropertiesDictionary {
    public static PropertiesRead properties = new PropertiesRead();
    public static void RefreshPropertiesDictionary()
    {
        properties = new PropertiesRead();
    }
}
