package com.github.newk5.java.portable.dialogs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ResourceExtractor {

    public ResourceExtractor() {
    }

    public String extract(String resourcePath) {

        resourcePath = isWindows() ? resourcePath + ".dll" : resourcePath + ".so";
        try {
            InputStream inputStream = ResourceExtractor.class.getClassLoader().getResourceAsStream(resourcePath);
            if (inputStream == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }

            Path tempFile = Files.createTempFile("temp_", System.nanoTime() + resourcePath);
            File f = tempFile.toFile();
            f.deleteOnExit(); 

            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

            return f.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win");
    }
}
