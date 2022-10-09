package org.francd.protobuf;

import com.google.protobuf.Int32Value;
import org.francd.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {

    public static void main(String[] args) throws IOException {

        Person fulanito = Person.newBuilder()
                .setName("Fulanito")
                //.setAge(33)
                .setAge(Int32Value.of(33))
                .build();
        System.out.println(fulanito);

        //serialize
        Path path = Paths.get("Fulanito.ser");
        Files.write(path, fulanito.toByteArray());

        //deserialize
        byte[] personBytes = Files.readAllBytes(path);
        Person person = Person.parseFrom(personBytes);

        System.out.println("Deserialized person is the same: "+fulanito.equals(person));
    }
}

