package org.francd.protobuf;

import org.francd.model.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

        Television sany = Television.newBuilder()
                .setBrand("sany")
                //.setYear(2020)
                .build();

        Path pathV1 = Paths.get("tv-v1");
        Files.write(pathV1, sany.toByteArray());

        //
        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println("Television from bytes:\n "+Television.parseFrom(bytes));
    }
}
