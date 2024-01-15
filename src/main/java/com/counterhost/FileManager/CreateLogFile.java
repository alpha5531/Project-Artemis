package com.counterhost.FileManager;
import com.counterhost.Loggers.exLog;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import static com.counterhost.StaticVariables.Time.getLocalDate;
import static com.counterhost.StaticVariables.Time.getLocalTime;

public class CreateLogFile {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static final BlockingQueue<Runnable> logQueue = new LinkedBlockingQueue<>();

    public CreateLogFile(String sciezka, String operation, String nazwaPliku) {
        logQueue.add(() -> writeLog(sciezka, operation, nazwaPliku));
        executor.submit(Objects.requireNonNull(logQueue.poll()));
    }

    private void writeLog(String sciezka, String operation, String nazwaPliku) {
        File f = new File(sciezka + getLocalDate() + nazwaPliku);
        Path p = Paths.get(sciezka + getLocalDate() + nazwaPliku);
        String s = System.lineSeparator() + "[" + getLocalDate() + "][" + getLocalTime() + "] " + operation;

        try {
            if(f.exists() && !f.isDirectory()) {
                try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, StandardOpenOption.APPEND))) {
                    out.write(s.getBytes());
                }
            } else {
                if(f.createNewFile()) {
                    try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, StandardOpenOption.APPEND))) {
                        out.write(s.getBytes());
                    }
                }
            }
        } catch (IOException e) {
            new exLog(e);
        }
    }
}
