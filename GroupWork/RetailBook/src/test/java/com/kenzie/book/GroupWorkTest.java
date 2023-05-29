package com.kenzie.book;

import com.kenzie.book.ATATestHelpers.ATAFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.reflections.Reflections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.assertClassDiagramContainsClass;
import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.assertClassDiagramIncludesContainsRelationship;
import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.assertClassDiagramIncludesExtendsRelationship;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupWorkTest {

    private static final String BOOK_PACKAGE = "com.kenzie.book";
    private static final String CLASS_DIAGRAM_PATH = "src/main/java/com/kenzie/book";

    @Test
    void does_puml_file_exist() {
        // GIVEN - path to directory that .puml file should exist in
        List<String> filesWithPumlExtension = filesExistingInPathByExtension(CLASS_DIAGRAM_PATH, ".puml");

        boolean countOfFilesWithExtensionInDirectory = false;

        if(filesWithPumlExtension != null) {
            countOfFilesWithExtensionInDirectory = true;
        }
        // THEN - diagram includes these has-a relationships
        assertTrue(countOfFilesWithExtensionInDirectory);
    }

    @Test
    void only_one_puml_file_exist() {
        // GIVEN - path to directory that .puml file should exist in
        List<String> filesWithPumlExtension = filesExistingInPathByExtension(CLASS_DIAGRAM_PATH, ".puml");

        int countOfFilesWithExtensionInDirectoryCount = 0;

        if(filesWithPumlExtension != null) {
            countOfFilesWithExtensionInDirectoryCount = filesWithPumlExtension.size();
        }
        // THEN - diagram includes these has-a relationships
        assertTrue(countOfFilesWithExtensionInDirectoryCount == 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Book", "ProductInformation"})
    void groupwork_getClassDiagram_includesExpectedClasses(String expectedClass) {
        // GIVEN - directory where path should exist
        List<String> filesWithPumlExtension = filesExistingInPathByExtension(CLASS_DIAGRAM_PATH, ".puml");

        int countOfFilesWithExtensionInDirectoryCount = 0;

        if(filesWithPumlExtension != null) {
            countOfFilesWithExtensionInDirectoryCount = filesWithPumlExtension.size();
        }

        if(countOfFilesWithExtensionInDirectoryCount != 1) {
            try {
                throw new Exception("Only 1 puml file should exist in this project.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            // WHEN
            String content = getFileContentFromResources(filesWithPumlExtension.get(0));

            // THEN - contains each class
            assertClassDiagramContainsClass(content, expectedClass);
        }
    }

    @Test
    void groupwork_getClassDiagram_includesExpectedClasses_Plus_One_Additional_Class() {
        // GIVEN - directory where path should exist
        List<String> filesWithClassExtension = filesExistingInPathByExtension(CLASS_DIAGRAM_PATH, ".java");

        int countOfFilesWithExtensionInDirectoryCount = 0;

        if(filesWithClassExtension != null) {
            // WHEN
            countOfFilesWithExtensionInDirectoryCount = filesWithClassExtension.size();

            // THEN - package contains more than 2 class files
            assertTrue(countOfFilesWithExtensionInDirectoryCount > 2);
        }
    }

    @Test
    void groupwork_getClassDiagram_includesExpectedRelationships() {
        // GIVEN - directory where path should exist
        List<String> filesWithPumlExtension = filesExistingInPathByExtension(CLASS_DIAGRAM_PATH, ".puml");

        int countOfFilesWithExtensionInDirectoryCount = 0;

        if(filesWithPumlExtension != null) {
            countOfFilesWithExtensionInDirectoryCount = filesWithPumlExtension.size();
        }

        if(countOfFilesWithExtensionInDirectoryCount != 1) {
            try {
                throw new Exception("Only 1 puml file should exist in this project.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            // WHEN
            String content = getFileContentFromResources(filesWithPumlExtension.get(0));

            // THEN - diagram includes these has-a relationships
            assertClassDiagramIncludesContainsRelationship(content, "Book", "ProductInformation");
        }
    }

    private static String getFileContentFromResources(String filename) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            ATAFileReader fileReader = new ATAFileReader(filename);
            fileReader.readLines().forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Unable to find file: %s.", filename), e);
        }

        return contentBuilder.toString();
    }

    private static List<String> filesExistingInPathByExtension(String pathToSearch, String fileExtension) {

        Path path = Paths.get(pathToSearch);

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result = null;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}