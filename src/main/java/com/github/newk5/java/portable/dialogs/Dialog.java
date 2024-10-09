package com.github.newk5.java.portable.dialogs;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dialog {
    
    static {
        ResourceExtractor extractor = new ResourceExtractor();
        System.load(extractor.extract("libjavaportabledialogs"));
    }
    
    private static native String nativeSelectFolder(String label, String path);
    
    public static File selectFolder(String label, String startingFolder) {
        if (label == null) {
            label = "Select folder";
        }
        if (startingFolder == null) {
            startingFolder = "";
        }
        String f = nativeSelectFolder(label, startingFolder);
        if (f == null) {
            return null;
        }
        return new File(f);
    }
    
    private static native String nativeSelectFile(String label, String path);
    
    private static native String nativeSelectFileFilters(String label, String path, String filters);
    
    private static native String nativeSaveToFolder(String label, String path);
    
    public static File save(String label, String filePath) {
        if (label == null) {
            label = "Select file";
        }
        if (filePath == null) {
            filePath = "";
        }
        String f = nativeSaveToFolder(label, filePath);
        if (f == null) {
            return null;
        }
        return new File(f);
    }
    
    private static native String nativeSaveToFolderFilters(String label, String path, String filters);
    
    public static File save(String label, String filePath, String... filters) {
        if (label == null) {
            label = "Select file";
        }
        if (filePath == null) {
            filePath = "";
        }
        String f = nativeSaveToFolderFilters(label, filePath, String.join(",", filters));
        if (f == null) {
            return null;
        }
        return new File(f);
    }
    
    public static File selectFile(String label, String startingFolder) {
        if (label == null) {
            label = "Select file";
        }
        if (startingFolder == null) {
            startingFolder = "";
        }
        String f = nativeSelectFile(label, startingFolder);
        if (f == null) {
            return null;
        }
        return new File(f);
    }
    
    public static File selectFile(String label, String startingFolder, String... filters) {
        if (label == null) {
            label = "Select file";
        }
        if (startingFolder == null) {
            startingFolder = "";
        }
        String f = nativeSelectFileFilters(label, startingFolder, String.join(",", filters));
        if (f == null) {
            return null;
        }
        return new File(f);
    }
    
    private static native String nativeSelectMultiFile(String label, String path);
    
    private static native String nativeSelectMultiFileFilters(String label, String path, String filters);
    
    public static List<File> selectFiles(String label, String startingFolder, String... filters) {
        if (label == null) {
            label = "Select file";
        }
        if (startingFolder == null) {
            startingFolder = "";
        }
        String files = nativeSelectMultiFileFilters(label, startingFolder, String.join(",", filters));
        if (files == null) {
            return Collections.EMPTY_LIST;
        }
        List<String> lst = Arrays.asList(files.split(","));
        List<File> filesList = new ArrayList<>(lst.size());
        for (String str : lst) {
            filesList.add(new File(str));
        }
        return filesList;
    }
    
    public static List<File> selectFiles(String label, String startingFolder) {
        if (label == null) {
            label = "Select file";
        }
        if (startingFolder == null) {
            startingFolder = "";
        }
        String files = nativeSelectMultiFile(label, startingFolder);
        if (files == null) {
            return Collections.EMPTY_LIST;
        }
        List<String> lst = Arrays.asList(files.split(","));
        List<File> filesList = new ArrayList<>(lst.size());
        for (String str : lst) {
            filesList.add(new File(str));
        }
        return filesList;
    }
}
