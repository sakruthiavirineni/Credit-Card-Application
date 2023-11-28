package com.sakruthi;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class Utils {
    public static void validatePaths(String input_path, String output_path) {
        validateInputPathExists(input_path);
        validateFileExtension(input_path, output_path);
    }

    public static void validateInputPathExists(String input_path) {
        File file = new File(input_path);
        if (!file.isFile()) {
            throw new RuntimeException("Input path doesn't exist");
        }
    }

    public static void validateFileExtension(String input_path, String output_path) {
        String inputExtension = FilenameUtils.getExtension(input_path);
        String outputExtension = FilenameUtils.getExtension(output_path);
        if (!inputExtension.equals(outputExtension)) {
            throw new RuntimeException("Extensions of Input and Output should be the same");
        }
    }
}