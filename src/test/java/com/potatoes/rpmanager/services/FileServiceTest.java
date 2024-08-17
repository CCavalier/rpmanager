package com.potatoes.rpmanager.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceTest {

    public static final String FILE_URL = "tests/fileToCopy.txt";

    @Test
    public void shouldCopyFile() throws URISyntaxException, IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var url = classloader.getResource(FILE_URL);
        FileService fs = new FileService();
        assert url != null;
        StringBuilder sb = new StringBuilder();

        var uriPath =Paths.get(url.toURI()).toString();

        String folderPath = uriPath.substring(0,url.getPath().length()-(FILE_URL.length()+1));
        sb.append(folderPath).append("tests/fileCopied.txt");

        var pathNewFile = fs.copyFile(uriPath, sb.toString());
        assertTrue(Files.exists(pathNewFile));

        try {
            Files.delete(pathNewFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
