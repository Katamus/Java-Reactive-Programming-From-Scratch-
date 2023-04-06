package org.rp.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    private Callable<BufferedReader>  openReader(Path path){
        return ()-> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read(){
        return (br, stringSynchronousSink) -> {
            try {
                String line  = br.readLine();
                if(Objects.isNull(line)){
                    stringSynchronousSink.complete();
                }else {
                    stringSynchronousSink.next(line);
                }
            } catch (IOException e) {
                stringSynchronousSink.error(e);
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader(){
        return bufferedReader -> {
            try {
                System.out.println("closed");
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public Flux<String> read(Path path){
        return Flux.generate(
                openReader(path),
                read(),
                closeReader()
        );
    }

}
