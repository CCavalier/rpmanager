package com.potatoes.rpmanager.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileService {
    public Path copyFile(String fileUrl, String folderToCopy) throws IOException {
        Path source = Paths.get(fileUrl);
        Path target = Paths.get(folderToCopy);
        var dest = Files.copy(source, target, REPLACE_EXISTING);
        return dest;
    }
}
