package com.counterhost.Loggers;

import com.counterhost.FileManager.CreateLogFile;
import static com.counterhost.Dictionaries.PropertiesDictionary.properties;

public class exLog {
    String sciezkaLogow = properties.getSciezkaLogow();
    public exLog(Throwable exe) {
        saveToLog(exe);
    }
    private void saveToLog(Throwable problem){
        try {
                new CreateLogFile(sciezkaLogow, problem.toString(), "_exception.log");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
    }
}