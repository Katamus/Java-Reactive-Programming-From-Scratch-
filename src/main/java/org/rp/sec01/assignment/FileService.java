package org.rp.sec01.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path resourceDirectory = Paths.get("src","main","resources","assignment","sec01");

    public static Mono<String> read(String fileName){
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<String> write(String fileName,String content){
        return Mono.fromRunnable(() -> writeFile(fileName,content));
    }

    public static Mono<String> delete(String fileName){
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    public static String readFile(String fileName){
        try {
            return Files.readString(resourceDirectory.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String fileName, String content){
        try {
            Files.writeString(resourceDirectory.resolve(fileName),content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(String fileName){
        try {
             Files.delete(resourceDirectory.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
