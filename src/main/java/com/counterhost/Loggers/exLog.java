package com.counterhost.Loggers;

import com.counterhost.FileManager.CreateLogFile;
import static com.counterhost.Dictionaries.PropertiesDictionary.properties;

public class exLog {
    String sciezkaLogow = properties.getSciezkaLogow();
    public exLog(Throwable exe) {
        saveToLog(exe);
    }
    public exLog(String name,Throwable exe) {
        saveToLog(name,exe);
    }
    private void saveToLog(Throwable problem){
        try {
                new CreateLogFile(sciezkaLogow, problem.toString(), "_exception.log");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
    }
    private void saveToLog(String ClassName,Throwable problem){
        try {
            new CreateLogFile(sciezkaLogow, problem.toString(), "_exception.log");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}