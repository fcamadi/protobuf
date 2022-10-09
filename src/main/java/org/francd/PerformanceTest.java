package org.francd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import org.francd.json.PersonDto;
import org.francd.model.Person;

import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {

        //JSON
        PersonDto jsonPerson = new PersonDto();
        jsonPerson.setName("JsonPerson");
        jsonPerson.setAge(44);

        ObjectMapper mapper = new ObjectMapper();

        Runnable runnableJson = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(jsonPerson);
                PersonDto personDtoRead = mapper.readValue(bytes, PersonDto.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        //Protobuf
        Person personProto = Person.newBuilder()
                .setName("ProtPerson")
                .setAge(Int32Value.of(44))
                .build();

        Runnable runnableProtobuf = () -> {
            try {
                byte[] bytes = personProto.toByteArray();
                Person personProtoRead = Person.parseFrom(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        runPerformanceTest(runnableProtobuf, "Protobuf");
        runPerformanceTest(runnableJson, "JSON");
    }

    public static void runPerformanceTest(Runnable runnable, String method) {

        long startTime = System.currentTimeMillis();
        for (int i=0; i < 1_000_000; i++) {
            runnable.run();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(method + " : " + (endTime - startTime) + " ms");
    }
}
